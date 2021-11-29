package br.com.indtex.sigo.normas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DadosFaltandoException extends RuntimeException {
    public DadosFaltandoException(String message) {
        super(message);
    }
}
