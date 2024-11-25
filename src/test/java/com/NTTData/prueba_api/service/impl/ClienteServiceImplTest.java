package com.NTTData.prueba_api.service.impl;

import com.NTTData.prueba_api.dto.ClienteDTO;
import com.NTTData.prueba_api.exception.ClienteNoEncontradoException;
import com.NTTData.prueba_api.exception.TipDocumentationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceImplTest {

    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        clienteService = new ClienteServiceImpl(); //Inicializamos la implementación del servicio
    }

    @Test
    void obtenerCliente_Exito() {
        // Caso de prueba con los datos correctos
        ClienteDTO cliente = clienteService.obtenerCliente("C", "23445322");
        assertNotNull(cliente);
        assertEquals("Jean", cliente.getPrimerNombre());
        assertEquals("Carlos", cliente.getSegundoNombre());
    }

    @Test
    void obtenerCliente_TipoDocumentoInvalido() {
        // Caso de prueba con un documento incorrecto
        Exception exception = assertThrows(TipDocumentationException.class, () ->
                clienteService.obtenerCliente("X", "23445322"));

        assertEquals("Tipo de documento inválido. Solo se permiten cédula(C) o pasaporte(P).", exception.getMessage());
    }

    @Test
    void obtenerCliente_NoEncontrado() {
        // Caso de prueba cuando no encontramos al cliente
        Exception exception = assertThrows(ClienteNoEncontradoException.class, () ->
                clienteService.obtenerCliente("C", "11111111"));

        assertEquals("Cliente no encontrado.", exception.getMessage());
    }
    @Test
    void obtenerCliente_CombinacionInvalida() {
        // Tipo de documento incorrecto
        Exception exception = assertThrows(ClienteNoEncontradoException.class, () ->
                clienteService.obtenerCliente("P", "23445322"));

        assertEquals("Cliente no encontrado.", exception.getMessage());
    }
}
