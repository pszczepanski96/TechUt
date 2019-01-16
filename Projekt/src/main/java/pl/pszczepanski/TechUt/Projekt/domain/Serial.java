package pl.pszczepanski.TechUt.Projekt.domain;

import javax.persistence.*;

@Entity
@NamedQuery(name = "serial.all", query = "select s from Serial s")
public class Serial {
    private long ID;
    private String serialNr;

    public Serial(String serialNr){
        this.serialNr = serialNr;
    }

    public Serial(){
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

    public String getSerialNr() {
        return serialNr;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }
}
