package com.inc.dayary.domain;

public class Tag {
/*
	ID    NOT NULL NUMBER       
	D_ID           NUMBER       
	NAME  NOT NULL VARCHAR2(30) 
	COLOR NOT NULL VARCHAR2(10) */
	
	private int id;
	private int d_id;
	private String name;
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
