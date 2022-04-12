package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.model.Registro;

public interface IRegistroRepo {
	Registro buscar(Integer id);
	List<Registro> buscarTodos();
	void insertar(Registro registro);
	void actualizar(Registro registro);
	void eliminar(Integer id);
}