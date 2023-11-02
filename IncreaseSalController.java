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

public class IncreaseSalController { 
    @FXML
    private TextField increaseid;
    @FXML
    private TextField increasesal;

    @FXML
    public void add(ActionEvent e) throws IOException {
        String id = increaseid.getText();
        String salaryText = increasesal.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter ID!");
            return;
        }

        if (salaryText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter salary!");
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for salary!");
            return;
        }

        DataHandler.loadData();
        ArrayList<Employee> employees = Main.myCom.getEmployees();

        for (Employee e1 : employees) {
            if (e1.getId().equals(id)) {
                e1.increaseSalary(salary);
                JOptionPane.showMessageDialog(null, "Salary Updated Successfully!");
                DataHandler.saveData(Main.myCom);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No employee found with ID: " + id);
    }

    public void Exit(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
        Main.stage.show();
    }
}