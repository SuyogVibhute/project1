package com.service;
import com.model.Vehicle;
import ThrowPlay.*;
import ThrowView.InvalidAdharNumber;
import java.util.Scanner;

public class Pune implements Rto {

	Vehicle v = new Vehicle();
    Scanner s = new Scanner(System.in);

    @Override
    public void regVehicle() {
        // Set all details of the vehicle using setter methods present in the Vehicle class
        System.out.println("Enter registration id: ");
        v.setRegId(s.nextInt());
        System.out.println("Enter model name: ");
        
        v.setModelName(s.next()+s.nextLine());
        System.out.println("Enter the Price:");
        
        v.setPrice(s.nextFloat());
        System.out.println("Enter the Colour");
        
        v.setColour(s.next()+s.nextLine());
        System.out.println("Enter the Area ");
       
        v.setArea(s.next()+s.nextLine());
        System.out.println("Enter the Owner Name");
       
        v.setOwnerName(s.next()+s.nextLine());
        System.out.println("Enter the Moblile Number");
        long num=s.nextLong();
        int digit =0;
        for(long i=num;i>0;i=i/10) {
        	digit++;
        }
        if(digit==10) {
        	v.setMob(num);
        }else {
        	InvalidMobileNumber e= new InvalidMobileNumber("Invalid Number");
        	throw e;
        }
        
        v.setMob(s.nextLong());
        System.out.println("Enter the Adhar Number");
        long num1=s.nextLong();
        int digit1 =0;
        for(long i=num1;i>0;i=i/10) {
        	digit++;
        }
        if(digit1==12) {
        	v.setAdhar(num1);
        }else {
        	InvalidAdharNumber e= new InvalidAdharNumber("Invalid Number");
        	throw e;
        }
        
	 }

	 @Override
	 public void viewDetails() {
	 //Print all details present in variables using get method
		System.out.println(v.getRegId()); 
	    System.out.println(v.getModelName());
		System.out.println(v.getPrice());
		System.out.println(v.getColour()); 
		System.out.println(v.getArea()); 
		System.out.println(v.getOwnerName()); 
		System.out.println(v.getMob()); 
		System.out.println( v.getAdhar());

	  }
	  @Override
	 public void updateVehicle() {
		 Scanner s = new Scanner(System.in);
		  
		 System.out.println("1.Update RegId\n2.Update ModelName\n3.Update Price\n4.Update Colour\n5.Update Area\n6.Update Owner\n7.Update MoblieNumber\n8.AdharNumber");
		 System.out.println("What you want to update?\nEnter choice");
		 int ch=s.nextInt();
		 switch(ch) {
		 case 1:
			 //Update according to user choice code
			 System.out.println("Enter the new RegId: ");
			 int newRegId = s.nextInt();
			 v.setRegId(newRegId);
			 
			 break;
			 
		 case 2:
			 System.out.println("Enter the new ModelName:");
			 v.setModelName(s.next());
			 
			 break;
			 
		 case 3:
			 System.out.println("Enter the new price: ");
		     v.setPrice(s.nextFloat());
	        
	         break;
	         
		 case 4:
			 System.out.println("Enter the new colour:");
			 
			 
			 v.setColour(s.next());
			 
			 break;
			 
		 case 5:
			System.out.println("Enter the new Area:");
			
			
			v.setArea(s.next());
			
			break;
			
		 case 6:
			 System.out.println("Enter the new owner name: ");
	         
	        
	         v.setOwnerName(s.next());
	         
	         break;
	         
		 case 7:
			 System.out.println("Enter the new Mobile Number:");
			 
			 
			 v.setMob(s.nextLong());
			 
			 break;
			 
		 case 8:
			 System.out.println("Enter the new Adhar Number:");
			 
			 
			 v.setAdhar(s.nextLong());
			 
			 break;
			 
			default :
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			 
			 
		  
		 }
	  
	  }

}
