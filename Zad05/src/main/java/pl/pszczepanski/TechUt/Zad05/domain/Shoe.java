package pl.pszczepanski.TechUt.Zad05.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "shoe.all", query = "SELECT s FROM shoe s")
public class Shoe {

    private long ID;
    private String name;
    private int size;


    public Shoe(String name, int size){
        this.name = name;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
