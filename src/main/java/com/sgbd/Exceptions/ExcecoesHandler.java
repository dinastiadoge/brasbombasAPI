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
    public ResponseEntity<ErrorResponse> ProdutoExistenteExceptionHandler(ProdutoExistenteException produtoExistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.PRODUTO_EXISTENTE.toString());
        response.put("mensagem", produtoExistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BombaExistenteException.class)
    public ResponseEntity<ErrorResponse> BombaExistenteExceptionHandler(BombaExistenteException bombaExistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.BOMBA_EXISTENTE.toString());
        response.put("mensagem", bombaExistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ClienteInexistenteException.class)
    public ResponseEntity<ErrorResponse> ClienteInexistenteExceptionHandler(ClienteInexistenteException clienteInexistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.CLIENTE_INEXISTENTE.toString());
        response.put("mensagem", clienteInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CompraInexistenteException.class)
    public ResponseEntity<ErrorResponse> CompraInexistenteExceptionHandler(CompraInexistenteException compraInexistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.COMPRA_INEXISTENTE.toString());
        response.put("mensagem", compraInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ProdutoInexistenteException.class)
    public ResponseEntity<ErrorResponse> ProdutoInexistenteExceptionHandler(ProdutoInexistenteException produtoInexistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.PRODUTO_INEXISTENTE.toString());
        response.put("mensagem", produtoInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<ErrorResponse> ValorInvalidoExceptionHandler(ValorInvalidoException valorInvalidoException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.VALOR_INVALIDO.toString());
        response.put("mensagem", valorInvalidoException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NaoPermitirAlterarStatusException.class)
    public ResponseEntity<ErrorResponse> NaoPermitirAlterarStatusExceptionHandler(NaoPermitirAlterarStatusException naoPermitirAlterarStatusException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.STATUS_INVALIDO.toString());
        response.put("mensagem", naoPermitirAlterarStatusException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(BombaInexistenteException.class)
    public ResponseEntity<ErrorResponse> BombaInexistenteExceptionHandler(BombaInexistenteException bombaInexistenteException) {

        Map<String, String> response = new HashMap<>();
        response.put("codigo", ErrosEnum.BOMBA_INEXISTENTE.toString());
        response.put("mensagem", bombaInexistenteException.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .errors(Collections.singletonList(response))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}