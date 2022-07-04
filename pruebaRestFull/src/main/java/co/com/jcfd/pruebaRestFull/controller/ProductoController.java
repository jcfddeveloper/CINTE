package co.com.jcfd.pruebaRestFull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jcfd.pruebaRestFull.dto.ProductoDto;
import co.com.jcfd.pruebaRestFull.dto.ResponseDto;
import co.com.jcfd.pruebaRestFull.service.ProductoService;
import co.com.jcfd.pruebaRestFull.util.StatusResponse;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping()
	public ResponseEntity<ResponseDto> findAll() {
		ResponseDto respuesta = new ResponseDto();
		respuesta.setStatusCode(StatusResponse.SUCCESS.value());
		respuesta.setMessage(StatusResponse.SUCCESS.mensaje());
		respuesta.setData(productoService.getAll());
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> findById(@PathVariable long id) {
		ResponseDto respuesta = new ResponseDto();
		respuesta.setStatusCode(StatusResponse.SUCCESS.value());
		respuesta.setMessage(StatusResponse.SUCCESS.mensaje());
		respuesta.setData(productoService.findById(id));
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping()
	public ResponseEntity<ResponseDto> create(@RequestBody ProductoDto productoDto) {
		ResponseDto respuesta = new ResponseDto();
		respuesta.setStatusCode(StatusResponse.SUCCESS.value());
		respuesta.setMessage(StatusResponse.SUCCESS.mensaje());
		respuesta.setData(productoService.create(productoDto));
		return ResponseEntity.ok(respuesta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDto> update(@PathVariable long id, @RequestBody ProductoDto productoDto){
		
		ResponseDto respuesta = new ResponseDto();
		respuesta.setStatusCode(StatusResponse.SUCCESS.value());
		respuesta.setMessage("El producto se ha actualizado exitosamente.");
		respuesta.setData(productoService.update(id, productoDto));
		
		return ResponseEntity.ok(respuesta);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> delete(@PathVariable long id){
		ResponseDto respuesta = new ResponseDto();
		
		if(productoService.delete(id)) {
			respuesta.setStatusCode(HttpStatus.OK.value());
			respuesta.setMessage(String.format("El producto con id %s se ha eliminado exitosamente.", id));
		} else {
			respuesta.setStatusCode(HttpStatus.NOT_FOUND.value());
			respuesta.setMessage(String.format("El producto con id %s no existe.", id));
		}
		
		return ResponseEntity.ok(respuesta);
	}

}
