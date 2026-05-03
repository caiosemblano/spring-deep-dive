package com.learning.spring_deep_dive.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;
import org.springframework.web.bind.MethodArgumentNotValidException;

/*
 * PASSO 2: Criar o Manipulador Global de Exceções.
 * O QUE VOCÊ DEVE FAZER:
 * - Esta classe "escuta" todas as exceções lançadas nos seus Controllers.
 * - Sempre que você criar uma nova exceção customizada no projeto, você deve vir aqui
 *   e adicionar um novo método com @ExceptionHandler para tratá-la.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    /*
     * TRATAMENTO PARA RECURSO NÃO ENCONTRADO (404)
     * Captura: NoSuchElementException (lançada pelo .get() de Optional ou .orElseThrow())
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> entityNotFound(NoSuchElementException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    /*
     * TRATAMENTO PARA ERROS GENÉRICOS DE RUNTIME (400)
     * Captura: Qualquer RuntimeException que não tenha um tratamento mais específico acima.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> badRequest(RuntimeException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Bad Request");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    
    /*
     * DICA: Se você quiser tratar erros de validação (@Valid), 
     * você pode adicionar um handler para MethodArgumentNotValidException aqui.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Bad Request");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
