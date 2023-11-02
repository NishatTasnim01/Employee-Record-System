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
import lib.DataHandler;
import lib.Employee;
import lib.Company;

public class EditPhoneNoEmployeeController {

    @FXML
    private TextField phoneField;

    private String searchedEmployeeId;

    public void checkEmployeeId(String employeeId) 
    {
        searchedEmployeeId = employeeId;
    }

    @FXML
    private void editPhoneNo() throws IOException {
        String phone = phoneField.getText();

        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter New Phone Number!");
            return;
        }

        // Load the company data from the file
        Company company = DataHandler.loadData();

        // Get the list of employees
        ArrayList<Employee> employees = company.getEmployees();

        // Loop through the list of employees and find the employee with the matching ID
        for (Employee e : employees) {
            if (e.getId().equals(searchedEmployeeId)) {
                // Update the employee's phone number
                e.setPhoneNum(phone);
                JOptionPane.showMessageDialog(null, "Phone Number Updated Successfully!");

                // Save the updated company data to the file
                DataHandler.saveData(company);
                return;
            }
        }

        // If the loop completes without finding an employee with the given ID
        JOptionPane.showMessageDialog(null, "No employee found with ID: " + searchedEmployeeId);
    }

    public void EXIT(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
        Scene scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.show();
    }
}