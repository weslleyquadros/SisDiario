package controller;

import java.net.URL;
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

public class DiarioController extends Controller<Diario> implements Initializable {

	@FXML
    private AnchorPane apDiario;
	
	private Diario diario;

	@FXML
	private TextField tfTitulo;

	@FXML
	private ComboBox<String> dpTipo;

	ObservableList<String> list = FXCollections.observableArrayList("Afirmação", "Pensamentos", "Sentimento", "Segredo",
			"Relato");

	@FXML
	private TextArea taAnotacoes;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	@FXML
	private DatePicker dtDataCadastro;

	@FXML
	void handleCancelar(ActionEvent event) {
		tfTitulo.setText("");
		dtDataCadastro.setValue(null);
		dpTipo.setValue(null);
		taAnotacoes.setText("");

		// LIMPANDO AS INFORMAÃ‡Ã•ES DO CLIENTE
		diario = null;

		/*
		 * // LIMPAR AS TABELAS tvClientes.getItems().clear();
		 * tbTelefone.getItems().clear();
		 */

		tfTitulo.requestFocus();

	}

	@FXML
	void handleSalvar(ActionEvent event) {

		getDiario().setTitulo(tfTitulo.getText());

		getDiario().setDataCadastro(dtDataCadastro.getValue());
		getDiario().setAnotacoes(taAnotacoes.getText());

		getDiario().setTipo(dpTipo.getValue());
		getDiario().setPessoa(super.getPessoa());

		super.save(getDiario());

		handleCancelar(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// setando o focus no text field cpf
		super.ajustarPane(apDiario);
		tfTitulo.requestFocus();

		dpTipo.setItems(list);

		/*
		 * // configurando as colunas das tabelas conforme os atributos da classe
		 * Telefone tcCodigoArea.setCellValueFactory(new
		 * PropertyValueFactory<>("codigoArea")); tcNumero.setCellValueFactory(new
		 * PropertyValueFactory<>("numero"));
		 */

		// atualizando os botoes

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
