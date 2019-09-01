import controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.mainTab;

/**
 * @author Matthew Keating R00154623
 * Class: SD2-A Object Orientated Programming
 * Assignment 2
 */

public class main extends Application {

	public static TabPane tp = new TabPane();
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane mainPane = new BorderPane();
			Group root = new Group();
			Scene scene = new Scene(root,450,400);
			
			tp.getTabs().add ( new mainTab()); 
			mainPane.setCenter(tp);

			mainPane.prefHeightProperty().bind(scene.heightProperty());
			mainPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(mainPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void print(String t) {
		System.out.println(t);
	}


	public static void main(String[] args) throws Exception {
		
		//testing program memeory
		/*ArrayList<Car> testarr = new ArrayList<Car>(50000000); 
		for(int i = 0; i < 50000000; i++) {
			Car c1 = new Car("Toyota", "Corola", "951", 45000, 2017); 
			testarr.add(c1); 
			Simple.print("running");
		}*/ 
		
		/**
		 * Loads content from serializable file 
		 */
		Controller.loadContent();
		Simple.print("Launching...");
		launch(args);

	}

}
