package co.com.jcfd.pruebaRestFull.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jcfd.pruebaRestFull.dto.ProductoDto;
import co.com.jcfd.pruebaRestFull.model.Producto;
import co.com.jcfd.pruebaRestFull.repository.ProductoRepository;
import co.com.jcfd.pruebaRestFull.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Método que retorna la lista de todos los productos
	 * 
	 * @return lista con los productos almacenados en BD
	 */
	@Override
	public List<ProductoDto> getAll() {
		return productoRepository.findAll().stream().map(ProductoDto.CONVERT_DTO).collect(Collectors.toList());
	}

	/**
	 * Método encargado de consultar un producto por su ID
	 * 
	 * @param id identificador del producto
	 * @return el producto asociado al ID
	 */
	@Override
	public ProductoDto findById(long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		if (producto.isPresent()) {
			return modelMapper.map(producto, ProductoDto.class);
		} else {
			return null;
		}
	}

	/**
	 * Método encargado de actualizar un producto
	 * 
	 * @param productoDto producto a actualizar
	 * @return productoDto actualizado
	 */
	@Override
	public ProductoDto update(long id, ProductoDto productoDto) {
		Producto producto = productoRepository.save(modelMapper.map(productoDto, Producto.class));
		producto.setId(id);
		return modelMapper.map(producto, ProductoDto.class);
	}

	/**
	 * Método encargado de registrar un producto
	 * 
	 * @param productoDto producto a registrar
	 * @return productoDto registrado
	 */
	@Override
	public ProductoDto create(ProductoDto productoDto) {
		Producto producto = productoRepository.save(modelMapper.map(productoDto, Producto.class));
		return modelMapper.map(producto, ProductoDto.class);
	}

	/**
	 * Método encargado de eliminar un producto
	 * 
	 * @param id identificador del producto a eliminar
	 * @return true si el registro se elimina con éxito.
	 */
	@Override
	public boolean delete(long id) {
		Optional<Producto> producto = productoRepository.findById(id);
		
		if (producto.isPresent()) {
			productoRepository.delete(producto.get());
			return true;
		} else {
			return false;
		}
	}

}
