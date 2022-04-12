package ec.edu.uce.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import ec.edu.uce.model.Producto;

public interface IProductoServi {
	Producto buscar(Integer id);
	List<Producto> buscarTodos();
	void insertar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id); 
	
	CompletableFuture<Producto> buscarPorCodigoBarras(String codigoBarrasMaestro);
}
