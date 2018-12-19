package pl.pszczepanski.TechUt.Zad05.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Zad05.domain.Producent;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional

public class ProducentTest {

    @Autowired
    ProducentManager pm;

    @Autowired
    ShoeManager sm;

    @Test
    public void addProducentTest(){

        Producent producent = new Producent("Nike");

        pm.addProducent(producent);

        Producent retrieved = pm.findById(producent.getID());

        assertEquals(producent.getID(), retrieved.getID());

    }

    @Test
    public void getAllProducentsTest(){

        List<Producent> listBefore = pm.getAllProducents();

        Producent producent1 = new Producent("Nike");
        Producent producent2 = new Producent("Adidas");

        pm.addProducent(producent1);
        pm.addProducent(producent2);

        List<Producent> listAfter = pm.getAllProducents();
        assertEquals(listBefore.size() + 2, listAfter.size());
    }

    @Test
    public void  findProducentBuIdTest(){

        Producent producent = new Producent("Reebok");
        pm.addProducent(producent);

        long id = producent.getID();

        Producent test = pm.findById(id);

        assertEquals(producent.getID(), test.getID());
        

    }


}
