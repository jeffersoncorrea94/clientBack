package com.pruebas.cliente.controller;

import com.pruebas.cliente.dto.ConsultClientDTO;
import com.pruebas.cliente.model.Client;
import com.pruebas.cliente.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@Validated
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/cliente")
    public ResponseEntity<Client> getClienteInfo(@Valid ConsultClientDTO consultaClienteDTO) {
            Client cliente = clientService.getClienteInfo(consultaClienteDTO.getTipoDocumento(), consultaClienteDTO.getNumeroDocumento());
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
