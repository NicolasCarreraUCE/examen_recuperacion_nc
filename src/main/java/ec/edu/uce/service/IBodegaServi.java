package ec.edu.uce.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import ec.edu.uce.model.Bodega;

public interface IBodegaServi {
	Bodega buscar(Integer id);
	List<Bodega> buscarTodos();
	void insertar(Bodega bodega);
	void actualizar(Bodega bodega);
	void eliminar(Integer id);
	
	CompletableFuture<Bodega> buscarPorNumero(String numero);
}
