package com.biolab.seguranca.controllers;

import com.biolab.seguranca.DTOs.ClienteDTO;
import com.biolab.seguranca.repositories.ClienteRepository;
import com.biolab.seguranca.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.criarCliente(dto));
    }
}
