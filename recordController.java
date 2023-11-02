//package application;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//import javax.swing.JOptionPane;
//
//import javafx.beans.property.SimpleDoubleProperty;
//import javafx.beans.property.SimpleStringProperty;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import lib.Company;
//import lib.DataHandler;
//import lib.DailyRecord;
//import lib.Employee;
//import lib.InvalidEmployeeException;
//
//public class recordController implements Initializable {
//
//    @FXML
//    private TextField employeeIdTextField;
//
//    @FXML
//    private Button searchButton;
//
//    @FXML
//    private TableView<DailyRecord> dailyRecordTableView;
//
//    @FXML
//    private TableColumn<DailyRecord, String> dateColumn;
//
//    @FXML
//    private TableColumn<DailyRecord, Double> hoursOrSaleColumn;
//
//    private Company company;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        company = DataHandler.loadData();
//        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().toString()));
//        hoursOrSaleColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getHour_Or_Sale()).asObject());
//    }
//
//    @FXML
//    private void searchButtonAction(ActionEvent event) {
//        String employeeId = employeeIdTextField.getText();
//
//        if (employeeId.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter an ID!");
//            return;
//        }
//
//        try {
//            Employee employee = company.findEmployee(employeeId);
//            ArrayList<DailyRecord> dailyRecords = company.getDailyRecords(employeeId);
//            dailyRecordTableView.getItems().setAll(dailyRecords);
//        } catch (InvalidEmployeeException e) {
//            JOptionPane.showMessageDialog(null, "Invalid ID! No employee found with the given ID!");
//            dailyRecordTableView.getItems().clear();
//        }
//    }
//
//    public void Exit(ActionEvent e) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
//        Scene scene = new Scene(root);
//
//        Main.stage.setScene(scene);
//        Main.stage.show();
//    }
//}


package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import lib.Company;
import lib.DataHandler;
import lib.DailyRecord;
import lib.Employee;
import lib.InvalidEmployeeException;

public class recordController implements Initializable {

    @FXML
    private TextField employeeIdTextField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<DailyRecord> dailyRecordTableView;

    @FXML
    private TableColumn<DailyRecord, String> dateColumn;

    @FXML
    private TableColumn<DailyRecord, Double> hoursOrSaleColumn;

    private Company company;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        company = DataHandler.loadData();
        dateColumn.setCellValueFactory(getDateCellValueFactory());
        hoursOrSaleColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getHour_Or_Sale()).asObject());
    }

    private Callback<TableColumn.CellDataFeatures<DailyRecord, String>, ObservableValue<String>> getDateCellValueFactory() {
        return data -> {
            LocalDate date = extractDateFromData(data);
            String formattedDate = formatDate(date);
            return new SimpleStringProperty(formattedDate);
        };
    }

    private LocalDate extractDateFromData(TableColumn.CellDataFeatures<DailyRecord, String> data) {
        String recordText = data.getValue().toString();
        String[] parts = recordText.split(" : ");
        if (parts.length >= 2) {
            String dateString = parts[1];
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } else {
            // Handle the case when the record text doesn't have the expected format
            return LocalDate.now();  // Or return a default value
        }
    }

    private String formatDate(LocalDate date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
    }

    @FXML
    private void searchButtonAction(ActionEvent event) {
        String employeeId = employeeIdTextField.getText();

        if (employeeId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID!");
            return;
        }

        try {
            Employee employee = company.findEmployee(employeeId);
            ArrayList<DailyRecord> dailyRecords = company.getDailyRecords(employeeId);
            dailyRecordTableView.getItems().setAll(dailyRecords);
        } catch (InvalidEmployeeException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID! No employee found with the given ID!");
            dailyRecordTableView.getItems().clear();
        }
    }

    public void Exit(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
        Scene scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.show();
    }
}