package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import model.Financeiro;
import model.Meses;
import model.SaidasFinanceiro;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FinanceiroController extends Controller<Financeiro> implements Initializable {

	private Financeiro financeiro;

	@FXML
	private TextField tfSaldoAtual;

	@FXML
	private ComboBox<Meses> cbMesRef;

	@FXML
	private Label lbValor;

	@FXML
	private Button btCancelar;
	
	  @FXML private TableView<SaidasFinanceiro> tvSaidas;
	  
	  @FXML private TableColumn<SaidasFinanceiro, LocalDate> tcDataSaida;
	  
	  @FXML private TableColumn<SaidasFinanceiro, String> tcDescricao;
	  
	  @FXML private TableColumn<SaidasFinanceiro, String> tcValorDeb;
	
	@FXML
	private Button btAtualizar;

	@FXML
	private Button btLimpar;

	@FXML
	private TextField tfDescricao;

	@FXML
	private TextField tfValorDeb;

	@FXML
	private DatePicker dpDataSaida;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tcValorDeb.setCellValueFactory(new PropertyValueFactory<>("valorDeb"));
		
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
					//setText(item.getId()+"-"+item.getLabel());

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
	void handleAtualizar(ActionEvent event) {
		SaidasFinanceiro saidas = new SaidasFinanceiro();
		saidas.setDataSaida(dpDataSaida.getValue());
		saidas.setDescricao(tfDescricao.getText());
		saidas.setValorDeb(tfValorDeb.getText());

		if (getFinanceiro().getListaSaidas() == null)
			getFinanceiro().setListaSaidas(new ArrayList<SaidasFinanceiro>());

		getFinanceiro().getListaSaidas().add(saidas);

		tvSaidas.setItems(FXCollections.observableList(getFinanceiro().getListaSaidas()));

		tfDescricao.clear();
		tfValorDeb.clear();
		
		tfDescricao.requestFocus();
		
		/*Double valor, valordeb, result;
		
		valor = Double.parseDouble(tfSaldoAtual.getText());
		valordeb = Double.parseDouble(tfValorDeb.getText());
		
		
		result = (valor - valordeb);
		lbValor.setText("Valor Atual R$ :"+result);*/
		
	}

	@FXML
	void handleCancelar(ActionEvent event) {

	}

	@FXML
	void handleLimpar(ActionEvent event) {

	}

	@FXML
	void handleSalvar(ActionEvent event) {
		getFinanceiro().setSaldoAtual(tfSaldoAtual.getText());

		getFinanceiro().setMeses(cbMesRef.getValue());

		super.save(getFinanceiro());

		atualizarValor();
	}

	private void atualizarValor() {
		lbValor.setText("Valor Atual R$ :" + tfSaldoAtual.getText());

	}

	public Financeiro getFinanceiro() {
		if (financeiro == null)
			financeiro = new Financeiro();
		return financeiro;
	}

	public void setFinanceiro(Financeiro financeiro) {
		this.financeiro = financeiro;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
