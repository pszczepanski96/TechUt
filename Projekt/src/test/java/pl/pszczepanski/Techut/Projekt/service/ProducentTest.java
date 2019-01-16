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
import pl.pszczepanski.TechUt.Projekt.service.ProjectManager;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProducentTest {

    @Autowired
    ProjectManager projectManager;

    @Autowired
    private SessionFactory sf;

    @Test
    public void addProducentTest(){
        List<Producent> allProducents = sf.getCurrentSession().getNamedQuery("producer.all").list();
        int before = allProducents.size();
        Producent producent = new Producent("Adidas", "Germany" );
        projectManager.addProducent(producent);
        List<Producent> allProducents2 = sf.getCurrentSession().getNamedQuery("producer.all").list();
        int after = allProducents2.size();
        assertEquals(after, before + 1);

    }

    @Test
    public void updateProducerTest(){

        Producent producent1 = new Producent("Nike","United States");
        projectManager.addProducent(producent1);
        String country = "USA";
        producent1.setCountry(country);
        projectManager.updateProducent(producent1);
        assertEquals(producent1.getCountry(), country);

    }
    @Test
    public void deleteProducentTest(){

        Producent producent2 = new Producent("Reebok","Great Britain");
        projectManager.addProducent(producent2);
        List<Producent> allProducents = sf.getCurrentSession().getNamedQuery("producer.all").list();
        int before = allProducents.size();
        projectManager.deleteProducer(producent2.getID());
        List<Producent> allProducents2 = sf.getCurrentSession().getNamedQuery("producer.all").list();
        int after = allProducents2.size();
        assertEquals(after, before - 1);

    }

    @Test
    public void findByIdTest(){

        Producent producent3 = new Producent("Umbro", "Great Britain");
        projectManager.addProducent(producent3);
        Producent producentTest = projectManager.findProducerById(producent3.getID());
        assertEquals(producent3.getID(),producentTest.getID());

    }

    @Test
    public void getAllTest(){

        List<Producent> allProducers = projectManager.getAllProducents();
        int before = allProducers.size();
        Producent producent4 = new Producent("Puma", "Germany");
        projectManager.addProducent(producent4);
        List<Producent> allProducers2 = projectManager.getAllProducents();
        int after = allProducers2.size();
        assertEquals(after, before + 1);

    }

    @Test
    public void deleteAllTest(){

        Producent producent5 = new Producent("Kappa", "Italy");
        projectManager.addProducent(producent5);
        List<Producent> allProducers = projectManager.getAllProducents();
        int before = allProducers.size();
        projectManager.deleteAllProducents();
        List<Producent> allProducers2 = projectManager.getAllProducents();
        int after = allProducers2.size();
        assertEquals(after, before - 1);

    }
}
