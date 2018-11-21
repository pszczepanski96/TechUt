package pl.pszczepanski.techut.zad03.service;


import pl.pszczepanski.techut.zad03.domain.Shoe;

import java.sql.*;
import java.util.List;

public interface ShoeManager {

	public void addShoe(Shoe shoe) throws SQLException;
	public void showAllShoes() throws SQLException;
	public void searchShoesbyProducer(String producer) throws SQLException;
	public void updateShoes( String producer, String type, int size, Date productionDate, double price) throws SQLException;
	public void removeShoes() throws SQLException;
	public void removeShoe(String producer) throws SQLException;
	public boolean addShoes(List<Shoe> planes);
}