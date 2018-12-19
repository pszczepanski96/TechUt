package pl.pszczepanski.TechUt.Zad05.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.pszczepanski.TechUt.Zad05.domain.Producent;


import java.util.List;
@Component
@Transactional
public class ProducentManagerHibernateImpl implements ProducentManager{

    @Autowired
    SessionFactory sf;


    @Override
    public void addProducent(Producent producent) {
        sf.getCurrentSession().save(producent);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Producent> getAllProducents() {
        return sf.getCurrentSession().getNamedQuery("producent.all").list();
    }

    @Override
    public Producent findById(long id) {
        return (Producent) sf.getCurrentSession().get(Producent.class, id);
    }

}
