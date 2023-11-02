package application;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lib.DataHandler;
import lib.Employee;

public class AllEmpController {
    @FXML
    private TableView<Employee> empTableView;
    @FXML
    private TableColumn<Employee, String> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> ageColumn;
    @FXML
    private TableColumn<Employee, String> designationColumn;
    @FXML
    private TableColumn<Employee, String> phoneColumn;
    @FXML
    private TableColumn<Employee, String> salaryColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
        phoneColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getPhoneNum()));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ArrayList<Employee> employees = DataHandler.loadData().getEmployees();
        empTableView.getItems().addAll(employees);
    }

    @FXML
    public void empTableViewOnMouseClicked(MouseEvent event) 
    {
        if (event.getClickCount() == 2) 
        {
            TableColumn<?, ?> selectedColumn = empTableView.getSelectionModel().getSelectedCells().get(0).getTableColumn();
            if (selectedColumn == idColumn) 
            {
                Employee selectedEmployee = empTableView.getSelectionModel().getSelectedItem();
                if (selectedEmployee != null) 
                {
                    String id = selectedEmployee.getId();
                    copyToClipboard(id);
                }
            }
        }
    }

    private void copyToClipboard(String content) {
        StringSelection selection = new StringSelection(content);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        
        JOptionPane.showMessageDialog(null, ("ID : " + content + " copied to clipboard!"));
        return;
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
        Scene scene = new Scene(root);

        Main.stage.setScene(scene);
        Main.stage.show();
    }
}




//package application;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.Clipboard;
//import javafx.scene.input.ClipboardContent;
//import javafx.scene.input.MouseEvent;
//import lib.DataHandler;
//import lib.Employee;
//
//public class AllEmpController {
//    @FXML
//    private TableView<Employee> empTableView;
//    @FXML
//    private TableColumn<Employee, String> idColumn;
//    @FXML
//    private TableColumn<Employee, String> nameColumn;
//    @FXML
//    private TableColumn<Employee, String> ageColumn;
//    @FXML
//    private TableColumn<Employee, String> designationColumn;
//    @FXML
//    private TableColumn<Employee, String> phoneColumn;
//    @FXML
//    private TableColumn<Employee, String> salaryColumn;
//
//    @FXML
//    public void initialize() {
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//        designationColumn.setCellValueFactory(new PropertyValueFactory<>("designation"));
//        phoneColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getPhoneNum()));
//        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
//
//        ArrayList<Employee> employees = DataHandler.loadData().getEmployees();
//        empTableView.getItems().addAll(employees);
//    }
//
//    @FXML
//    public void empTableViewOnMouseClicked(MouseEvent event) {
//        if (event.getClickCount() == 2) {
//            TableColumn<?, ?> selectedColumn = empTableView.getSelectionModel().getSelectedCells().get(0).getTableColumn();
//            if (selectedColumn == idColumn) {
//                Employee selectedEmployee = empTableView.getSelectionModel().getSelectedItem();
//                if (selectedEmployee != null) {
//                    String id = selectedEmployee.getId();
//                    copyToClipboard(String.valueOf(id));
//                }
//            }
//        }
//    }
//
//    private void copyToClipboard(String content) {
//        Clipboard clipboard = Clipboard.getSystemClipboard();
//        ClipboardContent clipboardContent = new ClipboardContent();
//        clipboardContent.putString(content);
//        clipboard.setContent(clipboardContent);
//        
//        JOptionPane.showMessageDialog(null, ("ID copied to the clipboard."));
//        return;
//    }
//
//    @FXML
//    public void exit(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
//        Scene scene = new Scene(root);
//
//        Main.stage.setScene(scene);
//        Main.stage.show();
//    }
//}