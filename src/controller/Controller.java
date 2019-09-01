package controller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.Car;
import view.mainTab;


/**
 * @author Matthew Keating R00154623
 *
 */
public class Controller {
	public static ArrayList<Car> carList = new ArrayList<Car>(30);
	private final static String carFile = "carFile.txt"; 

	/**
	 * Prints cars in carList array
	 * Depending on the sort radio button selected, list items ar oredered
	 * Sends the list back to the textbox in the variable info
	 */
	public static void printCars() {
		int sort = mainTab.getSelectedSort(); 
		System.out.println(sort); 

		switch(sort) {
		case 0: //default
			Collections.sort(carList);
			break;
		case 1: //milage
			milageComp sortByMilage = new milageComp(); 
			Collections.sort(carList, sortByMilage);
			break;
		case 2: //year
			yearComp sortByYear = new yearComp(); 
			Collections.sort(carList, sortByYear);
			break; 
		}

		String info = ""; 
		System.out.println("Test");
		for(Car c : carList) {
			System.out.println(c);
			info += c;
			info += "\n"; 
		}
		mainTab.getInfo().setText(info); 
	}

	//adding a car object
	public static void addCar(Car c) {
		carList.add(c); 
	}

	//creating and adding a new car object 
	public static void addCar(String make, String model, String reg, int milage, int year) {
		Car newcar = new Car(make,model,reg,milage,year); 
		carList.add(newcar); 
	}

	//creating and adding a new car object with user input
	public void addCar() {
		Scanner sc = new Scanner(System.in);
		String make,model,reg;
		int milage, year; 

		print("Enter make"); 
		make = sc.nextLine();
		print("Enter model");
		model = sc.nextLine(); 
		print("Enter reg");
		reg = sc.nextLine();
		print("Enter milage"); 
		String strmilage = sc.nextLine(); 
		print("Enter Year");
		String stryear = sc.nextLine(); 

		milage = Integer.parseInt(strmilage); 
		year = Integer.parseInt(stryear); 

		Car newCar = new Car(make,model,reg,milage,year); 
		carList.add(newCar); 
		print("Car Added"); 
		sc.close(); 
	}

	public static void removeCar(int index) {
		try {
			carList.remove(index); 
			print("Car Removed"); 
			Controller.saveContent();
		}
		catch(Exception IndexOutOfBoundsException) {
			System.out.println("No Index matching"); 
			mainTab.setInfo("No vehicle with that index");
		}
	}

	public static void print(String s) {
		System.out.println(s);
	}

	//Saving/loading content from carFile.txt
	public static void saveContent() {
		try
		{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(carFile)); {
				os.writeObject(carList);
			}
			os.close();
		} catch (Exception ex) {
			System.out.println("could not save");
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void loadContent() {
		try
		{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(carFile));  
			carList = (ArrayList<Car>) is.readObject();
			is.close() ;       
		} 
		catch (Exception ex) {
			System.out.println("could not load");
			ex.printStackTrace();
		}
	}
	
	//Save content before the program exits
	public static void quit() {
		Controller.saveContent();
		System.exit(0);
	}
}

