package ec.edu.uce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro {
	
	@Id
	@Column(name = "regi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro") 
	@SequenceGenerator(name = "seq_registro", sequenceName = "seq_registro", allocationSize = 1)
	private Integer id;
	
	@Column(name = "regi_codigoBarrasIndividual")
	private String codigoBarrasIndividual;

	@Column(name = "regi_nombreHilo")
	private String nombreHilo;

	@ManyToOne
	@JoinColumn(name = "bode_id")
	private Bodega bodega;
	
	@OneToOne
	@JoinColumn(name = "prod_id")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarrasIndividual() {
		return codigoBarrasIndividual;
	}

	public void setCodigoBarrasIndividual(String codigoBarrasIndividual) {
		this.codigoBarrasIndividual = codigoBarrasIndividual;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
