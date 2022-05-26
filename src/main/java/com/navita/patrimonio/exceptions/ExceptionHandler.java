package com.navita.patrimonio.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Captura AppExceptions e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} Bad Request
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(MarcaException.class)
	public ResponseEntity<Object> marcaException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Captura AppExceptions e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} Bad Request
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(UsuarioException.class)
	public ResponseEntity<Object> usuarioException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Captura Exceptions e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} Internal Error Server
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<Object> internalServerErrorException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Captura BadCredentialsException e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} FORBIDDEN
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Object> badCredentialsException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.FORBIDDEN);
	}

	/**
	 * Captura HttpClientErrorException e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} UNAUTHORIZED
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Object> httpClientErrorException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Captura HttpClientErrorException e retorna objeto Dto com as informações
	 * 
	 * @return {@link HttpStatus} UNAUTHORIZED
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> accessDeniedException(Throwable exception, WebRequest request) {
		return sendResponseExceptionRequest(exception, request, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Monta o objeto com as informações da Exception
	 * 
	 * @return {@link HttpStatus}
	 */
	private static ResponseEntity<Object> sendResponseExceptionRequest(Throwable exception, WebRequest request,
			HttpStatus status) {

		var exceptionResponseDto = new ExceptionResponseDto(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(status).body(exceptionResponseDto);

	}
}
