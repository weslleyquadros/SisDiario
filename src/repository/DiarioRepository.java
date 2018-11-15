package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Diario;
import model.Pessoa;

public class DiarioRepository extends Repository<Diario> {

	public DiarioRepository(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Diario> getDiario(String titulo) {

		Query query = getEntityManager()
				.createQuery("SELECT d FROM Diario d WHERE lower(d.titulo) like lower(:titulo) Order by d.titulo ");
				//.createQuery("SELECT d.anotacoes, d.tipo, d.datacadastro, d.titulo FROM Diario d, Pessoa WHERE d.titulo=:titulo and d.idpessoa=Pessoa.id and d.idpessoa=:idpessoa");
		query.setParameter("titulo", "%" + titulo + "%");
		//query.setParameter("idpessoa", "%" + idpessoa + "%");

		List<Diario> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Diario>();

		return lista;
	}

}
