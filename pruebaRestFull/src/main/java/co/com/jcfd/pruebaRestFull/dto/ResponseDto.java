package co.com.jcfd.pruebaRestFull.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

	private int statusCode;
	private String message;
	private Object data;
	
}
