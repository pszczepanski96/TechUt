package pl.pszczepanski.Techut.Projekt.service;


import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Projekt.domain.Serial;
import pl.pszczepanski.TechUt.Projekt.service.ProjectManager;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SerialTest {

    @Autowired
    ProjectManager projectManager;

    @Autowired
    private SessionFactory sf;

    @Test
    public void addSerialTest(){
        Serial serial = new Serial("12345");
        List<Serial> allSerials = projectManager.getAllSerials();
        int before = allSerials.size();
        projectManager.addSerial(serial);
        List<Serial> allSerials2 = projectManager.getAllSerials();
        int after = allSerials2.size();
        assertEquals(after, before + 1);
    }
}
