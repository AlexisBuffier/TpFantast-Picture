package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent rootFXML = FXMLLoader.load(getClass().getResource("FantastPicture.fxml"));
			Scene sceneFXML = new Scene(rootFXML);
			
			primaryStage.setTitle("Fantast'Picture");
			
			primaryStage.setScene(sceneFXML);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
