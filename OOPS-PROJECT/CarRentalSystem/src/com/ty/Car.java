package com.ty;

public class Car {               //ENCAPSULATION 

	private String carId;
	private String carModel;    //why we are using private access specifier is user can't access directly.
	private String carBrand;
	private double basePrice;  //car rent per day
	private boolean isAvailable; // to check whether the car is available or not.
	
	
	
	   //initializing those variables using  parameterized constructor.
	    public Car(String carId, String carModel, String carBrand, double basePrice, boolean isAvailable) {
		
		this.carId = carId;
		this.carModel = carModel;
		this.carBrand = carBrand;
		this.basePrice = basePrice;
		this.isAvailable = true; // setting default value as true.
	}
	
	
	
	   //getter() and setter() methods in encapsulation, provides indirect access for the private dataMembers.
	
		public String getCarId() {
			return carId;
		}



		public String getCarModel() {
			return carModel;
		}



		public String getCarBrand() {
			return carBrand;
		}



		public double getBasePrice() {
			return basePrice;
		}



		public boolean isAvailable() {
			return isAvailable;
		}

												public void rent()
												{
													isAvailable=false;  // this method is used to check whether the car is ready to rent or not
												}
				
												public void returnCar()  //this method is used to check whether the car is returned back from rent or not.
												{
													isAvailable=true;
												}
												
												public double calculatePice(int rentalDays)  //this method is used to calculate the basePrice per day.
												{
													return basePrice*rentalDays;
												}
}