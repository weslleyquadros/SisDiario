package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Pessoa;
import repository.UsuarioRepository;

public class TelaInicialController extends Controller implements Initializable {

	public static Parent DiarioView;
	public static Parent LerDiarioView;
	public static Parent DesejosView;
	public static Parent TarefasView;
	public static Parent ContrGastosView;
	//private Pessoa pessoa;

	@FXML
	private ScrollPane scrollPane;

	@FXML
	private Label lbUsuario;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Abrindo tela de login
		abrirTelaLogin();
		//scrollPane.setFitToHeight(true);
		//scrollPane.setFitToWidth(true);
		
		try {
			DiarioView = FXMLLoader.load(Main.class.getResource("/view/diario.fxml"));
			LerDiarioView = FXMLLoader.load(Main.class.getResource("/view/lerDiario.fxml"));
			DesejosView = FXMLLoader.load(Main.class.getResource("/view/desejo.fxml"));
			TarefasView = FXMLLoader.load(Main.class.getResource("/view/tarefa.fxml"));
			ContrGastosView = FXMLLoader.load(Main.class.getResource("/view/controleGastos.fxml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/*@FXML
	void handleBloquear(ActionEvent event) {

		abrirTelaLogin();
	}*/

	private void abrirTelaLogin(){
		// Abrindo tela de login
		Stage stage = new Stage(StageStyle.TRANSPARENT);
		Parent parent;
		try {
			parent = FXMLLoader.load(Main.class.getResource("/view/Login.fxml"));
			Scene scene = new Scene(parent, 600, 418);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.showAndWait();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lbUsuario.setText(super.getPessoa().getNome());
		//atualizando a interface com o usuario logado
	//	labelUsuario.setText(UsuarioRepository. .getNome());
		
		//bloqueando botoes de conforme o perfil
				
	/*	if(Controller.getUsuarioLogado().getPerfil().equals(Perfil.ADMINISTRADOR)) {
			
			btCadastroCidade.setDisable(false);
			btCadastroCliente.setDisable(false);
		}
		else if(Controller.getUsuarioLogado().getPerfil().equals(Perfil.CADASTRO)) {
			btCadastroCidade.setDisable(true); //desabilita o cadastro de cidade
			btCadastroCliente.setDisable(false);
			*/
			
		}

		 @FXML 
		 void handleAbrirEscreverDiario(ActionEvent event) throws IOException {
		  
			 VBox vbox = new VBox();
				vbox.setAlignment(Pos.TOP_CENTER);
				vbox.getChildren().add(DiarioView);
				scrollPane.setContent(vbox);
				
			 /* FXMLLoader fXMLLoader = new FXMLLoader();
		  fXMLLoader.setLocation(getClass().getResource("/view/diario.fxml")); Stage
		  stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
		  stage.setScene(scene);
		  
		 stage.initModality(Modality.APPLICATION_MODAL);
		 stage.setTitle("Escrever Diario"); stage.show();*/ 
		 }
		  
		  @FXML 
		  void handleAbrirLerDiario(ActionEvent event) throws IOException {
		  
		  /*FXMLLoader fXMLLoader = new FXMLLoader();
		  fXMLLoader.setLocation(getClass().getResource("/view/lerDiario.fxml")); Stage
		  stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
		  stage.setScene(scene);
		  
		  stage.initModality(Modality.APPLICATION_MODAL); stage.setTitle("Ler Diario");
		  stage.show();*/
			 
			  VBox vbox = new VBox();
				vbox.setAlignment(Pos.TOP_CENTER);
				vbox.getChildren().add(LerDiarioView);
				scrollPane.setContent(vbox);
		  }
		  
		  @FXML 
		  void handleAbrirDesejos(ActionEvent event) throws IOException {
		  
		 /* FXMLLoader fXMLLoader = new FXMLLoader();
		  fXMLLoader.setLocation(getClass().getResource("/view/desejo.fxml")); Stage
		  stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
		  stage.setScene(scene);
		 
		  stage.initModality(Modality.APPLICATION_MODAL);
		  stage.setTitle("Escrever Desejos"); stage.show();*/
			  
			  VBox vbox = new VBox();
				vbox.setAlignment(Pos.TOP_CENTER);
				vbox.getChildren().add(DesejosView);
				scrollPane.setContent(vbox);
		  }
		  
		  @FXML 
		  void handleAbrirFinanceiro(ActionEvent event) throws IOException {
		  /*FXMLLoader fXMLLoader = new FXMLLoader();
		  fXMLLoader.setLocation(getClass().getResource("/view/controleGastos.fxml"));
		  Stage stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
		  stage.setScene(scene);
		  
		  stage.initModality(Modality.APPLICATION_MODAL);
		  stage.setTitle("Controle de Gastos"); stage.show();*/
			  
			  VBox vbox = new VBox();
				vbox.setAlignment(Pos.TOP_CENTER);
				vbox.getChildren().add(ContrGastosView);
				scrollPane.setContent(vbox);
		  
		  }
		  
		  @FXML 
		  void handleAbrirTarefas(ActionEvent event) throws IOException {
		 /* FXMLLoader fXMLLoader = new FXMLLoader();
		  fXMLLoader.setLocation(getClass().getResource("/view/tarefa.fxml")); Stage
		  stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
		  stage.setScene(scene);
		  
		  stage.initModality(Modality.APPLICATION_MODAL);
		  stage.setTitle("Realizar Tarefas"); stage.show();
*/		  
			  
			  VBox vbox = new VBox();
				vbox.setAlignment(Pos.TOP_CENTER);
				vbox.getChildren().add(TarefasView);
				scrollPane.setContent(vbox);
		  }


	
		
		
		
	}

	/*
	 * @FXML private Label lbUsuarioLogado;
	 * 
	 * 
	 * @FXML void handleAbrirEscreverDiario(ActionEvent event) throws IOException {
	 * 
	 * FXMLLoader fXMLLoader = new FXMLLoader();
	 * fXMLLoader.setLocation(getClass().getResource("/view/diario.fxml")); Stage
	 * stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
	 * stage.setScene(scene);
	 * 
	 * stage.initModality(Modality.APPLICATION_MODAL);
	 * stage.setTitle("Escrever Diario"); stage.show(); }
	 * 
	 * @FXML void handleAbrirLerDiario(ActionEvent event) throws IOException {
	 * 
	 * FXMLLoader fXMLLoader = new FXMLLoader();
	 * fXMLLoader.setLocation(getClass().getResource("/view/lerDiario.fxml")); Stage
	 * stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
	 * stage.setScene(scene);
	 * 
	 * stage.initModality(Modality.APPLICATION_MODAL); stage.setTitle("Ler Diario");
	 * stage.show(); }
	 * 
	 * @FXML void handleAbrirDesejos(ActionEvent event) throws IOException {
	 * 
	 * FXMLLoader fXMLLoader = new FXMLLoader();
	 * fXMLLoader.setLocation(getClass().getResource("/view/desejo.fxml")); Stage
	 * stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
	 * stage.setScene(scene);
	 * 
	 * stage.initModality(Modality.APPLICATION_MODAL);
	 * stage.setTitle("Escrever Desejos"); stage.show(); }
	 * 
	 * @FXML void handleAbrirFinanceiro(ActionEvent event) throws IOException {
	 * FXMLLoader fXMLLoader = new FXMLLoader();
	 * fXMLLoader.setLocation(getClass().getResource("/view/controleGastos.fxml"));
	 * Stage stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
	 * stage.setScene(scene);
	 * 
	 * stage.initModality(Modality.APPLICATION_MODAL);
	 * stage.setTitle("Controle de Gastos"); stage.show();
	 * 
	 * }
	 * 
	 * @FXML void handleAbrirTarefas(ActionEvent event) throws IOException {
	 * FXMLLoader fXMLLoader = new FXMLLoader();
	 * fXMLLoader.setLocation(getClass().getResource("/view/tarefa.fxml")); Stage
	 * stage = new Stage(); Scene scene = new Scene(fXMLLoader.load());
	 * stage.setScene(scene);
	 * 
	 * stage.initModality(Modality.APPLICATION_MODAL);
	 * stage.setTitle("Realizar Tarefas"); stage.show();
	 * 
	 * }
	 * 
	 * @Override public void initialize(URL location, ResourceBundle resources) {
	 * 
	 * 
	 * UsuarioRepository repository = new
	 * UsuarioRepository(JPAFactory.getEntityManager());
	 * 
	 * 
	 * 
	 * 
	 * }
	 */


