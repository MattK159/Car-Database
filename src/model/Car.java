package model;

import java.io.Serializable;

public class Car extends CarParent implements Cloneable, Serializable, Comparable<Car> {
	private static final long serialVersionUID = 1L;
	private int milage;
	
	/**
	 * Car constructor, calls super class carparent
	 * @param make
	 * @param model
	 * @param reg
	 * @param milage
	 * @param year
	 */
	public Car(String make, String model, String reg, int milage, int year) {
		super(make,model,reg,year); 
		this.milage = milage;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * Tostring method
	 */
	@Override
	public String toString() {
		return "Make: " + make + " Model: " + model + " Reg: " + reg + " Milage: " + milage + " Year: " + year;
	}

	@Override
	public int compareTo(Car c) {
		int res = 0; 

		res = make.compareTo(c.getMake()); 
		
		return res; 
	}
	
	@Override
	public Car clone() throws CloneNotSupportedException {

	    return (Car) super.clone();
	}





}
