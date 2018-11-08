package model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Anotacoes extends DefaultEntity<Anotacoes>{

	
	private static final long serialVersionUID = 5231972713611725009L;
	
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="idDiario")
	private Diario diario;



	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
