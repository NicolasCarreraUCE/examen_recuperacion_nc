package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.model.Bodega;

@Repository
@Transactional
public class BodegaRepoImpl implements IBodegaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Bodega.class, id);
	}

	@Override
	public List<Bodega> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> myQuery = this.entityManager.createQuery("SELECT e FROM Bodega e", Bodega.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bodega);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> myQuery = this.entityManager.createQuery("SELECT e FROM Bodega e WHERE e.numero =:numero", Bodega.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
