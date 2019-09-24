package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/*
* @author Nino Kelehsashvili
* Applied Computing_20074819
* Year2_Semester4
* (Repeat Learner)
*/

public class Main extends Application {
	private Stage primaryStage;
	
	// Set the stage and the Title of the app.
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Image Viewer App");
		showMainView();
	}
		
	// Load the FXML file and create a new scene in the stage. 
	// Also load initial scenebuilder as a new window
	private void showMainView() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("welcome.fxml"));
		BorderPane mainLayout = loader.load();
	    Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
