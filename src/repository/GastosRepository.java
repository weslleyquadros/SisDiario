package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Gastos;
import model.Tarefa;

public class GastosRepository extends Repository<Gastos> {
	
	
	public GastosRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Gastos> getGastos(String descricao) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT g FROM Gastos g WHERE lower(g.descricao) like lower(:descricao) ");
		query.setParameter("descricao", "%" + descricao + "%");
		
		List<Gastos> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Gastos>();
		
		return lista;
	}

}
