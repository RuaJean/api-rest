package com.NTTData.prueba_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private int statusCode;
    private String message;
    private String path;    // La ruta donde ocurrió el error.
}
