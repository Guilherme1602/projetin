package org.serratec.projetin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu, hh:mm:ss");
		
		ErroResposta erro = new ErroResposta(status.value(), "Erros à vista! :(", LocalDateTime.now().format(formatters));
		
		return super.handleExceptionInternal(ex, erro, headers, status, request);
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
}
