package com.NTTData.prueba_api.api.controller;

import com.NTTData.prueba_api.dto.ClienteDTO;
import com.NTTData.prueba_api.dto.ErrorResponseDTO;
import com.NTTData.prueba_api.exception.ClienteNoEncontradoException;
import com.NTTData.prueba_api.exception.TipoDocumentoInvalidoException;
import com.NTTData.prueba_api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
public class clientes {
    private final ClienteService clienteService;

    public clientes(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{tipoDocumento}/{numeroDocumento}")
    public ResponseEntity<?> obtenerCliente(
            @PathVariable String tipoDocumento,
            @PathVariable String numeroDocumento) {
        try {
            // Llamamos al servicio
            ClienteDTO cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
            return ResponseEntity.ok(cliente);

        } catch (TipoDocumentoInvalidoException ex) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                    400,
                    ex.getMessage(),
                    String.format("/api/v1/clientes/%s/%s", tipoDocumento, numeroDocumento)
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        } catch (ClienteNoEncontradoException ex) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                    404,
                    ex.getMessage(),
                    String.format("/api/v1/clientes/%s/%s", tipoDocumento, numeroDocumento)
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        } catch (Exception ex) {
            // Otro error
            ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                    500,
                    "Error interno",
                    String.format("/api/v1/clientes/%s/%s", tipoDocumento, numeroDocumento)
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
