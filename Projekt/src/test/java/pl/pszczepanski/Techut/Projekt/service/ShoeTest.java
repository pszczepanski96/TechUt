package pl.pszczepanski.Techut.Projekt.service;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Projekt.domain.Shoe;
import pl.pszczepanski.TechUt.Projekt.service.ProjectManager;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ShoeTest {

    @Autowired
    ProjectManager projectManager;

    @Autowired
    private SessionFactory sf;

    @Test
    public void addShoeTest(){
        Shoe shoe = new Shoe("Superstar", 43 );
        List<Shoe> allShoes = projectManager.getAllShoes();
        int before = allShoes.size();
        projectManager.addShoe(shoe);
        List<Shoe> allShoes2 = projectManager.getAllShoes();
        int after = allShoes2.size();
        assertEquals(after, before + 1);

    }

    @Test
    public void updateShoeTest(){

        Shoe shoe1 = new Shoe("Superstar", 45 );
        projectManager.addShoe(shoe1);
        int size = 44;
        shoe1.setSize(size);
        projectManager.updateShoe(shoe1);
        assertEquals(shoe1.getSize(), size);

    }

    @Test
    public void deleteShoeTest(){
        Shoe shoe2 = new Shoe("Superstar", 40 );
        projectManager.addShoe(shoe2);
        List<Shoe> allShoes = projectManager.getAllShoes();
        int before = allShoes.size();
        long id = shoe2.getID();
        projectManager.deleteShoe(id);
        List<Shoe> allShoes2 = projectManager.getAllShoes();
        int after = allShoes2.size();
        assertEquals(after, before - 1);
    }

    @Test
    public void findByIdTest(){

        Shoe shoe3 = new Shoe("Mercurial", 41);
        projectManager.addShoe(shoe3);
        Shoe shoeTest = projectManager.findShoeById(shoe3.getID());
        assertEquals(shoe3.getID(),shoeTest.getID());

    }

    @Test
    public void findByNameTest(){
        Shoe shoe4 = new Shoe("Predator", 44);
        projectManager.addShoe(shoe4);
        Shoe shoeTest = projectManager.findShoeByName(shoe4.getName());
        assertEquals(shoe4.getName(), shoeTest.getName());

    }

    @Test
    public void getAllTest(){
        List<Shoe> allShoes = projectManager.getAllShoes();
        int before = allShoes.size();
        Shoe shoe5 = new Shoe("Street", 35);
        projectManager.addShoe(shoe5);
        List<Shoe> allShoes2 = projectManager.getAllShoes();
        int after = allShoes2.size();
        assertEquals(after, before + 1);

    }

}
