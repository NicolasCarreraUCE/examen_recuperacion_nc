package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.model.Bodega;

public interface IBodegaRepo {
	Bodega buscar(Integer id);
	List<Bodega> buscarTodos();
	void insertar(Bodega bodega);
	void actualizar(Bodega bodega);
	void eliminar(Integer id);
}