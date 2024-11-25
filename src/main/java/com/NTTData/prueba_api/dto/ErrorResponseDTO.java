package com.NTTData.prueba_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponseDTO {
    private int statusCode;
    private String message;
    private String path; // La ruta donde ocurrió el error.

    public ErrorResponseDTO(int statusCode, String message, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
    }
}
