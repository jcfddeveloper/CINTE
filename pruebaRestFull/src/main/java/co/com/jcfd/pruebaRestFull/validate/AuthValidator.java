package co.com.jcfd.pruebaRestFull.validate;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import co.com.jcfd.pruebaRestFull.exception.ApiUnauthorizedExeption;

@Component
public class AuthValidator {

	private static final String CLIENT_CREDENTIALS = "client_credentials";

	public void validate(MultiValueMap<String, String> paramMap, String grantType) throws ApiUnauthorizedExeption {

		String strMensajeErrorParamMap = "client_id y/o client_secret son invalidos.";
		
		if (grantType.isEmpty() || !grantType.equals(CLIENT_CREDENTIALS)) {
			message("El campo grant_type es invalido");
		}
		
		if (Objects.isNull(paramMap) || 
				!paramMap.containsKey("client_id") || 
				!paramMap.containsKey("client_secret") ||
				isNullOrEmpty(paramMap.getFirst("client_id")) || 
				isNullOrEmpty(paramMap.getFirst("client_secret"))
				) {
			message(strMensajeErrorParamMap);
		}
	}

	private void message(String message) throws ApiUnauthorizedExeption {
		throw new ApiUnauthorizedExeption(message);
	}
	
	private boolean isNullOrEmpty(String value) {
		return (value == null || value.isEmpty());
	}

}
