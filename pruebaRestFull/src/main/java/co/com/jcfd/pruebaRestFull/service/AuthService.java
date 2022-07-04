package co.com.jcfd.pruebaRestFull.service;

import co.com.jcfd.pruebaRestFull.dto.JwtResponseDto;

public interface AuthService {
	
	/**
	 * 
	 * @param clientId
	 * @param clientSecret
	 * @return
	 */
	public JwtResponseDto login(String clientId, String clientSecret);

}
