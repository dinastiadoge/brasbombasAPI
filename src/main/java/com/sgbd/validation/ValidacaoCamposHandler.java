package com.sgbd.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgbd.response.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ValidacaoCamposHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> tratarValidacoes(MethodArgumentNotValidException ex) {

        List<Map<String, String>> listErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> {
                    Map<String, String> erros = new HashMap<>();
                    erros.put("campo", obterNomePropriedade((erro)));
                    erros.put("descricao", erro.getDefaultMessage());

                    return erros;
                }).toList();

        ErrorResponse response = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .errors(listErrors)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    private String obterNomePropriedade(final FieldError error) {

        if (error.contains(ConstraintViolation.class)) {

            try {
                final ConstraintViolation<?> violation = error.unwrap(ConstraintViolation.class);
                final Field campo;

                campo = violation.getRootBeanClass().getDeclaredField(error.getField());

                final JsonProperty anotacao = campo.getAnnotation(JsonProperty.class);


                if (anotacao != null && anotacao.value() != null && !anotacao.value().isEmpty()) {
                    return anotacao.value();
                }
            } catch (Exception e) {
            }
        }
        return error.getField();
    }
}
