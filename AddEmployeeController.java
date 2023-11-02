package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class AddEmployeeController implements Initializable {
	
	@FXML
	private TextField name;
	@FXML
	private TextField age;
	@FXML
	private TextField des;
	@FXML
	private TextField phn;
	@FXML
	private TextField sal;

	@Override
    public void initialize(URL arg0, ResourceBundle arg1) 
	{
        Company com = new Company("UAP");
        ArrayList<Employee> employees = Main.myCom.getEmployees();

        if (employees.size() == 0) {
            DataHandler.saveData(com);
        }
    }

	public void addSalariedEmployee(ActionEvent event) {
		String name1 = name.getText();
		String age1 = age.getText();
		String desig = des.getText();
		String phnNo = phn.getText();
		String salary = sal.getText();

		int Age;
		double Salary;
		boolean b1 = false;
		boolean b2 = false;

		if (name1.isEmpty() || age1.isEmpty() || desig.isEmpty() || phnNo.isEmpty() || salary.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all fields.");
			return;
		}

		try {
			Age = Integer.parseInt(age1);
			b1 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Age must be a number!");
			return;
		}
		try {
			Salary = Double.parseDouble(salary);
			b2 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Salary must be a double!");
			return;
		}

		if (b1 && b2) {
			String id = Main.myCom.addSalariedEmployee(name1, Integer.parseInt(age1), desig, phnNo,
					Double.parseDouble(salary));

			DataHandler.saveData(Main.myCom);
			JOptionPane.showMessageDialog(null, id + " Successfully Added!");
			initialize(null, null);
		}
	}

	public void addHourlyEmployee(ActionEvent event) {
		String name1 = name.getText();
		String age1 = age.getText();
		String desig = des.getText();
		String phnNo = phn.getText();
		String salary = sal.getText();

		int Age;
		double Salary;
		boolean b1 = false;
		boolean b2 = false;

		if (name1.isEmpty() || age1.isEmpty() || desig.isEmpty() || phnNo.isEmpty() || salary.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all fields.");
			return;
		}

		try {
			Age = Integer.parseInt(age1);
			b1 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Age must be a number!");
			return;
		}
		try {
			Salary = Double.parseDouble(salary);
			b2 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Salary must be a double!");
			return;
		}

		if (b1 && b2) {
			String id = Main.myCom.addHourlyEmployee(name1, Integer.parseInt(age1), desig, phnNo, Double.parseDouble(salary));

			DataHandler.saveData(Main.myCom);
			JOptionPane.showMessageDialog(null, id + " Successfully Added!");
			initialize(null, null);
		}
	}

	public void addCommissionEmployee(ActionEvent event) {
		String name1 = name.getText();
		String age1 = age.getText();
		String desig = des.getText();
		String phnNo = phn.getText();
		String salary = sal.getText();

		int Age;
		double Salary;
		boolean b1 = false;
		boolean b2 = false;

		if (name1.isEmpty() || age1.isEmpty() || desig.isEmpty() || phnNo.isEmpty() || salary.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all fields.");
			return;
		}
		try {
			Age = Integer.parseInt(age1);
			b1 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Age must be a number!");
			return;
		}
		try {
			Salary = Double.parseDouble(salary);
			b2 = true;
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Salary must be a double!");
			return;
		}

		if (b1 && b2) {
			String id = Main.myCom.addCommissionEmployee(name1, Integer.parseInt(age1), desig, phnNo,
					Double.parseDouble(salary));

			DataHandler.saveData(Main.myCom);
			JOptionPane.showMessageDialog(null, id + " Successfully Added!");
			initialize(null, null);
		}
	}

	public void exit(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}