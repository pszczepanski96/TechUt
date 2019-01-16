package pl.pszczepanski.TechUt.Projekt.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "shoe.all", query = "select s from Shoe s")
public class Shoe {

    private long ID;
    private String name;
    private int size;
    private Producent company;
    private Serial serialNumber;
    private List<Wearer> wearers = new ArrayList<Wearer>();

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
    @ManyToOne
    public Producent getCompany() {
        return company;
    }

    public void setCompany(Producent company) {
        this.company = company;
    }
    @OneToOne
    public Serial getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Serial serialNumber) {
        this.serialNumber = serialNumber;
    }
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Wearer> getPerson() {
        return wearers;
    }

    public void setPerson(List<Wearer> wearers) {
        this.wearers = wearers;
    }
}
