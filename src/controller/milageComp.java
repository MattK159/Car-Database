package controller;
import java.util.Comparator;
import model.Car;

/**
 * Milage comparator 
 * @author Matthew Keating
 *
 */
public class milageComp implements Comparator<Car> {
	public int compare(Car car1, Car car2) {
			  Integer c1 = car1.getMilage();
			  Integer c2 = car2.getMilage();
			  return c1.compareTo(c2);
	}

}
