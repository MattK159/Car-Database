package view;
import java.util.Optional;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;


/**
 * 
 * @author Matthew Keating
 *
 */
public class mainTab extends Tab {
	/**
	 * Initializing variables
	 * Some variables are kept outside the constructor method so that they can be accessed by other classes (controller class)
	 */
	private static TextArea info = new TextArea("Welcome, Choose an option below"); 
	FlowPane  tp = new FlowPane();

	TextField t1 = new TextField("Enter index of Car");
	final ToggleGroup sortGroup = new ToggleGroup(); 
	static RadioButton rb1 = new RadioButton("Default"); 
	static RadioButton rb2 = new RadioButton("Milage"); 
	static RadioButton rb3 = new RadioButton("Year"); 

	public mainTab() {
		setText("Main"); 
		Text t1 = new Text("Sort by: "); 
		Button b1 = new Button ("Add New Car");
		Button b2 = new Button ("Remove Car");
		Button b3 = new Button ("Show cars");
		Button b4 = new Button ("Quit");
		
		rb1.setSelected(true);
		rb1.setToggleGroup(sortGroup);
		rb2.setToggleGroup(sortGroup);
		rb3.setToggleGroup(sortGroup);
		
		tp.getChildren().add (getInfo());
		tp.getChildren().add (b1);  
		tp.getChildren().add (b2);  
		tp.getChildren().add (b3); 
		
		tp.getChildren().add(t1); 
		tp.getChildren().add(rb1);
		tp.getChildren().add(rb2);
		tp.getChildren().add(rb3); 
	
		tp.getChildren().add (b4);
		
		setContent(tp);

		/**
		 * Onclick actions for each button
		 */
		b1.setOnAction(e -> getCarInfo());
		b2.setOnAction(e -> getCarIndex());
		b3.setOnAction(e -> Controller.printCars());
		b4.setOnAction(e -> Controller.quit());
	}


	//getting new car info
	public void getCarInfo() {
		TextInputDialog dbox = new TextInputDialog("");
		Optional<String> model, reg, strmilage, stryear; 

		dbox.setTitle("New Car");
		dbox.setHeaderText("Enter option below");
		dbox.setContentText("Enter car Make");
		
		//a lot of inputdialogs to get new car variables
		Optional<String> make = dbox.showAndWait();
		try {
			if(make.isPresent()) {
				dbox.setContentText("Enter car Model");
				model = dbox.showAndWait();
				if(model.isPresent()) {
					dbox.setContentText("Reg");
					reg = dbox.showAndWait();
					if(reg.isPresent()) {
						dbox.setContentText("Milage");
						strmilage = dbox.showAndWait();
						if(strmilage.isPresent()) {
							dbox.setContentText("Year");
							stryear = dbox.showAndWait();
							if(stryear.isPresent()) {
								int milage = Integer.parseInt(strmilage.get());
								int year = Integer.parseInt(stryear.get()); 
								Controller.addCar(make.get(),model.get(),reg.get(),milage,year);
								Controller.saveContent();
							}
						}
					}
				}
			}
		}
		catch(Exception NumberFormatException) {
			System.out.println("Value error");
			setInfo("Value error creating car, car was not added, try again."); 
		}
	}
	
	/**
	 * Called when removing a car, gets the car index, converts it to an int and calls the function in controller object
	 */
	public void getCarIndex() {
		TextInputDialog dialog = new TextInputDialog("Enter index of Car");
		dialog.setTitle("Remove Car");


		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			int index = Integer.parseInt(result.get()); 
			// int index = Simple.convertStr(result);
			Controller.removeCar(index); 
		}
	}

	public static void setInfo(String text) {
		info.setText(text); 
	}

	public static TextArea getInfo() {
		return info;
	}

	public static void setInfo(TextArea info) {
		mainTab.info = info;
	}
	
	/**
	 * Gets which radio button is selected
	 * @return returns and int from 0 - 2 so that it can be used int he switch statement in controller class
	 */
	public static int getSelectedSort() {
		int res = 0; 
		if(rb1.isSelected()) res = 0; //Default
		else if(rb2.isSelected()) res = 1; //Milage
		else if(rb3.isSelected()) res = 2; //Year
		return res;
	}
}
