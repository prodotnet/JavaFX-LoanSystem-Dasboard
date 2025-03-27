

import javafx.application.Application;
import javafx.scene.Scene;



import javafx.stage.Stage;

public class LoanDashboard extends Application {

	
	  GUI gui = new GUI();
	    

	    public static void main(String[] args) {
	        launch(args); 
	    }






		@Override
		public void start(Stage  primaryStage) throws Exception {
			 primaryStage.setTitle("Loan Admin Dashboard");
			  Scene scene = new Scene(gui, 800, 600);
		        scene.getStylesheets().add("style.css");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    
		}
}
