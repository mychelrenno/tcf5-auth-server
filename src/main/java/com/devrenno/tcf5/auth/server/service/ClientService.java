package com.devrenno.tcf5.auth.server.service;

import com.devrenno.tcf5.auth.server.entity.Client;
import com.devrenno.tcf5.auth.server.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clienteRepository;

    public ClientService(ClientRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Client findById(String id) {
        return clienteRepository.findById(id).orElseThrow();
    };

    public boolean validade(String id) {
        var opCliente = clienteRepository.findById(id);
        if (opCliente.isPresent()) {
            return true;
        }
        return false;
    };
}
