package controller;

import java.io.IOException;

import factory.CidadeListControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listcontroller.CidadeListController;
import model.Cidade;

public class CidadeController extends Controller<Cidade> {

	private Cidade cidade;

	@FXML
	private Label lbNome;

	@FXML
	private TextField tfNome;

	@FXML
	private Label lbEsdado;

	@FXML
	private TextField tfEsdado;

	@FXML
	private Label lbPais;

	@FXML
	private TextField tfPais;

	@FXML
	private Button btLimpar;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btAlterar;

	@FXML
	private Button btIncluir;

	@FXML
	void hadleIncluir(ActionEvent event) {

		getCidade().setNome(tfNome.getText());
		getCidade().setEstado(tfEsdado.getText());
		getCidade().setPais(tfPais.getText());

		super.save(getCidade());

		handleLimpar(event);
		atualizarBotoes();
	}

	@FXML
	void handleAlterar(ActionEvent event) {

		getCidade().setNome(tfNome.getText());
		getCidade().setEstado(tfEsdado.getText());
		getCidade().setPais(tfPais.getText());

		super.save(getCidade());

		handleLimpar(event);
		atualizarBotoes();
	}

	@FXML
	void handleExcluir(ActionEvent event) {

		super.remove(getCidade());
		handleLimpar(event);
		atualizarBotoes();
	}

	@FXML
	void handleLimpar(ActionEvent event) {

		tfNome.setText("");
		tfEsdado.setText("");
		tfPais.setText("");
		// limpando as informacoes do cliente
		cidade = null;
		atualizarBotoes();
	}

	public Cidade getCidade() {
		if (cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@FXML
	//comunicação entre as classses
	void handleMouseClickedNome(MouseEvent event) throws IOException {
		
		CidadeListController listagem = CidadeListControllerFactory.getIntance();
		
		listagem.abrir();
		// setando a cidade
		setCidade(listagem.getCidadeSelecionada());
		
	
		
		// setando a cidade
		setCidade(listagem.getCidadeSelecionada());
		// atualizando a interface
		tfNome.setText(getCidade().getNome());
		tfEsdado.setText(getCidade().getEstado());
		tfPais.setText(getCidade().getPais());
		
		atualizarBotoes();
	}
	private void atualizarBotoes() {
		btIncluir.setDisable(getCidade().getId() != null);
		btAlterar.setDisable(getCidade().getId() == null);
		btExcluir.setDisable(getCidade().getId() == null);
	}

}
