package co.com.jcfd.pruebaRestFull.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayloadDataDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -4150301605772248737L;
	
	private String uid;
	private String name;
	private String role;
	private String country;
}
