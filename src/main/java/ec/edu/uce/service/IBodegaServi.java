package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.model.Bodega;

public interface IBodegaServi {
	Bodega buscar(Integer id);
	List<Bodega> buscarTodos();
	void insertar(Bodega bodega);
	void actualizar(Bodega bodega);
	void eliminar(Integer id);
	
	Bodega buscarPorNumero(String numero);
}
