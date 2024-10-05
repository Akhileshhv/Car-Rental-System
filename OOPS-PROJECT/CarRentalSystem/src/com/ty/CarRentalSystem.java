package com.ty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CarRentalSystem {
	
	private List<Car> cars;  //declaring car details using List.
	private List<Customer> customers; //customer details.
	private List<Rental> rentals; // it contain which customer uses which car.
	
	
//	private String customer_id;
	//private String name;
	
	
	//private String customer_id;
//	private String anotherString;
//	private Object customer;
//	private int choice;
	
				public CarRentalSystem() //constructor
				{
					cars=new ArrayList<>(); //blank ArrayList
					customers=new ArrayList<>();
					rentals=new ArrayList<>();
					
				}
	
	public void addCar(Car car)
	{
		cars.add(car);  //add() is used to add the elements to the ArrayList.
		                 //cars.add(car) indicate appending one car object into another.
	}
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	
			   public void rentCar( Car car,Customer customer,int days)  //method which contains car details,customer details and rental days.
			   {
				   if(car.isAvailable())  //to check whether the car is available or not.
				   {
					   car.rent();
					   rentals.add(new Rental(car,customer,days));  // adding the elements to the rental arraylist.
				   }
				   else
				   {
					   System.out.println("car is not available for rent");
				   }
				   
			   }
	
	public void returnCar(Car car)  // to check whethe the rental cars are returned back or not.
	{
		car.returnCar();  //calling returnCar() method.
	
   
	
	Rental rentalToRemove=null;  //variable declaration and initialization.
	
	for(Rental rental: rentals)  //for each loop.
	{
		if(rental.getCar()==car)  //rentals=name of ArrayList.
		{
			rentalToRemove=rental;
			break;
		}
	}
	
	if(rentalToRemove !=null)
	{
		rentals.remove(rentalToRemove);
		System.out.println("car returned successfully.");
	}
	else
	{
	System.out.println("car was not rented");	
	}
}
	                      public void menu()
	                      {
	                    	  Scanner scanner=new Scanner(System.in);
	                    	  
	                    	  while(true)  // for displaying infinite times until the condition becomes false.
	                    	  {
	                    		  System.out.println("==== Car Rental System ====");
	                    		  System.out.println("1.Rent a car");
	                    		  System.out.println("2.Return a car");
	                    		  System.out.println("3.Exit");
	                    		  
	                    		  System.out.println("Enter your choice");
	                    		  int choice=scanner.nextInt();
	                    		  scanner.nextLine();
	                    		  
	                    		  if(choice==1)
	                    		  {
	                    			  System.out.println("\n===Rent a car===\n");
	                    			  System.out.println("enter your name:");
	                    			  
	                    			  String customerName=scanner.nextLine();
	                    			  
	                    			  System.out.println("\n Available cars :");
	                    			  
	                    			  for(Car car:cars)
	                    			  {
	                    				  if(car.isAvailable())
	                    				  {
	                    					  System.out.println(car.getCarId() + "-" +car.getCarBrand() + "-" +car.getCarModel());
	                    					   
	                    				  }
	                    			  }
	                    			 
	                    			  
	                    			  
	                    			  System.out.println("enter the car id you want to rent:");
	                    			  String carId=scanner.nextLine();
	                    			  
	                    			  System.out.println("enter the number of days for rental:");
	                    			  int rentalDays=scanner.nextInt();
	                    			  scanner.nextLine();
	                    			  
	                    			  
	                    			  Customer Customer=new Customer(choice, customerName);
	                    			  addCustomer(Customer);
	                    			  
	                    			  Car selectedCar=null;
	                    			  for(Car car:cars)
	                    			  {
	                    				  if(car.getCarId().equals(carId) && car.isAvailable())
	                    				  {
	                    					  selectedCar=car;
	                    					  break;
	                    				  }
	                    			  }
	                    			  
	                    			 if(selectedCar != null ) {
	                    				 double totalPrice=selectedCar.calculatePice(rentalDays);
	                    				 System.out.println("\n==Rental information==\n");
	                    				 System.out.println("Customer Id: " +Customer.getCustomer_id());
	                    				 System.out.println("Customer Name: "+Customer.getName());
	                    				 System.out.println("Car: "+selectedCar.getCarBrand()+ " "+selectedCar.getCarModel());
	                    				 System.out.println("Rental Days: "+rentalDays);
	                    				 System.out.println("Total price:"+totalPrice);
	                    				 
	                    				 System.out.println("\n confirm Rental (Y/N) \n: ");
	                    				 String confirm=scanner.nextLine();
			                    				 
					                    				 if(confirm.equalsIgnoreCase("Y"))
	                    			                     {
					                    					 rentCar(selectedCar, Customer, rentalDays);
					                    					 System.out.println("\n Car rented Successfully");
					                    				 }
					                    				 else
					                    				 {
					                    					 System.out.println("\nRental CANCELLED");
					                    				 }
	                    			 }
					                    				 
					                    				 else
					                    				 
					                    				 {
					                    					 System.out.println("\n Invalid car selection or not available for rent");
					                    				 }
	                    		  }
	                    			 
				                    				 else if(choice==2)
				                    				 {
				                    					 System.out.println("\n==Return Car==\n");
				                    					 System.out.println("\n Enter the car Id you want to return:");
				                    					 String carId=scanner.nextLine();
				                    					 
				                    					 Car carToReturn=null;
				                    					 for(Car car: cars)
				                    					 {
				                    						 if(car.getCarId().equals(carId) && car.isAvailable());
				                    						 {
				                    							 carToReturn=car;
				                    							 break;
				                    						 }
				                    					 }
				                    					 
				                    					 
				                    					 if(carToReturn !=null)
				                    					 {
				                    						 Customer customer=null;
				                    						 for(Rental rental: rentals)
				                    						 {   
				                    							 if(rental.getCar()==carToReturn)
				                    							 {
				                    								 
				                    							 customer=rental.getCustomer();
				                    							 break;
				                    						 }
				                    					 }	                    						 
	                    				 
	                    					   if(customer !=null)
	                    					   {
	                    						   returnCar(carToReturn);
	                    						   System.out.println(" Car returned Successfully by "+ customer.getName());
	                    					   }
	                    					   else
	                    					   {
	                    						   System.out.println("car was not rented or rental information is missing");
	                    					   }   
				                    	 }
				                    				 else
				                    				 {
				                    					 System.out.println("invalid car id or car is not rented");
	                    		                     }
	                    	  }
	                    	   else if(choice==3)
	                    	   {
	                    		  
	                    		 break; 
	                    	  }
	                    	  else
	                    	  {
	                    		  System.out.println("imvalid choice.please enter valid option.");
	                    	  }
	                    	  
                             }                     
	                      System.out.println("\n Thank you for using car rental system.");
	                     
}






	                      
	     public static void main(String[] args) {      //==============main class=======================
	
         CarRentalSystem rentalSystem=new CarRentalSystem();
         
         
         Car car1=new Car("c101", "Jaguar", "XF", 80000.0,true);
         Car car2=new Car("c002", "BMW", "7 series", 70000.0,true);
         Car car3=new Car("c003", "Mercedes-Benz", "G-Class", 60000.0,true);
         Car car4=new Car("c004", "Rolls-Royce", "Ghost", 90000.0,true);
                  
       
        rentalSystem.addCar(car1);
         rentalSystem.addCar(car2);
         rentalSystem.addCar(car3);
         rentalSystem.addCar(car4);
         rentalSystem.menu();
         }

	}