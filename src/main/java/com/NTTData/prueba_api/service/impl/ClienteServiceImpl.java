package com.NTTData.prueba_api.service.impl;

import com.NTTData.prueba_api.dto.ClienteDTO;
import com.NTTData.prueba_api.exception.ClienteNoEncontradoException;
import com.NTTData.prueba_api.exception.TipDocumentationException;
import com.NTTData.prueba_api.service.ClienteService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ClienteServiceImpl implements ClienteService {
    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Override
    public ClienteDTO obtenerCliente(String tipoDocumento, String numeroDocumento) {
        log.info("Iniciando búsqueda de cliente con tipoDocumento={} y numeroDocumento={}", tipoDocumento, numeroDocumento);

        // Validación del tipo de documento
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            log.error("Tipo de documento inválido: {}", tipoDocumento);
            throw new TipDocumentationException("Tipo de documento inválido. Solo se permiten cédula(C) o pasaporte(P).");
        }

        // Validación del documento del cliente
        if (!tipoDocumento.equals("C") || !"23445322".equals(numeroDocumento)) {
            log.warn("Cliente no encontrado para numeroDocumento={}", numeroDocumento);
            throw new ClienteNoEncontradoException("Cliente no encontrado.");
        }

        // Datos mockeados
        log.info("Cliente encontrado con numeroDocumento={}", numeroDocumento);
        ClienteDTO cliente = new ClienteDTO();
        cliente.setPrimerNombre("Jean");
        cliente.setSegundoNombre("Carlos");
        cliente.setPrimerApellido("Rúa");
        cliente.setSegundoApellido("Perales");
        cliente.setTelefono("3215935341");
        cliente.setDireccion("Palermo, Teusquillo");
        cliente.setCiudadResidencia("Bogotá");
        return cliente;
    }
}
