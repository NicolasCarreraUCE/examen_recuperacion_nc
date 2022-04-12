package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.model.Registro;

public interface IRegistroServi {
	Registro buscar(Integer id);
	List<Registro> buscarTodos();
	void insertar(Registro registro);
	void actualizar(Registro registro);
	void eliminar(Integer id);
}
