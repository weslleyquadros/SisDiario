package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicialController  {

	
	
	@FXML
	void handleAbrirEscreverDiario(ActionEvent event) throws IOException {

		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/diario.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Escrever Diario");
		stage.show();
	}
	
	@FXML
	void handleAbrirLerDiario(ActionEvent event) throws IOException {

		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/lerDiario.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Ler Diario");
		stage.show();
	}
	
	@FXML
	void handleAbrirDesejos(ActionEvent event) throws IOException {
		
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/desejo.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);

		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Escrever Desejos");
		stage.show();
	}
	
	  @FXML
	    void handleAbrirFinanceiro(ActionEvent event) throws IOException {
		  FXMLLoader fXMLLoader = new FXMLLoader();
			fXMLLoader.setLocation(getClass().getResource("/view/controleFinanceiro.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(fXMLLoader.load());
			stage.setScene(scene);

			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Controle de Gastos");
			stage.show();

	    }

	    @FXML
	    void handleAbrirTarefas(ActionEvent event) throws IOException {
	    	FXMLLoader fXMLLoader = new FXMLLoader();
			fXMLLoader.setLocation(getClass().getResource("/view/tarefa.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(fXMLLoader.load());
			stage.setScene(scene);

			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Realizar Tarefas");
			stage.show();

	    }

}
