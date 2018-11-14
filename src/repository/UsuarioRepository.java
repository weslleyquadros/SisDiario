package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Pessoa;

public class UsuarioRepository extends Repository<Pessoa> {
	
	
	public UsuarioRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Pessoa> getPessoa(String nome) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT p FROM Pessoa p WHERE lower(p.nome) like lower(:nome) ");
		query.setParameter("nome", "%" + nome + "%");
		
		List<Pessoa> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Pessoa>();
		
		return lista;
	}

	public List<Pessoa> getPessoaLogin(String cpf, String senha) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT p FROM Pessoa p WHERE p.cpf=:cpf and p.senha=:senha");
		query.setParameter("cpf", cpf );
		query.setParameter("senha", senha);
		
		List<Pessoa> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Pessoa>();
		
		return lista;
	}
	
}
