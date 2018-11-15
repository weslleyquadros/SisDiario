package factory;

import java.io.IOException;

import controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class LoginFactory {
	public static LoginController getInstance() throws IOException {

		FXMLLoader loader = new FXMLLoader(LoginFactory.class.getClass().getResource("/view/login.fxml"));

		Parent root = loader.load();

		LoginController listagem = loader.getController();
		listagem.setParent(root);

		return listagem;

	}
}