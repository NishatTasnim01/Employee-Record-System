package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EmployeeLogInController 
{
	public void View_My_Profile(ActionEvent e) throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsOfEmployee.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

	public void Edit_Phone_No(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPhoneNoEmployee.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		EditPhoneNoEmployeeController editphnController = loader.getController();
		editphnController.checkEmployeeId(EmployeeModel.getEmployeeId());

		Main.stage.setScene(scene);
		Main.stage.show();
	}

	public void Search_By_Id(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SearchEmployeeById.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

	public void Search_By_Name(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SearchEmployeeByName.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

	public void Daily_Record(ActionEvent e) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("EnterDailyRecordEmp.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);

		EnterDailyRecordEmpController dailyrecordController = loader.getController();
		dailyrecordController.checkEmployeeId(EmployeeModel.getEmployeeId());

		Main.stage.setScene(scene);
		Main.stage.show();
	}

	public void Switch_Role(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void EXIT(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ThankYou.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}