package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

	@FXML
    private Button btEsqueceuSenha;

    @FXML
    private Button btLogar;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField pfSenha;

    @FXML
    private Label lbMensagem;
    
    @FXML
    void handleCadastrar(ActionEvent event) throws IOException {
	    	FXMLLoader fXMLLoader = new FXMLLoader();
			fXMLLoader.setLocation(getClass().getResource("/view/cadastroPessoa.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(fXMLLoader.load());
			stage.setScene(scene);

			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Realizar Tarefas");
			stage.show();

	   

    }

    @FXML
    void handleEsqueceuSenha(ActionEvent event) throws IOException {
	    	FXMLLoader fXMLLoader = new FXMLLoader();
			fXMLLoader.setLocation(getClass().getResource("/view/recuperarSenha.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(fXMLLoader.load());
			stage.setScene(scene);

			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Realizar Tarefas");
			stage.show();

	 
    }

    @FXML
    void handleLogar(ActionEvent event) throws IOException {
    	
    	if(tfLogin.getText().equals("weslley") && pfSenha.getText().equals("1234")){
    		FXMLLoader fXMLLoader = new FXMLLoader();
    		fXMLLoader.setLocation(getClass().getResource("/view/telaInicial.fxml"));
    		Stage stage = new Stage();
    		Scene scene = new Scene(fXMLLoader.load());
    		stage.setScene(scene);

    		stage.initModality(Modality.APPLICATION_MODAL);
    		stage.setTitle("Inicio --- SisDiario");
    		stage.show();
    		
    	}
    	else
    		lbMensagem.setText("Usuário ou senha incorretos.Tente novamente!");

    }
}
