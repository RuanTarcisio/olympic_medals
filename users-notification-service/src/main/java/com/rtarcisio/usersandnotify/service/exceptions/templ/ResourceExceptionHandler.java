package com.rtarcisio.usersandnotify.service.exceptions.templ;


import com.rtarcisio.usersandnotify.service.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailSendException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@ControllerAdvice
public class ResourceExceptionHandler {


	@ExceptionHandler(IOException.class)
	public ResponseEntity<StandardError> _IOException(IOException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), "Parametro invalido");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}	
	@ExceptionHandler(MailSendException.class)
	public ResponseEntity<StandardError> emailError(MailSendException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação.");

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StandardError> response(ResponseStatusException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(DataInvalidaException.class)
	public ResponseEntity<StandardError> dataValidation(DataInvalidaException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<StandardError> notFound(UsuarioNaoEncontradoException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(ObjetoJaCadastradoException.class)
	public ResponseEntity<StandardError> jaCadastrado(ObjetoJaCadastradoException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> notFound(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DadosProtegidosException.class)
	public ResponseEntity<StandardError> handleDadosProtegidosException(DadosProtegidosException e,
			HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}

	@ExceptionHandler(DadoInvalidoException.class)
	public ResponseEntity<StandardError> dadoInvalido(DadoInvalidoException e, HttpServletRequest request) {

		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(DisabledException.class)
	public ResponseEntity<StandardError> loginInativo(DisabledException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);

	}

	@ExceptionHandler(EnvioDeEmailException.class)
	public ResponseEntity<StandardError> envioDeEmailException(EnvioDeEmailException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_GATEWAY.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);

	}

	@ExceptionHandler(UsuarioInvalidoException.class)
	public ResponseEntity<StandardError> usuarioInvalidoException(UsuarioInvalidoException e,
			HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);

	}

	@ExceptionHandler(ObjetoNaoRemovidoException.class)
	public ResponseEntity<StandardError> objetoNaoRemovidoException(ObjetoNaoRemovidoException e,
			HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> campoMalFormadoException(HttpMessageNotReadableException e,
			HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

}
