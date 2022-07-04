package co.com.jcfd.pruebaRestFull.service;

import java.util.List;

import co.com.jcfd.pruebaRestFull.dto.ProductoDto;

public interface ProductoService {

	/**
	 * Método que retorna la lista de todos los productos
	 * 
	 * @return lista con los productos almacenados en BD
	 */
	public List<ProductoDto> getAll();

	/**
	 * Método encargado de consultar un producto por su ID
	 * 
	 * @param id identificador del producto
	 * @return el producto asociado al ID
	 */
	public ProductoDto findById(long id);

	/**
	 * Método encargado de actualizar un producto
	 * 
	 * @param productoDto producto a actualizar
	 * @return productoDto actualizado
	 */
	public ProductoDto update(long id, ProductoDto productoDto);

	/**
	 * Método encargado de registrar un producto
	 * 
	 * @param productoDto producto a registrar
	 * @return productoDto registrado
	 */
	public ProductoDto create(ProductoDto productoDto);

	/**
	 * Método encargado de eliminar un producto
	 * 
	 * @param id identificador del producto a eliminar
	 */
	public boolean delete(long id);

}
