package ec.edu.uce.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.model.Bodega;
import ec.edu.uce.repository.IBodegaRepo;

@Service
public class BodegaServiImpl implements IBodegaServi {

	private static final Logger LOG = Logger.getLogger(BodegaServiImpl.class);

	@Autowired
	private IBodegaRepo bodegaRepo;
	
	@Override
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido a la base de datos");
		return this.bodegaRepo.buscar(id);
	}

	@Override
	public List<Bodega> buscarTodos() {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido masivo a la base de datos");
		return this.bodegaRepo.buscarTodos();
	}

	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepo.insertar(bodega);
		LOG.info("INFO: El objeto Bodega se a insertado en la base de datos");
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepo.actualizar(bodega);
		LOG.info("INFO: El objeto Bodega se a actualizado");
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.bodegaRepo.eliminar(id);
		LOG.warn("WARNING: Se a eliminado un objeto Bodega de la base de datos");
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bodegaRepo.buscarPorNumero(numero);
	}

	
}
