package pl.pszczepanski.TechUt.Zad05.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Zad05.domain.Shoe;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional

public class ShoeTest {

    @Autowired
    ShoeManager sm;

    @Test
    public void addShoeTest(){

        Shoe shoe = new Shoe("Airmax", 43);
        sm.addShoe(shoe);

        Shoe retrieved = sm.findById(shoe.getID());

        assertEquals(shoe.getID(), retrieved.getID());

    }

    @Test
    public void getAllTest(){

        List<Shoe> ListBefore = sm.getAll();

        Shoe shoe1 = new Shoe("Superstar", 33);
        Shoe shoe2 = new Shoe("Street", 40);

        sm.addShoe(shoe1);
        sm.addShoe(shoe2);

        List<Shoe> ListAfter = sm.getAll();

        assertEquals(ListBefore.size() + 2, ListAfter.size());

    }

    @Test
    public void findByIdTest(){

        Shoe shoe = new Shoe("Orogonals", 41);
        sm.addShoe(shoe);

        long id = shoe.getID();

        Shoe test = sm.findById(id);

        assertEquals(shoe.getID(), test.getID());

    }
}
