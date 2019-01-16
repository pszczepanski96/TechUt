package pl.pszczepanski.TechUt.Projekt.service;

import pl.pszczepanski.TechUt.Projekt.domain.Producent;
import pl.pszczepanski.TechUt.Projekt.domain.Serial;
import pl.pszczepanski.TechUt.Projekt.domain.Shoe;
import pl.pszczepanski.TechUt.Projekt.domain.Wearer;

import java.util.List;

public interface ProjectManager {


    void addSerial(Serial serial);
    List<Serial> getAllSerials();

    void addProducent(Producent producent);
    void updateProducent(Producent producent);
    void deleteProducer(long id);
    Producent findProducerById(long id);
    List<Producent> getAllProducents();
    void deleteAllProducents();
    

    void addWearer(Wearer wearer);
    void deleteWearerByName(String name);
    List<Wearer> getAllWearers();
    void deleteAllWearers();

    void addShoe(Shoe shoe);
    void deleteShoe(long id);
    void updateShoe(Shoe shoe);
    Shoe findShoeById(long id);
    Shoe findShoeByName(String name);
    List<Shoe> getAllShoes();

    void giveSerialNr(long serialId, long shoeId);
    void giveProducer(long producerId, long shoeId);
    List<Wearer> getShoeWearers(Shoe shoe);
    void giveShoeAWearer(long wearerId, long shoeId);


}
