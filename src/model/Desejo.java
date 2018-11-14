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
public class Desejo extends DefaultEntity<Desejo> {


	private static final long serialVersionUID = 4042343814226240056L;
	private String descricao;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;

	//@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente")
	//private List<Telefone> listaTelefone;
	
	/*@Column(columnDefinition="Date")
	private LocalDate dataAniversaio;
*/	
/*	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa")
	private List<Telefone> listaTelefone;*/
	
	public Desejo() {
		
	}

	public Desejo(String descricao) {
		super();
		this.descricao = descricao;
		
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	
}
