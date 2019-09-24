package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/*
* @author Nino Kelehsashvili
* Applied Computing_20074819
* Year2_Semester4
* (Repeat Learner)
*/

public class ImageWindowController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private VBox vBox;
	@FXML
	private MenuBar menuBar;
	@FXML
	private ImageView imageView;
	@FXML
	private Menu fileMenu;
	@FXML
	private Menu editMenu;
	@FXML
	private MenuItem loadButton;
	@FXML
	private MenuItem closeButton;
	@FXML
	private MenuItem rgbButton;
	@FXML
	private MenuItem grayButton;
	
	public static Image image;
	
	public void fileMenu(ActionEvent event) {
		
	}
	public void editMenu(ActionEvent event) {
		
	}
	
	// Upload an image
	public Image loadButton(ActionEvent event) {
		FileChooser fc = new FileChooser();
		Window ownerWindow = null;
		File selectedFile = fc.showOpenDialog(ownerWindow);
		
		if(selectedFile !=null) {
			image =new Image(selectedFile.toURI().toString());
			imageView.setImage(image);
		}else {
			System.out.println("Not a valid file.");
		}
		return image;	
	}
	
	// Close an image
	public void closeButton(ActionEvent event) {
		if(imageView != null) {
			imageView.setImage(null);
		}else {
			System.out.println("No image imported");
		}	
	}
	
	// Change image to GRAY
	public void grayButton(ActionEvent event) {
		// Reads the pixel data from image
				PixelReader pxReader = image.getPixelReader();
				// Makes the pixel data writable
				WritableImage wrImage = new WritableImage(
						(int) image.getWidth(),
						(int) image.getHeight());
				// Writes the pixel data of the WritableImage
				PixelWriter pxWriter = wrImage.getPixelWriter();
				for(int y = 0; y < image.getHeight(); y++) {
					for(int x = 0; x < image.getWidth(); x++) {
						Color color = pxReader.getColor(x, y);
						double r=color.getRed();
						double g=color.getGreen();
						double b=color.getBlue();
						
						double grey =  (0.2162 * (double)r + 0.7152 * (double)g + 0.0722 * (double)b) / 3;    
						pxWriter.setColor(x, y, new Color(grey,grey,grey,1));
					}
			}
			imageView.setImage(wrImage);
	}
		
	// Opens new window for RGB Channels
	public void rgbButton(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("rgbWindow.fxml"));
			BorderPane layout = loader.load();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setTitle("RGB Channels");
			stage.setScene(scene);
			stage.show();
			}catch (Exception e) {
				System.out.println("Can't load new window.");
			}			
	}
	
}
