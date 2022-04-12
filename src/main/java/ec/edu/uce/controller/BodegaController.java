package ec.edu.uce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.edu.uce.model.Bodega;
import ec.edu.uce.model.Producto;
import ec.edu.uce.service.IBodegaServi;
import ec.edu.uce.service.IProductoServi;

@Controller
public class BodegaController {

	@Autowired
	private IProductoServi productoServi;
	
	@Autowired
	private IBodegaServi bodegaServi;
	
	@GetMapping("/crear/bodega")
	private String crearBodega(Model model) {
		model.addAttribute("bodega", new Bodega());
		return "crear_bodega";
	}
	
	@PostMapping("/crear/bodega/guardar")
	private String guardarBodega(Bodega bodega, @RequestParam(value = "telefonos") String telefonos, Model model) {
		String[] arrayTelefonos = telefonos.split(";");
		List<String> listaTelefonos = new ArrayList<String>();
		for(String tel : arrayTelefonos) {
			listaTelefonos.add(tel);
		}
		bodega.setTelefonos(listaTelefonos);
		this.bodegaServi.insertar(bodega);
		return "redirect:/crear/bodega";
	}
	
	@GetMapping("/crear/productos")
	private String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "crear_producto";
	}
	
	@PostMapping("/crear/productos/guardar")
	private String guardarProducto(Producto producto, Model model) {
		producto.setStock(0);
		this.productoServi.insertar(producto);
		return "redirect:/listar/productos";
	}
	
	private String ingresarInventario(@RequestParam(value = "numero_bodega") String numeroBodega, @RequestParam(value = "codigo_barras_maestro") String codigoBarrasMaestro, @RequestParam(value = "cantidad") String cantidad, Model model) {
		Bodega bodega = this.bodegaServi.buscarPorNumero(numeroBodega);
		Producto producto = this.productoServi.buscarPorCodigoBarras(codigoBarrasMaestro);
		producto.setStock(producto.getStock() + Integer.parseInt(cantidad));
		this.productoServi.actualizar(producto);
		
		return "ingresar_inventario"; 
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
