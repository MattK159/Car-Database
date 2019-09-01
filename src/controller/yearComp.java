package controller;

import java.util.Comparator;

import model.Car;
/**
 * Year Comparator
 * @author Matthew Keating
 *
 */
public class yearComp implements Comparator<Car> {
	public int compare(Car car1, Car car2) {
		Integer c1 = car1.getYear();
		Integer c2 = car2.getYear();
		return c1.compareTo(c2);
	}

}
