package model;

import java.io.Serializable;

/**
 * 
 * @author Matthew Keating
 *	Had an issue when using the CarParent from the JAR file 
 *	with Serializable, NoClassFoundException
 *	Instead I imported the class into the project
 */
public class CarParent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String make;
	protected String model;
	protected String reg; 
	protected int year;
	
	public CarParent(String make, String model, String reg, int year) {
		this.make = make;
		this.model = model;
		this.reg = reg;
		this.year = year;
	}
	
}
