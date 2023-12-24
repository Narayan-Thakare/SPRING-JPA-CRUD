package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="jpaa")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
private int roll;
private String name;
private String address;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the roll
 */
public int getRoll() {
	return roll;
}
/**
 * @param roll the roll to set
 */
public void setRoll(int roll) {
	this.roll = roll;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
public Student(int id, int roll, String name, String address) {
	super();
	this.id = id;
	this.roll = roll;
	this.name = name;
	this.address = address;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", address=" + address + "]";
}
	
	








	
	
}
