package pl.pszczepanski.techut.zad03.domain;

import java.sql.*;

public class Shoe {
	private String producer;
	private String type;
	private int size;
	private Date productionDate;
	private double price;

	public Shoe(String producer, String type, int size, Date produceDate, double price) {
		this.producer = producer;
		this.type = type;
		this.size = size;
		this.productionDate = produceDate;
		this.price = price;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize(){
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date produceDate) {
		this.productionDate = productionDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}