package pl.pszczepanski.techut.zad03;

import pl.pszczepanski.techut.zad03.domain.Shoe;
import pl.pszczepanski.techut.zad03.service.ShoeManager;
import pl.pszczepanski.techut.zad03.service.ShoeManagerJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Shoe shoe1 = new Shoe("Nike", "Running shoe", 42, new Date(118, 10,15 ), 105.99);

        Shoe shoe2 = new Shoe ("Industrial Starter", "Working shoe", 45, new Date(118, 02,05), 124.05);

        Shoe shoe3 = new Shoe("Cropp", "Recreational shoe", 37, new Date(115, 12,15), 78.00);



        ShoeManager ps = new ShoeManagerJDBC();

        ps.removeShoes();

        ps.addShoe(shoe1);
        ps.addShoe(shoe2);
        ps.addShoe(shoe3);
        System.out.println("Wszystkie buty");
        ps.showAllShoes();
        System.out.println("\n");
        System.out.println("Tylko but Nike\n");
        ps.searchShoesbyProducer("Nike");
        System.out.println("\n");
        System.out.println("Usuń Nike");
        ps.removeShoe("Nike");
        System.out.println("Wszystkie buty");
        ps.showAllShoes();
        System.out.println("Update buta Cropp");
        ps.searchShoesbyProducer("Cropp");
        ps.updateShoes("Cropp", "Street shoe", 40, new Date(118,12,15), 88.00 );
        System.out.println("\n");
        ps.searchShoesbyProducer("Cropp");
        System.out.println("\n");
        System.out.println("Dodanie kolejnych butów");
        List<Shoe> shoes = new ArrayList<>();
        Shoe shoe4 = new Shoe("Adidas", "Running shoe", 40, new Date(118,11,13), 139.00);
        Shoe shoe5 = new Shoe("Lasocki", "Evening shoe", 37, new Date(118,05,05), 359.00);
        Shoe shoe6 = new Shoe("Urgent", "Working shoe", 44, new Date(117,01,13), 669.00);
        shoes.add(shoe4);
        shoes.add(shoe5);
        shoes.add(shoe6);
        ps.addShoes(shoes);
        ps.showAllShoes();
        List<Shoe> shoes1 = new ArrayList<>();
        Shoe shoe7 = new Shoe("Urgent", "Working shoe", 44, new Date(117,01,13), 669.00);
        Shoe shoe8 = new Shoe("Nike", "Running shoe", 44, new Date(117,01,13), 669.00);

    }
}