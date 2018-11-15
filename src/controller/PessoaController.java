package controller;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pessoa;
import model.Sexo;

public class PessoaController extends Controller<Pessoa> implements Initializable{

	private static Pessoa pessoa;

	@FXML
	private Button btSalvar;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfCpf;

	@FXML
	private TextField tfEmail;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btCancelar;

	@FXML
	private TextField tfConfEmail;

	@FXML
	private TextField tfConfSenha;
	@FXML
	private ComboBox<Sexo> cbSexo;

	@FXML
	private DatePicker dpDataNascimento;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// SETANDO O FOCUS NO TEXT FIELD NOME
		tfNome.requestFocus();

		cbSexo.getItems().addAll(Sexo.values());
		//setando uma fabrica no combobox. sera criada com cada item.
		cbSexo.setCellFactory(c -> new ListCell<Sexo>(){
			
			@Override
			protected void updateItem(Sexo item, boolean empty) {
				// TODO Auto-generated method stub
				super.updateItem(item, empty);
				
				if(item == null || empty)
					setText(null);
				
				else
					//setText(item.getId()+"-"+item.getLabel());
					
					setText(item.getLabel());
			}
		});
		
		cbSexo.setButtonCell(new ListCell<Sexo>(){
			
			@Override
			protected void updateItem(Sexo item, boolean empty) {
				// TODO Auto-generated method stub
				super.updateItem(item, empty);
				
				if(item == null || empty)
					setText(null);
				
				else
					setText(item.getLabel());
			}
		});
		

	}

	@FXML
	void handleSalvar(ActionEvent event) {
		getPessoa().setNome(tfNome.getText());
		getPessoa().setCpf(tfCpf.getText());
		getPessoa().setDataAniversaio(dpDataNascimento.getValue());
		getPessoa().setEmail(tfEmail.getText());
		getPessoa().setSenha(tfSenha.getText());
		getPessoa().setSexo(cbSexo.getValue());
		super.save(getPessoa());

		handleCancelar(event);
	}

	@FXML
	void handleCancelar(ActionEvent event) {
		// tfCpf.setText("");
		tfNome.setText("");
		tfCpf.setText("");
		dpDataNascimento.setValue(null);
		tfEmail.setText("");
		tfSenha.setText("");
		cbSexo.setValue(null);

		// limpando as informacoes do pessoa
		pessoa = null;
		// setando o focus no cpf
		tfNome.requestFocus();

	}

	/*
	 * @FXML void handleAdicionarTelefone(ActionEvent event) { Telefone tel = new
	 * Telefone(); tel.setCodigoArea(tfCodigoArea.getText());
	 * tel.setNumero(tfNumero.getText()); tel.setPessoa(pessoa);
	 * 
	 * if (getPessoa().getListaTelefone() == null) getPessoa().setListaTelefone(new
	 * ArrayList<Telefone>());
	 * 
	 * getPessoa().getListaTelefone().add(tel);
	 * 
	 * // atualizando a interface
	 * tbTelefone.setItems(FXCollections.observableList(getPessoa().getListaTelefone
	 * ()));
	 * 
	 * // limpando os campos tfCodigoArea.clear(); tfNumero.clear();
	 * tfCodigoArea.requestFocus();
	 * 
	 * }
	 */

	/*
	 * @FXML void handlePesquisar(ActionEvent event) { pessoaRepository repository =
	 * new pessoaRepository(JPAFactory.getEntityManager()); List<Pessoa> lista =
	 * repository.getPessoas(tfPesquisar.getText());
	 * 
	 * if (lista.isEmpty()) { Alert alerta = new Alert(AlertType.INFORMATION);
	 * alerta.setTitle("Informação"); alerta.setHeaderText(null);
	 * alerta.setContentText("A consulta não retornou dados."); alerta.show(); }
	 * tvpessoas.setItems(FXCollections.observableList(lista)); }
	 */

	/*
	 * @FXML void handleMouseClicked(MouseEvent event) { // verificando se eh o
	 * botao principal if (event.getButton().equals(MouseButton.PRIMARY)) { //
	 * verificando a quantidade de cliques if (event.getClickCount() == 2) { pessoa
	 * = tvpessoas.getSelectionModel().getSelectedItem();
	 * tfCpf.setText(getPessoa().getCpf()); tfNome.setText(getPessoa().getNome());
	 * tfEndereco.setText(getPessoa().getEndereco());
	 * tfEmail.setText(getPessoa().getEmail());
	 * dpAniversario.setValue(getPessoa().getDataAniversaio());
	 * 
	 * // preenchendo os telefone
	 * tbTelefone.setItems(FXCollections.observableList(getPessoa().getListaTelefone
	 * ()));
	 * 
	 * // selecionando a primeira aba tpAbas.getSelectionModel().select(0);
	 * 
	 * // setando o focus no cpf tfCpf.requestFocus(); atualizarBotoes(); } }
	 * 
	 * }
	 */

	/*
	 * @FXML void handleAlterar(ActionEvent event) {
	 * getPessoa().setCpf(tfCpf.getText()); getPessoa().setNome(tfNome.getText());
	 * getPessoa().setEndereco(tfEndereco.getText());
	 * getPessoa().setEmail(tfEmail.getText());
	 * getPessoa().setDataAniversaio(dpAniversario.getValue());
	 * 
	 * save(getPessoa());
	 * 
	 * handleLimpar(event); }
	 */
	/*
	 * @FXML void handleExcluir(ActionEvent event) { super.remove(getPessoa());
	 * handleLimpar(event); }
	 */

	private void atualizarBotoes() {
		btSalvar.setDisable(getPessoa().getId() != null);

	}

	public static Pessoa getPessoa() {
		if (pessoa == null)
			pessoa = new Pessoa();
		return pessoa;
	}

	public static void setPessoa(Pessoa pessoa) {
		pessoa = pessoa;
	}

}
