package co.com.jcfd.pruebaRestFull.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTO")
@Getter
@Setter
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = false)
	@Column(name = "NOMBRE", nullable = false)
	private String nombreProducto;

	@Basic(optional = false)
	@Column(name = "VALOR", nullable = false)
	private Long valorUnidad;

	@Basic(optional = false)
	@Column(name = "CANTIDAD", nullable = false)
	private Long cantidad;

}
