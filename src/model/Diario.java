package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Diario extends DefaultEntity<Diario> {

	private static final long serialVersionUID = 3405600671080606088L;

	private String titulo;
	private String anotacoes;
	private String tipo;
	@Column(columnDefinition = "Date")
	private LocalDate dataCadastro;

	/*@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;*/
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Diario() {

	}

	public Diario(String titulo, LocalDate dataCadastro, String tipo, String anotacoes) {
		super();

		this.titulo = titulo;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
		this.anotacoes = anotacoes;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
