package pl.pszczepanski.TechUt.Zad05.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pszczepanski.TechUt.Zad05.domain.Shoe;

import java.util.List;

public class ShoeManagerHibernateImpl implements ShoeManager {

    @Autowired
    SessionFactory sf;

    @Override
    public void addShoe(Shoe shoe) {

        sf.getCurrentSession().save(shoe);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shoe> getAll() {

        return sf.getCurrentSession().getNamedQuery("shoe.all").list();

    }


    @Override
    public Shoe findById(long ID) {

        return (Shoe) sf.getCurrentSession().get(Shoe.class, ID);

    }

}
