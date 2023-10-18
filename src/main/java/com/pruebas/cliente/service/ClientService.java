package com.pruebas.cliente.service;

import com.pruebas.cliente.model.Client;
public interface ClientService {
    Client getClienteInfo(String tipoDocumento, String numeroDocumento);
}
