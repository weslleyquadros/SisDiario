package controller;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import application.Util;
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
		getPessoa().setSenha(Util.encrypt(tfSenha.getText()));
		getPessoa().setSexo(cbSexo.getValue());
//		super.save(getPessoa());
//
//		handleCancelar(event);
		
		if (super.save(getPessoa()) != null) {
			handleCancelar(event);	
		}
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

	@Override
	public boolean validate() {
		
		//validação nome 
		if (getPessoa().getNome() == null || getPessoa().getNome().trim().equals("")) {
			Util.errorAlert("O nome da cidade deve ser informado.").show();
    		tfNome.requestFocus();
    		tfNome.selectAll();
    		return false;
		}
		
		//validação cpf 
				if (getPessoa().getCpf() == null || getPessoa().getCpf().trim().equals("")) {
					Util.errorAlert("O campo CPF deve ser informado.").show();
		    		tfCpf.requestFocus();
		    		tfCpf.selectAll();
		    		return false;
				}
				
				//validação e-mail 
				if (getPessoa().getEmail() == null || getPessoa().getEmail().trim().equals("")) {
					Util.errorAlert("O campo e-mail deve ser informado.").show();
		    		tfEmail.requestFocus();
		    		tfEmail.selectAll();
		    		return false;
				}
				
				//validação Data de Nascimento 
				if (getPessoa().getDataAniversaio() == null) {
					Util.errorAlert("A daa de nascimento deve ser Informada").show();
		    		notify();
		    		
		    		return false;
				}
		
		return true;
	}

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
