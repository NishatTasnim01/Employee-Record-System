package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lib.Company;
import lib.DataHandler;
import lib.InvalidEmployeeException;

public class EnterDailyRecordEmpController implements Initializable {
    @FXML
    private TextField hourSaleTextField;
    @FXML
    private Button enterButton;
    @FXML
    private Label resultLabel;

    private Company company;

    private String searchedEmployeeId;

    public void checkEmployeeId(String employeeId) {
        searchedEmployeeId = employeeId;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load the data from the file
        company = DataHandler.loadData();
    }

    public void enter(ActionEvent event) {
        String hourSale = hourSaleTextField.getText();

        if (hourSale.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Hour/Sale field!");
            return;
        } else {
            try {
                double value = Double.parseDouble(hourSale);

                // Add the daily record for the employee
                company.addRecord(searchedEmployeeId, value);

                // Save the updated data to the file
                DataHandler.saveData(company);

                JOptionPane.showMessageDialog(null, "Daily record added successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for Hour/Sale.");
            } catch (InvalidEmployeeException e) {
                JOptionPane.showMessageDialog(null, "No employee found with ID: " + searchedEmployeeId);
            }
        }
    }

    public void back(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
        Scene scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.show();
    }
}