package ec.edu.uce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega {
	
	@Id
	@Column(name = "bode_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bodega") 
	@SequenceGenerator(name = "seq_bodega", sequenceName = "seq_bodega", allocationSize = 1)
	private Integer id;
	
	@Column(name = "bode_nombre")
	private String nombre;

	@Column(name = "bode_numero")
	private String numero;

	@Column(name = "bode_direccion")
	private String direccion;
	
	@ElementCollection
	private List<String> telefonos;

	@OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Producto> productos;
	
	// SET-GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
