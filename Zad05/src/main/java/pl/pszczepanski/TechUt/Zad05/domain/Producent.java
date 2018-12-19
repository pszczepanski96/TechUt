package pl.pszczepanski.TechUt.Zad05.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQuery(name = "producent.all", query = "SELECT p FROM producent p")
public class Producent {


    private long ID;
    private String name;
    private List<Shoe> shoes = new ArrayList<Shoe>();


    public Producent( String name){
        super();
        this.name = name;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Shoe> getShoes(){
        return shoes;
    }

    public void setShoes(List<Shoe> shoes){
        this.shoes = shoes;
    }
}
