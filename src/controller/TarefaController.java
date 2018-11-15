package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Desejo;
import model.Tarefa;
import repository.DesejosRepository;
import repository.TarefaRepository;
import model.Tarefa;

public class TarefaController extends Controller<Tarefa> implements Initializable {

	
	@FXML
    private AnchorPane apTarefas;
	
	private Tarefa tarefa;

	@FXML
	private TextField tfTitulo;

	@FXML
	private RadioButton rbAguardando;

	@FXML
	private RadioButton rbRealizada;

	@FXML
	private RadioButton rbNaoRealizado;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btAtualizar;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btLimpar;

	@FXML
	private Button btListar;

	@FXML
	private DatePicker dpDatatarefa;

	@FXML
	private TextField tfDescricao;

	@FXML
	private TableView<Tarefa> tvTarefas;
	
	@FXML
	private TableColumn<Tarefa, Integer> tcId;
	
	@FXML
	private TableColumn<Tarefa, String> tcTituloTarefa;

	@FXML
	private TableColumn<Tarefa, LocalDate> tcDataTarefa;

	@FXML
	private TableColumn<Tarefa, String> tcDescricaoTarefa;

	@FXML
	private TableColumn<Tarefa, String> tcStatustTarefa;
	
	
	public  ToggleGroup group; 
	
	

	@FXML
	void handleAtualizar(ActionEvent event) {

		getTarefa().setTituloTarefa(tfTitulo.getText());
		getTarefa().setDataTarefa(dpDatatarefa.getValue());
		getTarefa().setDescricaoTarefa(tfDescricao.getText());

		
		
		RadioButton radio = (RadioButton)group.getSelectedToggle();
		getTarefa().setStatusTarefa(radio.getText());
		

		save(getTarefa());

		handleLimpar(event);
		handleListar(event);
	}

	@FXML
    void handleExcluir(ActionEvent event) {
    	// MENSAGEM DE ALERTA PARA O USUÃ�RIO CONFIRMAR UMA EXCLUSÃƒO
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText("Está operação excluirá todas as informações selecionadas da base de dados.");
		alert.setContentText("Deseja realmente excluir?");
		// Capturar as resposta do usuÃ¡rio sobre a mensagem de confirmaÃ§Ã£o
		Optional<ButtonType> resposta = alert.showAndWait();
		if (resposta.get().equals(ButtonType.OK)) {
			super.remove(getTarefa());
			handleLimpar(event);
		} else if (resposta.get().equals(ButtonType.CANCEL)) {

		}
	

atualizarBotoes();
handleListar(event);
    }

	@FXML
	void handleLimpar(ActionEvent event) {
		tfTitulo.setText("");
		tfDescricao.setText("");
		dpDatatarefa.setValue(null);

		// limpando as informacoes da tarefa
		tarefa = null;
		// setando o focus no Titulo
		tfTitulo.requestFocus();
	}

	@FXML
	void handleOnMouseClicked(MouseEvent event) {
		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
					if (event.getClickCount() == 2) {

						tarefa = tvTarefas.getSelectionModel().getSelectedItem();

						tfTitulo.setText(getTarefa().getTituloTarefa());
						dpDatatarefa.setValue(getTarefa().getDataTarefa());
						tfDescricao.setText(getTarefa().getDescricaoTarefa());
						
						group = new ToggleGroup();

						rbAguardando.setToggleGroup(group);
						rbRealizada.setToggleGroup(group);
						rbNaoRealizado.setToggleGroup(group);
						
						String output = "";

						if (getTarefa().getStatusTarefa().equals("Aguardando")) {
							group.selectToggle(rbAguardando);
							

							
						} 
						
						else if (getTarefa().getStatusTarefa().equals("Realizada")) {
							group.selectToggle(rbRealizada);
						} 
						
						else if(getTarefa().getStatusTarefa().equals("Não realizada")) {
							group.selectToggle(rbNaoRealizado);
						}
						
					

					

						// SETANDO O FOCUS NO NOME
						tfTitulo.requestFocus();

						atualizarBotoes();
					}
				}
	}

	@FXML
	void handleSalvar(ActionEvent event) {
		getTarefa().setTituloTarefa(tfTitulo.getText());
		getTarefa().setDataTarefa(dpDatatarefa.getValue());
		getTarefa().setDescricaoTarefa(tfDescricao.getText());
		
		getTarefa().setPessoa(super.getPessoa());

		
		RadioButton radio = (RadioButton)group.getSelectedToggle();
		getTarefa().setStatusTarefa(radio.getText());
		
		
		
		

		tvTarefas.getItems().add(tarefa);

		super.save(getTarefa());

		handleLimpar(event);
	}

	@FXML
	void handleListar(ActionEvent event) {
		TarefaRepository repository = new TarefaRepository(JPAFactory.getEntityManager());
		List<Tarefa> lista = repository.getTarefa(tfTitulo.getText());

		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação:");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados!");
			alerta.show();
		}

		tvTarefas.setItems(FXCollections.observableList(lista));
	}

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// setando o focus no text field cpf
		tfTitulo.requestFocus();

		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcTituloTarefa.setCellValueFactory(new PropertyValueFactory<>("tituloTarefa"));
		tcDataTarefa.setCellValueFactory(new PropertyValueFactory<>("dataTarefa"));
		tcDescricaoTarefa.setCellValueFactory(new PropertyValueFactory<>("descricaoTarefa"));

		tcStatustTarefa.setCellValueFactory(new PropertyValueFactory<>("statusTarefa"));
		
		
		group = new ToggleGroup();

		rbAguardando.setToggleGroup(group);
		rbAguardando.setSelected(true);
		rbRealizada.setToggleGroup(group);
		rbNaoRealizado.setToggleGroup(group);
	

	}
		    
	
	private void atualizarBotoes() {
		btSalvar.setDisable(getTarefa().getId() != null);

	}

	public Tarefa getTarefa() {
		if (tarefa == null)
			tarefa = new Tarefa();
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
