package pl.pszczepanski.TechUt.Zad05.service;

import pl.pszczepanski.TechUt.Zad05.domain.Shoe;

import java.util.List;

public interface ShoeManager {

    List<Shoe> getAll();

    void addShoe(Shoe shoe);

    Shoe findById(long ID);

}
