package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LogInPageController 
{
	public void admin(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("adminmenu.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
	public void employee(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("VerifyEmployee.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}

}