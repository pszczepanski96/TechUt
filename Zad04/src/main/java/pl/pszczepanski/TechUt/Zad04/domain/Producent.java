package pl.pszczepanski.TechUt.Zad04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producent {

    private long ID;
    private String name;
    private String country;

    public Producent( String name, String country){
        super();
        this.name = name;
        this.country = country;
    }
    public Producent(){
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
