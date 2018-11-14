package controller;

import java.io.IOException;
import java.util.List;

import factory.JPAFactory;
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
import model.Desejo;
import model.Pessoa;
import repository.DesejosRepository;
import repository.UsuarioRepository;

public class LoginController {
	private Pessoa pessoa;
	
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
    	tfLogin.getText();
    	pfSenha.getText();
    	
		UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
		List<Pessoa> lista = repository.getPessoaLogin(tfLogin.getText(), pfSenha.getText());

		
		if(!lista.isEmpty()) {
    		FXMLLoader fXMLLoader = new FXMLLoader();
    		fXMLLoader.setLocation(getClass().getResource("/view/telaInicial.fxml"));
    		Stage stage = new Stage();
    		Scene scene = new Scene(fXMLLoader.load());
    		stage.setScene(scene);

    		stage.initModality(Modality.APPLICATION_MODAL);
    		stage.setTitle("Inicio --- SisDiario");
    		stage.show();
		}
		
//    	if(tfLogin.getText().equals("weslley") && pfSenha.getText().equals("1234")){

    		
    	
    	else
    		lbMensagem.setText("Usuário ou senha incorretos.Tente novamente!");

    }
}
