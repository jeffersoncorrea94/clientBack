package com.pruebas.cliente.controller;

import com.pruebas.cliente.dto.ConsultClientDTO;
import com.pruebas.cliente.model.Client;
import com.pruebas.cliente.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping
@Api(value = "Operaciones en clientes", description = "Consultas de clientes en código")
@Validated
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation(value = "Obtener los datos básicos del cliente con identificación 23445322 y tipo de documento C = Cedula.")
    @GetMapping("/cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - Successful response"),
            @ApiResponse(code = 202, message = "Accepted - No Data"),
            @ApiResponse(code = 400, message = "Bad Request - Invalid input"),
            @ApiResponse(code = 404, message = "Not Found - Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error - Something went wrong")
    })
    public ResponseEntity<Client> getClienteInfo(@Valid ConsultClientDTO consultaClienteDTO) {
            Client cliente = clientService.getClienteInfo(consultaClienteDTO.getTipoDocumento(), consultaClienteDTO.getNumeroDocumento());
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
