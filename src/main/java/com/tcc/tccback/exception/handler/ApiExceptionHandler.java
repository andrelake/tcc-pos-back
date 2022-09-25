package com.tcc.tccback.exception.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.tcc.tccback.exception.EntidadeNaoEncontradaException;
import com.tcc.tccback.exception.NegocioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        TipoProblema tipoProblema = TipoProblema.RECURSO_NAO_ENCONTRADO;
        String detail = ex.getMessage();

        Problema problem = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        TipoProblema tipoProblema = TipoProblema.ERRO_NEGOCIO;
        String detail = ex.getMessage();

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, Problema, new HttpHeaders(), status, request);
    }

    private ResponseEntity<Object> handlePropertyBindingException(PropertyBindingException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        String path = joinPath(ex.getPath());

        TipoProblema tipoProblema = TipoProblema.MENSAGEM_INCOMPREENSIVEL;
        String detail = String.format("A propriedade '%s' não existe. "
                + "Corrija ou remova essa propriedade e tente novamente.", path);

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, Problema, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(org.springframework.beans.TypeMismatchException ex,
                                                        HttpHeaders headers, HttpStatus status, WebRequest request) {

        if(ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpHeaders headers,
                                                                    HttpStatus status, WebRequest request) {

        TipoProblema tipoProblema = TipoProblema.PARAMETRO_INVALIDO;

        String detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', "
                + "que é um valor inválido. Corrija e informe um valor compatível.", ex.getName(), ex.getValue());

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, Problema, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {

        TipoProblema tipoProblema = TipoProblema.RECURSO_NAO_ENCONTRADO;

        String detail = String.format("O recurso '%s', que você tentou acessar, é inexistente.", ex.getRequestURL());

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, Problema, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        TipoProblema tipoProblema = TipoProblema.ERRO_DE_SISTEMA;

        String detail = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o Problemaa persistir, entre em contato "
                + "com o administrador do sistema.";

        ex.printStackTrace();

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail).build();

        return handleExceptionInternal(ex, Problema, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        TipoProblema tipoProblema = TipoProblema.DADOS_INVALIDOS;

        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        BindingResult bindingResult = ex.getBindingResult();
        List<Problema.Field> ProblemaFields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> Problema.Field.builder()
                        .name(fieldError.getField())
                        .userMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        Problema Problema = createProblemaBuilder(status, tipoProblema, detail)
                .fields(ProblemaFields)
                .build();

        return handleExceptionInternal(ex, Problema, headers, status, request);
    }

    private String joinPath(List<JsonMappingException.Reference> references) {
        return references.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if(body == null) {
            body = Problema.builder()
                    .titulo(status.getReasonPhrase())  //pequena descrição do status de resposta
                    .status(status.value())   //pega o código do status http
                    .build();
        }
        else if (body instanceof String){
            body = Problema.builder()
                    .titulo((String) body)
                    .status(status.value())
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Problema.ProblemaBuilder createProblemaBuilder(HttpStatus status, TipoProblema TipoProblema, String detail) {

        return Problema.builder()
                .status(status.value())
                .tipo(TipoProblema.getUri())
                .titulo(TipoProblema.getTitulo())
                .descricao(detail);
    }
}
