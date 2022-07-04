package co.com.jcfd.pruebaRestFull.service.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.com.jcfd.pruebaRestFull.dto.JwtResponseDto;
import co.com.jcfd.pruebaRestFull.dto.PayloadDataDto;
import co.com.jcfd.pruebaRestFull.security.JwtIO;
import co.com.jcfd.pruebaRestFull.service.AuthService;
import co.com.jcfd.pruebaRestFull.util.DateUtils;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private JwtIO jwtIO;
	
	@Autowired
	private DateUtils dateUtils;
	
	@Value("${jms.jwt.token.expires-in}")
	private int EXPIRES_IN;
	
	UUID uuid = UUID.randomUUID();
	
	public JwtResponseDto login(String clientId, String clientSecret) {
		
		PayloadDataDto payloadDataDto = PayloadDataDto.builder()
				.name("App-client")
				.role("USER")
				.uid(uuid.toString())
				.country("COL")
				.build();
		
		return JwtResponseDto.builder()
				.tokenType("bearer")
				.accessToken(jwtIO.generateToken(payloadDataDto))
				.issuedAt(String.valueOf(dateUtils.getDateMillis()))
				.clientId(clientId)
				.expiresIn(EXPIRES_IN)
				.build();
	}

}
