package pl.pszczepanski.TechUt.Projekt.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name =  "producer.all", query = "select p from Producent p")
public class Producent {

    private long ID;
    private String name;
    private String country;

    public Producent( String name, String country){

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
