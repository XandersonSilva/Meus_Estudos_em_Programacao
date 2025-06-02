package xanderson.edu.primeiraSpringAPI.handler;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.annotation.Resource;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseErro responseErro(String mensagem, HttpStatus statusCode) {
        ResponseErro responseErro = new ResponseErro();
        responseErro.setStatus("error");
        responseErro.setError(mensagem);
        responseErro.setStatusCode(statusCode.value());
        return responseErro;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            Throwable undeclared = exception.getUndeclaredThrowable();
            if (undeclared instanceof BusinessException) {
                return handleBusinessException((BusinessException) undeclared);
            }
        }

        String mensagem = messageSource.getMessage("error.server", null, request.getLocale());
        ResponseErro error = responseErro(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, headers(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    private ResponseEntity<Object> handleBusinessException(BusinessException e) {
        ResponseErro error = responseErro(e.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(error, headers(), HttpStatus.CONFLICT);
    }
}