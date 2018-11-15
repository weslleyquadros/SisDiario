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
public class Gastos extends DefaultEntity<Gastos> {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1302667513849196315L;
	private String saldoAtual;
	private String descricao;

	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;

	
	private Meses meses;


	@Column(columnDefinition = "Date")
	private LocalDate dataSaida;

	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Gastos() {

	}



	public Gastos(String saldoAtual) {
		super();
		this.saldoAtual = saldoAtual;

	}

	public Meses getMeses() {
		return meses;
	}

	public void setMeses(Meses meses) {
		this.meses = meses;
	}

	public String getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(String saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

}
