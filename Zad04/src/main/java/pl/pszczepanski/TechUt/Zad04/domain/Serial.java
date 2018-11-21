package pl.pszczepanski.TechUt.Zad04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Serial {
    private long ID;
    private String serialNr;

    public Serial(String serialNr){
        super();
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
