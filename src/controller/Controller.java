package controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import factory.JPAFactory;
import javafx.scene.layout.AnchorPane;
import model.DefaultEntity;
import model.Pessoa;
import repository.Repository;

public class Controller<T extends DefaultEntity<? super T>> {
	private static Pessoa pessoa;
	public T save(T entity) {
		Repository<T> repository = 
				new Repository<T>(JPAFactory.getEntityManager());
		
		// iniciando a transacao
		repository.getEntityManager().getTransaction().begin();
		entity = repository.save(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();
		
		return entity;
	}
	
	public void remove(T entity) {
		Repository<T> repository = 
				new Repository<T>(JPAFactory.getEntityManager());
		
		repository.getEntityManager().getTransaction().begin();
		repository.remove(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();
	}
	
	protected void ajustarPane(AnchorPane pane) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		pane.setPrefHeight(height);
		pane.setPrefWidth(width);
		}

	public static Pessoa getPessoa() {
		return pessoa;
	}

	public static void setPessoa(Pessoa pessoa) {
		Controller.pessoa = pessoa;
	}
}
