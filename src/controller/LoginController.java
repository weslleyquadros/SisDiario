package controller;

import java.io.IOException;
import java.util.List;

import application.Util;
import factory.JPAFactory;
import factory.LoginFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Stop;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Desejo;
import model.Pessoa;

import repository.DesejosRepository;
import repository.UsuarioRepository;

public class LoginController extends Controller<Pessoa> {
	private static Pessoa pessoa;
	
	@FXML
    private Button btEsqueceuSenha;

    @FXML
    private Button btLogar;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btFechar;
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
    void handleFechar(ActionEvent event)  {
    	
    
    	Platform.exit();
        System.exit(0);
				

	 
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
		List<Pessoa> lista = repository.getPessoaLogin(tfLogin.getText(), Util.encrypt(pfSenha.getText()));
	
		
		for (Pessoa listaUsuario : lista ) {
			
			listaUsuario.getId();
			//Controller<Pessoa> controller = new Controller<Pessoa>();
			Controller.setPessoa(listaUsuario);
			
		}
		
	
		if(!lista.isEmpty()) {

	    	Button button = (Button) event.getSource();
	    	
	    	Stage stage = (Stage) button.getScene().getWindow();
	    	
	    	stage.close();
			
		      
			
			
		}
		
//    	if(tfLogin.getText().equals("weslley") && pfSenha.getText().equals("1234")){

    		
    	
    	else
    		lbMensagem.setText("Usuário ou senha incorretos.Tente novamente!");
		
	

    }

	public static Pessoa getPessoa() {
		return pessoa;
	}

	public static void setPessoa(Pessoa pessoa) {
		LoginController.pessoa = pessoa;
	}
	public void getParent(Parent root) {
	
		
	}
	public void setParent(Parent root) {
				
	}


	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}
}
