package ec.edu.uce.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ec.edu.uce.model.Producto;
import ec.edu.uce.repository.IProductoRepo;

@Service
public class ProductoServiImpl implements IProductoServi {

	private static final Logger LOG = Logger.getLogger(ProductoServiImpl.class);

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido a la base de datos");
		return this.productoRepo.buscar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		LOG.info("INFO: Se a realisado un pedido masivo a la base de datos");
		return this.productoRepo.buscarTodos();
	}

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertar(producto);
		LOG.info("INFO: El objeto Producto se a insertado en la base de datos");
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizar(producto);
		LOG.info("INFO: El objeto Producto se a actualizado");
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.productoRepo.eliminar(id);
		LOG.warn("WARNING: Se a eliminado un objeto Producto de la base de datos");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	@Async
	public CompletableFuture<Producto> buscarPorCodigoBarras(String codigoBarrasMaestro) {
		// TODO Auto-generated method stub
		return CompletableFuture.completedFuture(this.productoRepo.buscarPorCodigoBarras(codigoBarrasMaestro));
	}

	
}
