package com.client;
import java.util.Scanner;
import com.service.Pune;
import com.service.Rto;

public class Test {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Rto pl=new Pune();
		
		while(true) {
		System.out.println("Welcome to Vehicle registeration system\nOptions");
		System.out.println("1.Register your vehicle\n2.View your vehcile\n3.Update your details");
		System.out.println("What is your choice?");
		int ch=s.nextInt();
		switch(ch) {
		case 1:
		pl.regVehicle();
		break;
		
		case 2:
		pl.viewDetails();
		break;
		
		case 3:
		pl.updateVehicle();
		break;
		 //Call other methods here according to user choice
		   }
		  }
		 }
		}

