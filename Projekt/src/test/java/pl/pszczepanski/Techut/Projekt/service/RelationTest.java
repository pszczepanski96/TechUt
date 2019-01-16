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
import pl.pszczepanski.TechUt.Projekt.domain.Serial;
import pl.pszczepanski.TechUt.Projekt.domain.Shoe;
import pl.pszczepanski.TechUt.Projekt.domain.Wearer;
import pl.pszczepanski.TechUt.Projekt.service.ProjectManager;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class RelationTest {

    @Autowired
    ProjectManager projectManager;

    @Autowired
    SessionFactory sf;

    @Test
    public void giveSerialNrTest(){

        Serial serial = new Serial("54124");
        Shoe shoe = new Shoe("Airmax", 45);
        projectManager.addShoe(shoe);
        projectManager.addSerial(serial);
        projectManager.giveSerialNr(serial.getID(), shoe.getID());
        assertEquals(shoe.getSerialNumber().getID(), serial.getID());

    }

    @Test
    public void giveProducerTest(){

        Producent producent = new Producent("Nike", "USA");
        Shoe shoe = new Shoe("Airmax", 45);
        Shoe shoe2 = new Shoe("Jordan", 45);
        projectManager.addShoe(shoe);
        projectManager.addShoe(shoe2);
        projectManager.addProducent(producent);
        projectManager.giveProducer(producent.getID(), shoe.getID());
        assertEquals(shoe.getCompany().getID(), producent.getID());
        projectManager.giveProducer(producent.getID(), shoe2.getID());
        assertEquals(shoe2.getCompany().getID(), producent.getID());


    }

    @Test
    public void giveShoeAWearer(){
        Wearer wearer = new Wearer("Johny", 1990);
        Wearer wearer2 = new Wearer("Abraham", 1950);
        Shoe shoe = new Shoe("Airmax", 45);
        Shoe shoe2 = new Shoe("Mercurial", 45);
        projectManager.addShoe(shoe);
        projectManager.addShoe(shoe2);
        projectManager.addWearer(wearer);
        projectManager.addWearer(wearer2);

        List<Wearer> wearersShoeOneBefore = projectManager.getShoeWearers(shoe);
        List<Wearer> wearersShoeTwoBefore = projectManager.getShoeWearers(shoe2);
        int beforeShoe = wearersShoeOneBefore.size();
        int beforeShoe2 = wearersShoeTwoBefore.size();

        projectManager.giveShoeAWearer(wearer.getID(), shoe.getID());
        projectManager.giveShoeAWearer(wearer2.getID(), shoe.getID());
        projectManager.giveShoeAWearer(wearer.getID(), shoe2.getID());
        projectManager.giveShoeAWearer(wearer2.getID(), shoe2.getID());

        List<Wearer> wearersShoeOneAfter = projectManager.getShoeWearers(shoe);
        List<Wearer> wearersShoeTwoAfter = projectManager.getShoeWearers(shoe2);
        int afterShoe = wearersShoeOneAfter.size();
        int afterShoe2 = wearersShoeTwoAfter.size();

        assertEquals(beforeShoe + 2, afterShoe);
        assertEquals(beforeShoe2 + 2, afterShoe2);
        assertEquals(shoe.getPerson().get(afterShoe-2).getName(), wearer.getName());
        assertEquals(shoe.getPerson().get(afterShoe-1).getName(), wearer2.getName());
        assertEquals(shoe.getPerson().get(afterShoe2-2).getName(), wearer.getName());
        assertEquals(shoe.getPerson().get(afterShoe2-1).getName(), wearer2.getName());


    }


}
