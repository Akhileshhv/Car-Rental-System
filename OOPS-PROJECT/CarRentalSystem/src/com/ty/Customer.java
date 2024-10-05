package com.ty;

public class Customer {
	
	private int customer_id;
	private String name;
	
	
										public Customer(int customer_id, String name) {
											
											this.customer_id = customer_id;
											this.name = name;
										}


			public int getCustomer_id() {
				return customer_id;
			}


			public String getName() {
				return name;
			}


	

}