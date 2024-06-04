package com.sgbd.Exceptions;

import com.sgbd.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExcecoesHandler {

    @ExceptionHandler(ProdutoExistenteException.class)
    public ResponseEntity<ErrorResponse> ProdutoExistenteExceptionHandler(ProdutoExistenteException produtoExistenteException){

        Map<String,String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.PRODUTO_EXISTENTE.toString());
        response.put("mensagem", produtoExistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ClienteInexistenteException.class)
    public ResponseEntity<ErrorResponse> ClienteInexistenteExceptionHandler(ClienteInexistenteException clienteInexistenteException){

        Map<String,String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.CLIENTE_INEXISTENTE.toString());
        response.put("mensagem", clienteInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CompraInexistenteException.class)
    public ResponseEntity<ErrorResponse> CompraInexistenteExceptionHandler(CompraInexistenteException compraInexistenteException){

        Map<String,String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.COMPRA_INEXISTENTE.toString());
        response.put("mensagem", compraInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }





}