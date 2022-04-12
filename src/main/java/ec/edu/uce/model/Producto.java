package ec.edu.uce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto") 
	@SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto", allocationSize = 1)
	private Integer id;
 
	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_codigo_de_barras")
	private String codigoDeBarras;

	@Column(name = "prod_categoria")
	private String categoria;

	@Column(name = "prod_stock")
	private Integer stock;
	
	@OneToOne(mappedBy = "producto", cascade=CascadeType.ALL)
	private Registro registro;
	
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

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	
	
}
