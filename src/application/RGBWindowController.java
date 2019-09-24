package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/*
* @author Nino Kelehsashvili
* Applied Computing_20074819
* Year2_Semester4
* (Repeat Learner)
*/

public class RGBWindowController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private MenuBar menuBar;
	@FXML
	private HBox hBox;
	@FXML
	private Button redButton;
	@FXML
	private Button greenButton;
	@FXML
	private Button blueButton;
	@FXML
	private ImageView imageView;

	// Change an image to RED color
	public void redButton(ActionEvent event) {
		PixelReader pxReader = ImageWindowController.image.getPixelReader();
		WritableImage wrImage = new WritableImage(
				(int) ImageWindowController.image.getWidth(),
				(int) ImageWindowController.image.getHeight());
		PixelWriter pxWriter = wrImage.getPixelWriter();
		for(int y = 0; y < ImageWindowController.image.getHeight(); y++) {
			for(int x = 0; x < ImageWindowController.image.getWidth(); x++) {
				Color color = pxReader.getColor(x, y);
				double r=color.getRed();
   
				pxWriter.setColor(x, y, new Color(r,0,0,1));
			}
		}
		imageView.setImage(wrImage);
	}
	
	// Change an image to GREEN color
	public void greenButton(ActionEvent event) {
		PixelReader pxReader = ImageWindowController.image.getPixelReader();
		WritableImage wrImage = new WritableImage(
				(int) ImageWindowController.image.getWidth(),
				(int) ImageWindowController.image.getHeight());
		PixelWriter pxWriter = wrImage.getPixelWriter();
		for(int y = 0; y < ImageWindowController.image.getHeight(); y++) {
			for(int x = 0; x < ImageWindowController.image.getWidth(); x++) {
				Color color = pxReader.getColor(x, y);
				double g=color.getGreen();
				
				pxWriter.setColor(x, y, new Color(0,g,0,1));
			}
		}
		imageView.setImage(wrImage);	
	}
	
	// Cange an image to BLUE color
	public void blueButton(ActionEvent event) {
		PixelReader pxReader = ImageWindowController.image.getPixelReader();
		WritableImage wrImage = new WritableImage(
				(int) ImageWindowController.image.getWidth(),
				(int) ImageWindowController.image.getHeight());
		PixelWriter pxWriter = wrImage.getPixelWriter();
		for(int y = 0; y < ImageWindowController.image.getHeight(); y++) {
			for(int x = 0; x < ImageWindowController.image.getWidth(); x++) {
				Color color = pxReader.getColor(x, y);
				double b=color.getBlue(); 
				
				pxWriter.setColor(x, y, new Color(0,0,b,1));
			}
		}
		imageView.setImage(wrImage);	
	}
}
