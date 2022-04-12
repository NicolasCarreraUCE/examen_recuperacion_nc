package ec.edu.uce.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Persona;

@Controller
public class ClaseController {

	@RequestMapping("/")
	public String index(Model model) {
		List<Persona> list = Arrays.asList(new Persona(1, "Nicolas", "Carrera"), new Persona(2, "Luis", "Ortiz"));
		model.addAttribute("list", list);
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("estudiante", new Persona(id, "Nicolas", "Carrera"));
		} else {
			model.addAttribute("estudiante", new Persona());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		//this.personaServi.insertar(persona);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable("id") Integer id, Model model) {
		//this.personaServi.eliminar(id);
		return "redirect:/";
	}
	
	@GetMapping("/paguina_confirmacion")
	public String pagiaConfirmacion(Model model) {
		model.addAttribute("titulo", "Mensaje de confirmacion");
		return "pag_comfirmacion";
	}
	
}
