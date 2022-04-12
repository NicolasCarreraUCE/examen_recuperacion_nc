package ec.edu.uce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.edu.uce.model.Bodega;
import ec.edu.uce.model.Producto;
import ec.edu.uce.model.Registro;
import ec.edu.uce.service.IBodegaServi;
import ec.edu.uce.service.IProductoServi;
import ec.edu.uce.service.IRegistroServi;

@Controller
public class BodegaController {

	@Autowired
	private IProductoServi productoServi;
	
	@Autowired
	private IBodegaServi bodegaServi;
	
	@Autowired
	private IRegistroServi registroServi;
	
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
	
	@GetMapping("/ingresar/inventario")
	private String ingresarInventario(Model model) {
		return "ingresar_inventario";
	}
	
	@PostMapping("/ingresar/inventario/guardar")
	private String guardarInventario(@RequestParam(value = "numero_bodega") String numeroBodega, @RequestParam(value = "codigo_barras_maestro") String codigoBarrasMaestro, @RequestParam(value = "cantidad") String cantidad, Model model) {
		CompletableFuture<Bodega> bodega = this.bodegaServi.buscarPorNumero(numeroBodega);
		CompletableFuture<Producto> producto = this.productoServi.buscarPorCodigoBarras(codigoBarrasMaestro);
		CompletableFuture.allOf(bodega, producto).join();
		
		
		for(int i = 0; i < Integer.parseInt(cantidad); i++) {
			Registro registro = new Registro();
			registro.setCodigoBarrasIndividual(codigoBarrasMaestro + (i + 1));
			try {
				registro.setBodega(bodega.get());
				registro.setProducto(producto.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.registroServi.insertar(registro);
		}
		
		try {
			producto.get().setStock(Integer.parseInt(cantidad));
			this.productoServi.actualizar(producto.get());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ingresar_inventario"; 
	}
	
	@GetMapping("/listar/productos")
	public String registrarseComoCliente1(Model model) {
		model.addAttribute("list", this.productoServi.buscarTodos());
		return "lista_productos";
	}
	
	@GetMapping("/eliminar/producto/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model model) {
		Producto producto = this.productoServi.buscar(id);
		if (producto.getStock() <= 0) {
			this.productoServi.eliminar(id);
			model.addAttribute("titulo", "El producto se elimino adecuadamente");
		} else {
			model.addAttribute("titulo", "No se puede eliminar este producto");
		}
		
		return "redirect:/listar/productos";
	}
	
}
