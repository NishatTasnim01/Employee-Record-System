package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class salarycontroller {
	@FXML
	private TextField salaryid  ;
	@FXML
	private TextField viewsal  ;


	@FXML
	public void search(ActionEvent e) throws IOException {
		String employeeId = salaryid.getText();

		Company company = DataHandler.loadData();
		ArrayList<Employee> employees = company.getEmployees();
		boolean found =false ;
		for (Employee employee : employees) 
		{
			if (employee.getId().equals(employeeId)) 
			{
				viewsal.setText(Double.toString(employee.getSalary()));
				found = true;
				break;
			}
		}

		if (!found) 
		{
			JOptionPane.showMessageDialog(null, ("Could not find employee with ID " + employeeId));
			return;

		}
	}

	public void Exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}