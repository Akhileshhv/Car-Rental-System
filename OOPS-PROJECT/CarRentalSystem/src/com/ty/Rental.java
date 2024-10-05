package com.ty;


public class Rental {

	private Car car;         //this car can have different attributes such as,id,brand,model,basePrice. 
	private Customer customer; // These different attributes can have different dataTypes.
	private int days;  // So there are chances of mis-match of dataType. That's why we consider Car class as datType.
	
	
	public Rental(Car car, Customer customer, int days) {
		
		this.car = car;
		this.customer = customer;
		this.days = days;
	}


	public Car getCar() {
		return car;
	}


	public Customer getCustomer() {
		return customer;
	}


	public int getDays() {
		return days;
	}


	
	
	
	
}