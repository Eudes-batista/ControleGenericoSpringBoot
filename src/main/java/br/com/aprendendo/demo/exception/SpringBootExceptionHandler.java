package br.com.aprendendo.demo.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpringBootExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagem = this.messageSource.getMessage("campo.desconhecido", null, LocaleContextHolder.getLocale());
        String mensagemDesevolvedor = ex.getCause().toString();
        return handleExceptionInternal(ex, List.of(new ServerResponseError(mensagem, mensagemDesevolvedor)), headers, HttpStatus.BAD_REQUEST, request);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, ex, headers, HttpStatus.BAD_REQUEST, request);
    }

    public List<ServerResponseError> criarListaDeErros(BindingResult bindingResult) {
        List<ServerResponseError> erros = new ArrayList<>();
        String mensagem;
        String mensagemDesevolvedor;
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            mensagem = this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            mensagemDesevolvedor = fieldError.toString();
            erros.add(new ServerResponseError(mensagem, mensagemDesevolvedor));
        }
        return erros;
    }

}
