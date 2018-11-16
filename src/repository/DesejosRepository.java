package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Desejo;
import model.Pessoa;

public class DesejosRepository extends Repository<Desejo> {
	
	
	public DesejosRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Desejo> getDesejo(Pessoa pessoa) {
		
		Query query = getEntityManager().createQuery("SELECT d FROM Desejo d WHERE d.pessoa=:pessoa");
		query.setParameter("pessoa", pessoa);
		/*
		Query query = 
				getEntityManager().
					createQuery("SELECT d FROM Desejo d WHERE lower(d.descricao) like lower(:descricao) ");
		query.setParameter("descricao", "%" + descricao + "%");*/
		
		List<Desejo> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Desejo>();
		
		return lista;
	}

}
