package com.NTTData.prueba_api.exception;

public class ClienteNoEncontradoException extends RuntimeException {
    public ClienteNoEncontradoException(String errorMessage) {
        super(errorMessage); // Usa getMessage() para acceder al mensaje
    }
}
