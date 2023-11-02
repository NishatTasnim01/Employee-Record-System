package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class adminmenucontroller {


	public void addEmp(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	
	public void increase(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("increaseSal.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	public void salary(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("salary.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void emp(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("empdetails.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void allEmp(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("allEmp.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void record(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("record.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	public void SwtichRole(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
	public void Exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ThankYou.fxml"));
		Scene scene = new Scene(root);
		
		Main.stage.setScene(scene);
		Main.stage.show();
	}
	
}
