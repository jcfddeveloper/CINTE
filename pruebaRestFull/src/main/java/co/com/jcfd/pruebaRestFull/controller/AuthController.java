package co.com.jcfd.pruebaRestFull.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.jcfd.pruebaRestFull.dto.JwtResponseDto;
import co.com.jcfd.pruebaRestFull.exception.ApiUnauthorizedExeption;
import co.com.jcfd.pruebaRestFull.service.AuthService;
import co.com.jcfd.pruebaRestFull.validate.AuthValidator;

@RestController
@RequestMapping(path = "v1.0")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthValidator authValidator;

	@PostMapping(path = "oauth/client_credential/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> login(@RequestBody MultiValueMap<String, String> paramMap,
			@RequestParam("grant_type") String grantType) throws ApiUnauthorizedExeption {

		authValidator.validate(paramMap, grantType);

		JwtResponseDto response = authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret"));

		return ResponseEntity.ok(response);
	}

}
