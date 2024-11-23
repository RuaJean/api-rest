package com.NTTData.prueba_api.service;
import com.NTTData.prueba_api.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO obtenerCliente(String tipoDocumento, String numeroDocumento);
}
