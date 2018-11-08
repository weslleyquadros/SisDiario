package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Financeiro extends DefaultEntity<Financeiro>{
	


	
	private static final long serialVersionUID = 4458279456762737893L;

	private String saldoAtual;
		
	/*@ManyToOne
	@JoinColumn(name="idCidadeNatal")
	private Financeiro cidadNatal;*/
	
	private Meses meses;

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="financeiro")
	private List<SaidasFinanceiro> listaSaidas;

/*	@Column(columnDefinition="Date")
	private LocalDate dataAniversario;*/

	public Financeiro() {
		
	}
	
	public List<SaidasFinanceiro> getListaSaidas() {
		return listaSaidas;
	}

	public void setListaSaidas(List<SaidasFinanceiro> listaSaidas) {
		this.listaSaidas = listaSaidas;
	}

	public Financeiro(String saldoAtual) {
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
