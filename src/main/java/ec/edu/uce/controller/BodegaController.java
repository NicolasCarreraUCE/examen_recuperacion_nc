package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ec.edu.uce.model.Bodega;
import ec.edu.uce.model.Producto;
import ec.edu.uce.service.IProductoServi;

@Controller
public class BodegaController {

	@Autowired
	private IProductoServi productoServi;
	
	
	@GetMapping("/crear/bodega")
	private String crearBodega(Model model) {
		model.addAttribute("bodega", new Bodega());
		return "crear_bodega";
	}
	
	@PostMapping("/crear/bodega/guardar")
	private String guardarBodega(Model model) {
		return "crear_bodega";
	}
	
	@GetMapping("/crear/productos")
	private String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "crear_producto";
	}
	
	@PostMapping("/crear/productos/guardar")
	private String guardarProducto(Model model) {
		return "crear_producto";
	}
	
	@GetMapping("/listar/productos")
	public String registrarseComoCliente1(Model model) {
		model.addAttribute("list", this.productoServi.buscarTodos());
		return "lista_productos";
	}
	
	@GetMapping("/eliminar/producto/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model model) {
		this.productoServi.eliminar(id);
		return "redirect:/listar/productos";
	}
	
	
}
