package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.model.Producto;

public interface IProductoRepo {
	Producto buscar(Integer id);
	List<Producto> buscarTodos();
	void insertar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id);
	
	Producto buscarPorCodigoBarras(String codigoBarrasMaestro); 
}