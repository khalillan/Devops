package tn.esprit.rh.achat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FacturerException extends RuntimeException {
    public FacturerException(String message) {
        super(message);
    }
}
