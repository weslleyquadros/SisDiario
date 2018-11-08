package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import model.Desejo;

import repository.DesejosRepository;


public class DesejoController extends Controller<Desejo> implements Initializable {

	private Desejo desejo;
    @FXML
    private TextField tfDesejo;

    @FXML
    private RadioButton rbAguardando;

    @FXML
    private RadioButton rbRealizado;

    @FXML
    private RadioButton rbNaoRealizado;

    @FXML
    private ToggleGroup status;

    @FXML
    private TableView<Desejo> tvListDesejos;

    @FXML
    private TableColumn<Desejo, String> tcStatus;

    @FXML
    private TableColumn<Desejo, String> tcDesejo;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btAtualizar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btLimpar;

    @FXML
    void handleAtualizar(ActionEvent event) {

    	getDesejo().setDescricao(tfDesejo.getText());

    	String output="";
		
		if (rbAguardando.isSelected()) {
			output = rbAguardando.getText();
			getDesejo().setStatus(output);
			
			
		} 
		
		if (rbRealizado.isSelected()) {
			output = rbRealizado.getText();
			getDesejo().setStatus(output);
		} 
		
		if(rbNaoRealizado.isSelected()) {
			output = rbNaoRealizado.getText();
			
			getDesejo().setStatus(output);
		}

		super.save(getDesejo());

		handleLimpar(event);
		handleListar(event);
    }

    @FXML
    void handleExcluir(ActionEvent event) {
    	/*//tfCpf.setText("");
    	System.exit(0);*/
    	
    	
    	
    	// MENSAGEM DE ALERTA PARA O USUÃ�RIO CONFIRMAR UMA EXCLUSÃƒO
    			Alert alert = new Alert(AlertType.CONFIRMATION);
    			alert.setTitle("Confirmação");
    			alert.setHeaderText("Está operação excluirá todas as informações selecionadas da base de dados.");
    			alert.setContentText("Deseja realmente excluir?");
    			// Capturar as resposta do usuÃ¡rio sobre a mensagem de confirmaÃ§Ã£o
    			Optional<ButtonType> resposta = alert.showAndWait();
    			if (resposta.get().equals(ButtonType.OK)) {
    				super.remove(getDesejo());
    				handleLimpar(event);
    			} else if (resposta.get().equals(ButtonType.CANCEL)) {

    			}
    		

		atualizarBotoes();
		handleListar(event);

    }

    @FXML
    void handleLimpar(ActionEvent event) {
    	
    	tfDesejo.setText("");
	
		
		
		

		// LIMPANDO AS INFORMAÃ‡Ã•ES DO CLIENTE
		desejo = null;

		/*// LIMPAR AS TABELAS
		tvClientes.getItems().clear();
		tbTelefone.getItems().clear();*/

		tfDesejo.requestFocus();

		atualizarBotoes();

    }

    @FXML
    void handleSalvar(ActionEvent event) {
    	getDesejo().setDescricao(tfDesejo.getText());
    	
        	
    	
    	String output="";
		
		if (rbAguardando.isSelected()) {
			output = rbAguardando.getText();
			getDesejo().setStatus(output);
			rbAguardando.setSelected(true);
			rbAguardando.requestFocus();
			
		} 
		
		if (rbRealizado.isSelected()) {
			output = rbRealizado.getText();
			getDesejo().setStatus(output);
			rbRealizado.setSelected(true);
			rbRealizado.requestFocus();
		} 
		
		if(rbNaoRealizado.isSelected()) {
			output = rbNaoRealizado.getText();
					
			getDesejo().setStatus(output);
		
			rbNaoRealizado.setSelected(true);
			rbNaoRealizado.requestFocus();
		}
		
		

		tvListDesejos.getItems().add(desejo);

		super.save(getDesejo());

		handleLimpar(event);
    }
    
    @FXML
	void handleOnMouseClicked(MouseEvent event) {

		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
			if (event.getClickCount() == 2) {

				desejo = tvListDesejos.getSelectionModel().getSelectedItem();
				
				
				tfDesejo.setText(getDesejo().getDescricao());
				
				
						

			

				// SETANDO O FOCUS NO NOME
				tfDesejo.requestFocus();

				atualizarBotoes();
			}
		}
	}
    
    
    @FXML
	void handleListar(ActionEvent event) {
		DesejosRepository repository = new DesejosRepository(JPAFactory.getEntityManager());
		List<Desejo> lista = repository.getDesejo(tfDesejo.getText());

		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação:");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados!");
			alerta.show();
		}

		tvListDesejos.setItems(FXCollections.observableList(lista));
	}


    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// setando o focus no text field cpf
		tfDesejo.requestFocus();

		tcDesejo.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		final ToggleGroup group = new ToggleGroup();

		rbAguardando.setToggleGroup(group);
		rbAguardando.setSelected(true);
		rbRealizado.setToggleGroup(group);
		rbNaoRealizado.setToggleGroup(group);

	}
		    
	  

	


	private void atualizarBotoes() {
		btSalvar.setDisable(getDesejo().getId() != null);
		btAtualizar.setDisable(getDesejo().getId() == null);
		btExcluir.setDisable(getDesejo().getId() == null);
		
	}

	public Desejo getDesejo() {
		if (desejo == null)
			desejo = new Desejo();
		return desejo;
	}

	public void setDesejo(Desejo desejo) {
		this.desejo = desejo;
	}

	
	
}
