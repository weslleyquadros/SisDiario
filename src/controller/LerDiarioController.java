package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Anotacoes;

import model.Diario;

import repository.DiarioRepository;
import repository.LerDiarioRepository;

public class LerDiarioController extends Controller<Diario> implements Initializable {

	@FXML
    private AnchorPane apLerDiario;
	
	private Diario diario;

	@FXML
	private TabPane tpAbas;

	@FXML
	private TableView<Diario> tvListDiarios;

	@FXML
	private TableColumn<Diario, Integer> tcIdDiario;

	@FXML
	private TableColumn<Diario, String> tcTitulo;

	@FXML
	private TableColumn<Diario, String> tcTipo;

	@FXML
	private TableColumn<Diario, LocalDate> tcData;

	@FXML
	private TableColumn<Diario, String> tcRelato;

	@FXML
	private DatePicker dpData;

	@FXML
	private TextField tfTitulo;
	@FXML
	private TextField tfTituloPesquisar;

	@FXML
	private ComboBox<String> dpTipo;

	@FXML
	private TextArea taAnotacoes;

	@FXML
	private DatePicker dtDataCadastro;

	@FXML
	void handleOnMouseClicked(MouseEvent event) {
		// VERIFICANDO SE Ã‰ O BOTÃƒO PRINCIPAL QUE FOI CLIADO
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// VERIFICANDO SE A QUANTIDADE DE CLIQUES NO BOTÃƒO PRIMÃ�RIO Ã‰ IGUAL A 2
			if (event.getClickCount() == 2) {

				diario = tvListDiarios.getSelectionModel().getSelectedItem();

				tfTitulo.setText(getDiario().getTitulo());
				taAnotacoes.setText(getDiario().getAnotacoes());
				dpTipo.setValue(getDiario().getTipo());
				dtDataCadastro.setValue(getDiario().getDataCadastro());

				// SELECIONANDO A PRIMEIRA ABA
				tpAbas.getSelectionModel().select(1);

			}
		}
	}

	@FXML
	void handlePesquisar(ActionEvent event) {
		DiarioRepository repository = new DiarioRepository(JPAFactory.getEntityManager());
		List<Diario> lista = repository.getDiario(tfTituloPesquisar.getText());

		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação:");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados!");
			alerta.show();
		}

		tvListDiarios.setItems(FXCollections.observableList(lista));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// setando o focus no text field cpf
		// CONFIGURANDO AS COLUNAS DAS TABELAS CONFORME OS ATRIBUTOS DA CLASSE CLIENTE
		tcIdDiario.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		tcData.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
		tcRelato.setCellValueFactory(new PropertyValueFactory<>("anotacoes"));
		tcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

	}

	public Diario getDiario() {
		if (diario == null)
			diario = new Diario();
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

}
