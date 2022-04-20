package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.EmprunteLink;
@Stateless
public class EmprunteQueryImpl implements  EmprunteQuery{
    @PersistenceContext
	EntityManager em;
	@Override
	public EmprunteLink addEmprunte(EmprunteLink emprunte) {
		em.persist(emprunte);
		return emprunte;

		// TODO Auto-generated method stub
	}

	@Override
	public EmprunteLink getEmprunte(Long id) {
		   EmprunteLink  emprunte= em.find(EmprunteLink.class, id);
	        if(emprunte==null) throw new RuntimeException("l'affectation n'existe pas");
			return emprunte;

	}

	@Override
	public List<EmprunteLink> getAllEmpruntes() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("select em from emprunte em");
		return query.getResultList();
	}



	

}
