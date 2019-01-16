package pl.pszczepanski.TechUt.Projekt.service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Projekt.domain.Producent;
import pl.pszczepanski.TechUt.Projekt.domain.Serial;
import pl.pszczepanski.TechUt.Projekt.domain.Shoe;
import pl.pszczepanski.TechUt.Projekt.domain.Wearer;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ProjectManagerHibernateImpl implements ProjectManager{


    @Autowired
    private SessionFactory sf;


    @Override
    public void addSerial(Serial serial) {
        sf.getCurrentSession().save(serial);
    }

    @Override
    public List<Serial> getAllSerials() {
        return sf.getCurrentSession().getNamedQuery("serial.all").list();
    }


    @Override
    public void addProducent(Producent producent) {
        sf.getCurrentSession().save(producent);
    }
    @Override
    public void updateProducent(Producent producent) {
        sf.getCurrentSession().update(producent);
    }
    @Override
    public void deleteProducer(long id) {
        Producent producent = findProducerById(id);
        sf.getCurrentSession().delete(producent);
    }
    @Override
    public Producent findProducerById(long id) {
        return (Producent) sf.getCurrentSession().get(Producent.class, id);
    }
    @Override
    public List<Producent> getAllProducents() {
        return sf.getCurrentSession().getNamedQuery("producer.all").list();
    }
    @Override
    public void deleteAllProducents() {
        sf.getCurrentSession().createSQLQuery("delete from Producent").executeUpdate();
    }

    @Override
    public void addWearer(Wearer wearer) {
        sf.getCurrentSession().save(wearer);
    }
    @Override
    public void deleteWearerByName(String name) {
        Query query = sf.getCurrentSession().createQuery("from Wearer where name=:name");
        query.setParameter("name", name);
        Wearer wearer = (Wearer) query.uniqueResult();
        sf.getCurrentSession().delete(wearer);
    }
    @Override
    public List<Wearer> getAllWearers() {
        return sf.getCurrentSession().getNamedQuery("wearer.all").list();

    }
    @Override
    public void deleteAllWearers() {
        sf.getCurrentSession().createSQLQuery("delete from Wearer").executeUpdate();
    }


    @Override
    public void addShoe(Shoe shoe) {
        sf.getCurrentSession().save(shoe);
    }
    @Override
    public void deleteShoe(long id) {
        Shoe shoe = findShoeById(id);
        sf.getCurrentSession().delete(shoe);
    }
    @Override
    public void updateShoe(Shoe shoe) {
        sf.getCurrentSession().update(shoe);
    }

    @Override
    public Shoe findShoeById(long id) {
        return (Shoe) sf.getCurrentSession().get(Shoe.class, id);
    }

    @Override
    public Shoe findShoeByName(String name) {
        Query query = sf.getCurrentSession().createQuery("from Shoe where name=:name");
        query.setParameter("name", name);
        Shoe shoe = (Shoe) query.uniqueResult();
        return shoe;

    }
    @Override
    public List<Shoe> getAllShoes() {
        return sf.getCurrentSession().getNamedQuery("shoe.all").list();
    }

    @Override
    public void giveSerialNr(long serialId, long shoeId) {

        Serial serial = (Serial) sf.getCurrentSession().get(Serial.class, serialId);
        Shoe shoe = (Shoe) sf.getCurrentSession().get(Shoe.class, shoeId);
        shoe.setSerialNumber(serial);

    }

    @Override
    public void giveProducer(long producerId, long shoeId) {
        Producent producent = (Producent) sf.getCurrentSession().get(Producent.class, producerId);
        Shoe shoe = (Shoe) sf.getCurrentSession().get(Shoe.class, shoeId);
        shoe.setCompany(producent);
    }

    @Override
    public List<Wearer>getShoeWearers(Shoe shoe) {
        shoe = (Shoe) sf.getCurrentSession().get(Shoe.class, shoe.getID());
        List<Wearer> wearers = new ArrayList<Wearer>(shoe.getPerson());
        return wearers;
    }

    @Override
    public void giveShoeAWearer(long wearerId, long shoeId) {
        Wearer wearer = (Wearer) sf.getCurrentSession().get(Wearer.class, wearerId);
        Shoe shoe = findShoeById(shoeId);
        shoe.getPerson().add(wearer);
    }


}
