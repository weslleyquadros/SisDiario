package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.fxml.Initializable;

import model.Gastos;
import model.Meses;
import model.Tarefa;
import repository.GastosRepository;
import repository.TarefaRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GastosController extends Controller<Gastos> implements Initializable {

	@FXML
    private AnchorPane apGastos;
	
	private Gastos gastos;
	@FXML
	private TextField tfSaldoAtual;

	@FXML
	private ComboBox<Meses> cbMesRef;

	@FXML
	private Label lbValor;

	@FXML
	private TableView<Gastos> tvSaidas;

	@FXML
	private TableColumn<Gastos, LocalDate> tcDataSaida;

	@FXML
	private TableColumn<Gastos, String> tcMes;

	@FXML
	private TableColumn<Gastos, String> tcDescricao;

	@FXML
	private Button btAtualizar;

	@FXML
	private Button btLimpar;

	@FXML
	private Button btSalvar;
	@FXML
	private Button btExcluir;

	@FXML
	private TextField tfDescricao;

	@FXML
	private DatePicker dpDataSaida;

	@FXML
	private Button btListar;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		super.ajustarPane(apGastos);
		tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tcMes.setCellValueFactory(new PropertyValueFactory<>("meses"));

		cbMesRef.getItems().addAll(Meses.values());

		// lbValor.setText("Valor Atual R$ :"+tfSaldoAtual.getText());

		// setando uma fabrica no combobox. sera criada com cada item.
		cbMesRef.setCellFactory(c -> new ListCell<Meses>() {

			@Override
			protected void updateItem(Meses item, boolean empty) {
				// TODO Auto-generated method stub
				super.updateItem(item, empty);

				if (item == null || empty)
					setText(null);

				else
					// setText(item.getId()+"-"+item.getLabel());

					setText(item.getLabel());
			}
		});

		cbMesRef.setButtonCell(new ListCell<Meses>() {

			@Override
			protected void updateItem(Meses item, boolean empty) {
				// TODO Auto-generated method stub
				super.updateItem(item, empty);

				if (item == null || empty)
					setText(null);

				else
					setText(item.getLabel());
			}
		});

	}

	@FXML
	void handleAbrir(MouseEvent event) throws IOException {
		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
			if (event.getClickCount() == 1) {

				Parent root = FXMLLoader.load(getClass().getResource("/calculadora/calculadora.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.show();

			}
		}
	}

	/*
	 * @FXML void handleAbrirCalc(ActionEvent event) {
	 * 
	 * }
	 */

	@FXML
	void handleAtualizar(ActionEvent event) {

		getGastos().setSaldoAtual(tfSaldoAtual.getText());

		getGastos().setMeses(cbMesRef.getValue());
		getGastos().setDescricao(tfDescricao.getText());

		getGastos().setDataSaida(dpDataSaida.getValue());

		save(getGastos());
		atualizarValor();
		
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
			super.remove(getGastos());
			handleLimpar(event);
		} else if (resposta.get().equals(ButtonType.CANCEL)) {

		}
		atualizarValor();
		atualizarBotoes();
		handleListar(event);
	}

	@FXML
	void handleLimpar(ActionEvent event) {
		cbMesRef.setValue(null);
		tfDescricao.setText("");
		tfSaldoAtual.setText("");
		dpDataSaida.setValue(null);

		// limpando as informacoes da tarefa
		gastos = null;
		// setando o focus no Titulo
		cbMesRef.requestFocus();
		atualizarBotoes();

	}

	@FXML
	void handleListar(ActionEvent event) {
		GastosRepository repository = new GastosRepository(JPAFactory.getEntityManager());
		List<Gastos> lista = repository.getGastos(tfDescricao.getText());

		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação:");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados!");
			alerta.show();
		}

		tvSaidas.setItems(FXCollections.observableList(lista));
		atualizarBotoes();
	}

	@FXML
	void handleSalvar(ActionEvent event) {
		getGastos().setSaldoAtual(tfSaldoAtual.getText());

		getGastos().setMeses(cbMesRef.getValue());
		getGastos().setDescricao(tfDescricao.getText());

		getGastos().setDataSaida(dpDataSaida.getValue());
		
		getGastos().setPessoa(super.getPessoa());

		tvSaidas.getItems().add(gastos);
		super.save(getGastos());

		atualizarValor();
		
	}

	@FXML
	void handleOnClicked(MouseEvent event) {
		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
			if (event.getClickCount() == 2) {

				gastos = tvSaidas.getSelectionModel().getSelectedItem();

				cbMesRef.setValue(getGastos().getMeses());
				dpDataSaida.setValue(getGastos().getDataSaida());
				tfDescricao.setText(getGastos().getDescricao());
				tfSaldoAtual.setText(getGastos().getSaldoAtual());

			
				cbMesRef.requestFocus();
				
				atualizarValor();
				atualizarBotoes();
			}
		}
	}

	private void atualizarValor() {
		lbValor.setText("Valor Atual R$ :" + tfSaldoAtual.getText());

	}

	private void atualizarBotoes() {
		btSalvar.setDisable(getGastos().getId() != null);
		btAtualizar.setDisable(getGastos().getId() == null);
		btExcluir.setDisable(getGastos().getId() == null);

	}

	public Gastos getGastos() {
		if (gastos == null)
			gastos = new Gastos();
		return gastos;
	}

	public void setGastos(Gastos gastos) {
		this.gastos = gastos;
	}

}
