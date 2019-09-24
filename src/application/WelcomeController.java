package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Nino Kelehsashvili
 * Applied Computing_20074819
 * Year2_Semester4
 * (Repeat Learner)
 */

public class WelcomeController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private VBox vBox;
	@FXML
	private Button welcomeButton;
	
	// New window
	public void welcomeButton(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("imageWindow.fxml"));
			BorderPane layout = loader.load();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setTitle("Mane Image Window");
			stage.setScene(scene);
			stage.show();
			}catch (Exception e) {
				System.out.println("Can't load new window.");
			}	
	}
	
}
	
