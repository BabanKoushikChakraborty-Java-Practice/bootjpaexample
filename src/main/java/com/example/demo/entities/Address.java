package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer add_id;
	private String line1;
	private String city;
	private String pin;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer add_id, String line1, String city, String pin) {
		super();
		this.add_id = add_id;
		this.line1 = line1;
		this.city = city;
		this.pin = pin;
	}
	public Integer getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", line1=" + line1 + ", city=" + city + ", pin=" + pin + "]";
	}
	
	
}
