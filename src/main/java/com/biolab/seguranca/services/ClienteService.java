package com.biolab.seguranca.services;

import com.biolab.seguranca.DTOs.ClienteDTO;
import com.biolab.seguranca.entities.Cliente;
import com.biolab.seguranca.entities.enums.Role;
import com.biolab.seguranca.repositories.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository clienteRepository;

    public ClienteService(PasswordEncoder passwordEncoder, ClienteRepository clienteRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clienteRepository = clienteRepository;
    }


    public Cliente criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        cliente.setSenha(dto.getSenha());
        if (dto.getRole() == null) {
            cliente.setRole(Role.ROLE_USER);
        }else {
            cliente.setRole(dto.getRole());
        }
        clienteRepository.save(cliente);
        return cliente;
    }
}
