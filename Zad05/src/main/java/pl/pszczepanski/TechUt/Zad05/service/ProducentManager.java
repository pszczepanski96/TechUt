package pl.pszczepanski.TechUt.Zad05.service;

import pl.pszczepanski.TechUt.Zad05.domain.Producent;

import java.util.List;

public interface ProducentManager {

    void addProducent(Producent producent);

    List<Producent> getAllProducents();

    Producent findById(long id);

}
