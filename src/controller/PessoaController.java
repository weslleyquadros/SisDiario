package controller;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import model.Pessoa;
import model.Telefone;


public class PessoaController extends Controller<Pessoa>  {

	private Pessoa pessoa;

	   @FXML
	    private Button btSalvar;

	    @FXML
	    private TextField tfNome;

	    @FXML
	    private TextField tfApelido;

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
	    private DatePicker dpDataNascimento;

		   
	    @FXML
	    void handleSalvar(ActionEvent event) {
	    	getPessoa().setNome(tfNome.getText());
			getPessoa().setApelido(tfApelido.getText());
			getPessoa().setDataAniversaio(dpDataNascimento.getValue());
			getPessoa().setEmail(tfEmail.getText());
			getPessoa().setSenha(tfSenha.getText());

			super.save(getPessoa());
			
			handleCancelar(event);
	    }
	    
	    @FXML
	    void handleCancelar(ActionEvent event) {
	    	//tfCpf.setText("");
			tfNome.setText("");
			tfApelido.setText("");
			dpDataNascimento.setValue(null);
			tfEmail.setText("");
			tfSenha.setText("");
			
			// limpando as informacoes do pessoa
			pessoa = null;
			// setando o focus no cpf
			tfNome.requestFocus();
			
			

			
	    }


	/*
    @FXML
    void handleAdicionarTelefone(ActionEvent event) {
    	Telefone tel = new Telefone();
    	tel.setCodigoArea(tfCodigoArea.getText());
    	tel.setNumero(tfNumero.getText());
    	tel.setPessoa(pessoa);
    	
    	if (getPessoa().getListaTelefone() == null)
    		getPessoa().setListaTelefone(new ArrayList<Telefone>());
    	
    	getPessoa().getListaTelefone().add(tel);
    	
    	// atualizando a interface
    	tbTelefone.setItems(FXCollections.observableList(getPessoa().getListaTelefone()));
    	
    	// limpando os campos
    	tfCodigoArea.clear();
    	tfNumero.clear();
    	tfCodigoArea.requestFocus();

    }*/
	

	/*@FXML
	void handlePesquisar(ActionEvent event) {
		pessoaRepository repository = 
				new pessoaRepository(JPAFactory.getEntityManager());
		List<Pessoa> lista = repository.getPessoas(tfPesquisar.getText());
		
		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados.");
			alerta.show();
		}
		tvpessoas.setItems(FXCollections.observableList(lista));
	}*/

	/*@FXML
	void handleMouseClicked(MouseEvent event) {
		// verificando se eh o botao principal
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// verificando a quantidade de cliques
			if (event.getClickCount() == 2) {
				pessoa = tvpessoas.getSelectionModel().getSelectedItem();
				tfCpf.setText(getPessoa().getCpf());
				tfNome.setText(getPessoa().getNome());
				tfEndereco.setText(getPessoa().getEndereco());
				tfEmail.setText(getPessoa().getEmail());
				dpAniversario.setValue(getPessoa().getDataAniversaio());
				
				// preenchendo os telefone
				tbTelefone.setItems(FXCollections.observableList(getPessoa().getListaTelefone()));

				// selecionando a primeira aba
				tpAbas.getSelectionModel().select(0);

				// setando o focus no cpf
				tfCpf.requestFocus();
				atualizarBotoes();
			}
		}

	}*/

	

/*	@FXML
	void handleAlterar(ActionEvent event) {
		getPessoa().setCpf(tfCpf.getText());
		getPessoa().setNome(tfNome.getText());
		getPessoa().setEndereco(tfEndereco.getText());
		getPessoa().setEmail(tfEmail.getText());
		getPessoa().setDataAniversaio(dpAniversario.getValue());

		save(getPessoa());
		
		handleLimpar(event);
	}
*/
	/*@FXML
	void handleExcluir(ActionEvent event) {
		super.remove(getPessoa());
		handleLimpar(event);
	}*/



	private void atualizarBotoes() {
		btSalvar.setDisable(getPessoa().getId() != null);
		
	}

	public Pessoa getPessoa() {
		if (pessoa == null)
			pessoa = new Pessoa();
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
