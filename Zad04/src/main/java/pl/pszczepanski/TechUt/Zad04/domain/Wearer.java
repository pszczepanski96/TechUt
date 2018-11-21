package pl.pszczepanski.TechUt.Zad04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wearer {

    private long ID;
    private String name;
    private int yob;

    public Wearer(String name, int yob){
        super();
        this.name = name;
        this.yob = yob;
    }

    public Wearer(){
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

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }
}
