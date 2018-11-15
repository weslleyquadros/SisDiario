package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tarefa extends DefaultEntity<Tarefa> {

	private static final long serialVersionUID = 6006904402824207787L;

	private String tituloTarefa;
	private String descricaoTarefa;
	private String statusTarefa;

	@ManyToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	@Column(columnDefinition = "Date")
	private LocalDate dataTarefa;

	public Tarefa() {

	}

	public Tarefa(String tituloTarefa, String descricaoTarefa, LocalDate dataTarefa, String statusTarefa) {
		super();
		this.tituloTarefa = tituloTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataTarefa = dataTarefa;
		this.statusTarefa = statusTarefa;

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTituloTarefa() {
		return tituloTarefa;
	}

	public void setTituloTarefa(String tituloTarefa) {
		this.tituloTarefa = tituloTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public LocalDate getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(LocalDate dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

}
