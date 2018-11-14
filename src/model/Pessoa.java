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
public class Pessoa extends DefaultEntity<Pessoa> {

	private static final long serialVersionUID = 5890699267888762069L;
	
	private String cpf;
	private String nome;
	private String senha;
	private String email;


	
	
	@Column(columnDefinition="Date")
	private LocalDate dataAniversaio;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa")
	private List<Desejo> listaDesejo;
	
/*	@OneToMany(cascade=CascadeType.ALL, mappedBy="pessoa")
	private List<Telefone> listaTelefone;*/
	
	private Sexo sexo;
	
	public Pessoa() {
		
	}

	public Pessoa(String cpf, String nome, String senha, String email, LocalDate dataAniversario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.dataAniversaio = dataAniversario;
		
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataAniversaio() {
		return dataAniversaio;
	}

	public void setDataAniversaio(LocalDate dataAniversaio) {
		this.dataAniversaio = dataAniversaio;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	
}
