package com.sg.microservices.order.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {	
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7282465395405574267L;
	private int id;
	private String itemName;
	private String description;
	private int availableitems;
	private int cost;
	
	public Product(int id, String itemName, String description, int availableitems, int cost) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.availableitems = availableitems;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAvailableitems() {
		return availableitems;
	}

	public void setAvailableitems(int availableitems) {
		this.availableitems = availableitems;
	}
	
	public Product(){
		
		
	}
	
}
