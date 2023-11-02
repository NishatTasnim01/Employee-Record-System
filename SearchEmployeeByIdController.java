package application;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lib.Company;
import lib.DataHandler;
import lib.Employee;

public class SearchEmployeeByIdController {
    @FXML
    private TextField idTextField;

    @FXML
    private TableView<Employee> employeeTableView;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Integer> ageColumn;
    @FXML
    private TableColumn<Employee, String> designationColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;
    @FXML
    private TableColumn<Employee, Double> salaryColumn;

    public void initialize() {
        // Initialize table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    public void searchEmployeeById(ActionEvent event) throws IOException {
        String id = idTextField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID!");
            employeeTableView.setItems(null);
            return;
        }
        
        // Load company data from file
        Company company = DataHandler.loadData();
        ArrayList<Employee> employees = company.getEmployees();

        // Search for employee by ID
        ObservableList<Employee> searchResults = FXCollections.observableArrayList();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                searchResults.add(employee);
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Invalid ID! No employee found with the given ID!");
            employeeTableView.setItems(null);
        }

        // Display search results in table
        employeeTableView.setItems(searchResults);
    }

    public void EXIT(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeLogIn.fxml"));
        Scene scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.show();
    }
}