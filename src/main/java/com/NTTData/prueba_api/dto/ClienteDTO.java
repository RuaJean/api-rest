package com.NTTData.prueba_api.dto;
import lombok.Data;

@Data
public class ClienteDTO {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;
}
