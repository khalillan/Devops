package tn.esprit.rh.achat.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FournisseurException extends RuntimeException {
    public FournisseurException(String message) {
        super(message);
    }
}
