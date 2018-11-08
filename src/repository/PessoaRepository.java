package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Pessoa;

public class PessoaRepository extends Repository<Pessoa> {
	
	
	public PessoaRepository(EntityManager entityManager) {
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

}
