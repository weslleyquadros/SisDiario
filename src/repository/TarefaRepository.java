package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Pessoa;
import model.Tarefa;

public class TarefaRepository extends Repository<Tarefa> {
	
	
	public TarefaRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Tarefa> getTarefa(Pessoa pessoa) {
		
		Query query = getEntityManager().createQuery("SELECT t FROM Tarefa t WHERE t.pessoa=:pessoa");
		query.setParameter("pessoa", pessoa);
		
		
		/*Query query = 
				getEntityManager().
					createQuery("SELECT t FROM Tarefa t WHERE lower(t.tituloTarefa) like lower(:tituloTarefa) ");
		query.setParameter("tituloTarefa", "%" + titulotarefa + "%");*/
		
		List<Tarefa> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Tarefa>();
		
		return lista;
	}

}
