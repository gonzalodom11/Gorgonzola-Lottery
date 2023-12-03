package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	 private Scene scene;
	 private Parent root;
	 @FXML
	 private TextField nameTextField;
	 
	 
	 
	 public void switchToScene2(ActionEvent event) throws IOException, InvalidIntervalException {
		 
		 	String username = nameTextField.getText();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Lottery.fxml"));	
			root = loader.load();	
			
			SecondaryController secondaryController = loader.getController();
			secondaryController.displayName(username);;
			secondaryController.createTolo();
			
			
			
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		 
		 }
}
