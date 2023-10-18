package com.pruebas.cliente.service;

import com.pruebas.cliente.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{
    @Override
    public Client getClienteInfo(String tipoDocumento, String numeroDocumento) {
        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Client cliente = new Client();
            cliente.setPrimerNombre("Juan");
            cliente.setPrimerApellido("Pérez");
            cliente.setSegundoApellido("Gómez");
            cliente.setTelefono("555-555-5555");
            cliente.setDireccion("123 Calle Principal");
            cliente.setCiudadResidencia("Ciudad de Ejemplo");
            return cliente;
        } else {
            return null;
        }
    }
}
