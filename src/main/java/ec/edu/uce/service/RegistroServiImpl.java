package ec.edu.uce.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ec.edu.uce.model.Registro;
import ec.edu.uce.repository.IRegistroRepo;

@Service
public class RegistroServiImpl implements IRegistroServi {

	private static final Logger LOG = Logger.getLogger(RegistroServiImpl.class);

	@Autowired
	private IRegistroRepo registroRepo;
	
	@Override
	public Registro buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido a la base de datos");
		return this.registroRepo.buscar(id);
	}

	@Override
	public List<Registro> buscarTodos() {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido masivo a la base de datos");
		return this.registroRepo.buscarTodos();
	}

	@Override
	@Async
	public void insertar(Registro registro) {
		// TODO Auto-generated method stub
		this.registroRepo.insertar(registro);
		LOG.info("INFO: El objeto Registro se a insertado en la base de datos");
	}

	@Override
	public void actualizar(Registro registro) {
		// TODO Auto-generated method stub
		this.registroRepo.actualizar(registro);
		LOG.info("INFO: El objeto Registro se a actualizado");
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.registroRepo.eliminar(id);
		LOG.warn("WARNING: Se a eliminado un objeto Registro de la base de datos");
	}

	
}
