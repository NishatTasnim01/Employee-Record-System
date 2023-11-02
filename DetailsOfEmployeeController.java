package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class DetailsOfEmployeeController implements Initializable {
	@FXML
	private TextField nameField;
	@FXML
	private TextField ageField;
	@FXML
	private TextField desField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField salField;

	private String searchedEmployeeId = EmployeeModel.getEmployeeId();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		if (searchedEmployeeId == null) 
		{
			// Handle the case when searchedEmployeeId is null
			System.out.println("Employee ID is null.");
			return;
		}

		Company company = DataHandler.loadData();
		try 
		{
			Employee emp = company.findEmployee(searchedEmployeeId);
			if (emp == null) 
			{
				// Handle the case when the employee is not found
				System.out.println("Employee with ID: " + searchedEmployeeId + " is not found.");
				return;
			}

			nameField.setText(emp.getName());
			ageField.setText(Integer.toString(emp.getAge()));
			desField.setText(emp.getDesignation());
			phoneField.setText(emp.getPhoneNum());
			salField.setText(Double.toString(emp.getSalary()));
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void EXIT() throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}