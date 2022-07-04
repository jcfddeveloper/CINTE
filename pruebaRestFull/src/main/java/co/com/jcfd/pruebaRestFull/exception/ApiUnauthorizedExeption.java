package co.com.jcfd.pruebaRestFull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorizedExeption extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2094902356104860564L;
	
	public ApiUnauthorizedExeption(String message){
		super(message);
	}
	
	

}
