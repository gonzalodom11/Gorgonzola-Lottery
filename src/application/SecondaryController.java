package application;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondaryController {
	
	@FXML Label nameLabel;
	@FXML TextArea textBox2;
	@FXML TextField n1;
	@FXML TextField n2;
	@FXML TextField n3;
	@FXML TextField n4;
	@FXML TextField luckyN;
	@FXML TextField money;
	@FXML TextField prizeId;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Tolo tolo;
	private Integer prize;
	
	public void displayName(String username) {
		if(!username.isBlank()) {
			nameLabel.setText("Welcome " + username);
		}
		else {
			nameLabel.setText("Welcome new user");
		}
		
	}
	
	public void createTolo() throws InvalidIntervalException {
		this.tolo = Test.createRandom();
		textBox2.setText(this.tolo.toString());
	}
	
	public void makeBetorSuperBet() {
		
		
		if(n1.getText().isBlank() 
				|| n2.getText().isBlank() 
				|| n3.getText().isBlank() 
				|| n4.getText().isBlank() ) {
			
			textBox2.setText(textBox2.getText()+"\n Ey you have to put at least 4 numbers");
		}
		else {
			try {
				Integer v1 = Integer.decode(n1.getText().trim());
				Integer v2 = Integer.decode(n2.getText().trim());
				Integer v3 = Integer.decode(n3.getText().trim());
				Integer v4 = Integer.decode(n4.getText().trim());
				
				List<Integer> numbers = List.of(v1,v2,v3,v4);
				
				if(numbers.stream().allMatch(x -> x>0 && x<20)) {
					if(luckyN.getText().isBlank()) { 
						makeBetHere(numbers);
					}
					else {
						makeSuperBetHere(numbers);	
					}
					
				}
				else {
					textBox2.setText(textBox2.getText()+"\n You have introduced a number out of the interval.");
					reset();
				}
				
				
			}catch(Exception e) {
				textBox2.setText(textBox2.getText()+"\n Make sure that your inputs are numbers.");
				System.out.println(e.toString());
				reset();
			}
			
			
			
		}
		
	}
	
	
	public void makeBetHere(List<Integer> numbers) {
		try{
			Integer moneyVar = Integer.decode(money.getText().trim());
			Bet bet = new Bet(numbers.get(0),numbers.get(1),
							  numbers.get(2), numbers.get(3),moneyVar);
			this.prize = bet.computeGain(tolo.getDrawnNumbers());
			if(this.prize > 0) {
				textBox2.setText("\n YOU HAVE WON, CONGRATULATIONS.");
			}
			else {
				textBox2.setText(tolo.toString()+"\n YOU HAVE LOST, TRY AGAIN :)");
			}
			prizeId.setText(this.prize+" €");
		}
		catch(Exception e){
			System.out.println(e.toString());
			textBox2.setText(textBox2.getText()+"\n Make sure that your MONEY INPUT is a number.");
			reset();
		}
	}
	
	public void makeSuperBetHere(List<Integer> numbers) {
		try{
			Integer moneyVar = Integer.decode(money.getText().trim());
			Integer luckyVar = Integer.decode(luckyN.getText().trim());
			if(luckyVar > 0 && luckyVar <11) {
				SuperBet superBet = new SuperBet(numbers.get(0),numbers.get(1),
						  numbers.get(2), numbers.get(3),
						  moneyVar, luckyVar);
				this.prize = superBet.computeExtraGain(tolo.getDrawnNumbers(),tolo.getLuckyNumber());
				if(this.prize > 0) {
					textBox2.setText(tolo.toString()+"\n YOU HAVE WON, CONGRATULATIONS.");
				}
				else {
					textBox2.setText(tolo.toString()+"\n YOU HAVE LOST, TRY AGAIN :)");

				}
				prizeId.setText(this.prize+" €");
			}
			else {
				textBox2.setText(textBox2.getText()+"\n You have introduced the a lucky number \n "
						+ "out of the interval.");
				reset();
			}
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			textBox2.setText(textBox2.getText()+"\n Make sure that your MONEY & LUCKY NUMBER INPUT  are numbers.");
			reset();
		}
	}
	
	public void reset() {
		n1.setText("");n2.setText("");
		n3.setText("");n4.setText("");
		money.setText("");luckyN.setText("");
		prizeId.setText("0 €");
	}
	
	
	public void switchToScene1(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
}
