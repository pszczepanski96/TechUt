package pl.pszczepanski.techut.zad02;

import pl.pszczepanski.techut.zad02.domain.Shoe;
import pl.pszczepanski.techut.zad02.service.ShoeService;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Shoe shoe1 = new Shoe("Nike", "Running shoe", 42, new Date(118, 10,15 ), 105.99);

        Shoe shoe2 = new Shoe ("Industrial Starter", "Working shoe", 45, new Date(118, 02,05), 124.05);

        Shoe shoe3 = new Shoe("Cropp", "Recreational shoe", 37, new Date(115, 12,15), 78.00);



        ShoeService ps = new ShoeService();

        ps.removeShoes();

        ps.addShoe(shoe1);
        ps.addShoe(shoe2);
        ps.addShoe(shoe3);

        ps.showAllShoes();
    }
}