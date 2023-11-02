package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ThankYouController 
{
	public void EnterApp(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
		Scene scene = new Scene(root);

		Main.stage.setScene(scene);
		Main.stage.show();
	}
}
