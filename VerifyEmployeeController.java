package application;

import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lib.Employee;

public class VerifyEmployeeController {
    @FXML
    private AnchorPane verifyEmployeePane;

    @FXML
    private Text errorText;

    @FXML
    private Button enterButton;

    @FXML
    private TextField enteremployeeid;

    private boolean isEmployeeIdValid(String id) {
        for (Employee e : Main.myCom.getEmployees()) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void ENTER(ActionEvent e) throws IOException {
        String id = enteremployeeid.getText();
        if (isEmployeeIdValid(id)) {
            EmployeeModel.setEmployeeId(id); // Store the employee ID in the EmployeeModel
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeLogIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.show();
        } else {
            JOptionPane.showMessageDialog(null, ("Sorry! Could not find employee with ID: " + id));
            return;
        }
    }

    public void EXIT(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
        Main.stage.show();
    }
}