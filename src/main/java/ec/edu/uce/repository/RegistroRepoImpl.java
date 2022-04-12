package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.model.Registro;

@Repository
@Transactional
public class RegistroRepoImpl implements IRegistroRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Registro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Registro.class, id);
	}

	@Override
	public List<Registro> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Registro> myQuery = this.entityManager.createQuery("SELECT e FROM Registro e", Registro.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Registro registro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(registro);
	}

	@Override
	public void actualizar(Registro registro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(registro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
