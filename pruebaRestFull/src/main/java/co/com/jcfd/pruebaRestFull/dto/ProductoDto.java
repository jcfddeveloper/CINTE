package co.com.jcfd.pruebaRestFull.dto;

import java.io.Serializable;
import java.util.function.Function;

import co.com.jcfd.pruebaRestFull.model.Producto;
import lombok.Data;

@Data
public class ProductoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4891662528938592469L;

	public static final Function<Producto, ProductoDto> CONVERT_DTO = (Producto p) -> {
		ProductoDto productoDto = new ProductoDto();
		productoDto.setId(p.getId());
		productoDto.setNombreProducto(p.getNombreProducto());
		productoDto.setValorUnidad(p.getValorUnidad());
		productoDto.setCantidad(p.getCantidad());

		return productoDto;
	};

	private Long id;
	private String nombreProducto;
	private Long valorUnidad;
	private Long cantidad;

}
