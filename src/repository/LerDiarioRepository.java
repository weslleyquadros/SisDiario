package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cidade;
import model.Diario;
import model.Pessoa;

public class LerDiarioRepository extends Repository<Diario> {
	
	
	public LerDiarioRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Diario> getDiario(String titulo) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT d FROM Diario d WHERE lower(d.titulo) like lower(:titulo) Order by d.titulo ");
		query.setParameter("titulo", "%" + titulo + "%");
		
		
		List<Diario> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Diario>();
		
		return lista;
	}

}
