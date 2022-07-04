package co.com.jcfd.pruebaRestFull.util;

public enum StatusResponse {
	
	SUCCESS(0, "Success"),
	ERROR_CONSULTA(1, "No se encontro el Producto con ID %s."),
	ERROR_UPDATE(2, "No se pudo actualizar el Producto con ID %s."),
	ERROR_CREATE(3, "No se pudo registrar el nuevo producto.");

	private final int value;
	private final String mensaje;
	
	StatusResponse(int value, String mensaje){
		this.value = value;
		this.mensaje = mensaje;
	}
	
	public int value() {
		return this.value;
	}
	
	public String mensaje() {
		return this.mensaje;
	}
}
