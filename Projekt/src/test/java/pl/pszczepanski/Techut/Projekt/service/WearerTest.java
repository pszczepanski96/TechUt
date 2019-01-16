package pl.pszczepanski.Techut.Projekt.service;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Projekt.domain.Producent;
import pl.pszczepanski.TechUt.Projekt.domain.Wearer;
import pl.pszczepanski.TechUt.Projekt.service.ProjectManager;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional

public class WearerTest {
    @Autowired
    ProjectManager projectManager;

    @Autowired
    private SessionFactory sf;

    @Test
    public void addWearerTest(){

        Wearer wearer  = new Wearer("James", 1990 );
        List<Wearer> allWearers = projectManager.getAllWearers();
        int before = allWearers.size();
        projectManager.addWearer(wearer);
        List<Wearer> allWearers2 = projectManager.getAllWearers();
        int after = allWearers2.size();

        assertEquals(after, before + 1);

    }

    @Test
    public void deleteWearerTest(){

        Wearer wearer1  = new Wearer("James", 1991 );
        projectManager.addWearer(wearer1);
        List<Wearer> allWearers = projectManager.getAllWearers();
        int before = allWearers.size();
        projectManager.deleteWearerByName(wearer1.getName());
        List<Wearer> allWearers2 = projectManager.getAllWearers();
        int after = allWearers2.size();

        assertEquals(after, before - 1);
    }

    @Test
    public void deletAllTest(){

        Wearer wearer2 = new Wearer("John", 1995);
        projectManager.addWearer(wearer2);
        List<Wearer> allWearers = projectManager.getAllWearers();
        int before = allWearers.size();
        projectManager.deleteAllWearers();
        List<Wearer> allWearers2 = projectManager.getAllWearers();
        int after = allWearers2.size();

        assertEquals(after, before - 1);

    }

    @Test
    public void getAllTest(){

        List<Wearer> allWearers = projectManager.getAllWearers();
        int before = allWearers.size();

        Wearer wearer3 = new Wearer("Rob", 1985);
        projectManager.addWearer(wearer3);

        List<Wearer> allWearers2 = projectManager.getAllWearers();
        int after = allWearers2.size();

        assertEquals(after, before + 1);

    }
}
