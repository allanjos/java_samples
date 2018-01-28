package br.com.olivum.java.hibernate;

public class Product {
	int id;
	String name;

	String userMessage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}