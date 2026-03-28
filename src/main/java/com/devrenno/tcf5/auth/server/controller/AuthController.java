package com.devrenno.tcf5.auth.server.controller;

import com.devrenno.tcf5.auth.server.entity.Client;
import com.devrenno.tcf5.auth.server.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ClientService clientService;

    public AuthController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    @GetMapping("/validate/{id}")
    public boolean validade(@PathVariable String id) {
        return clientService.validade(id);
    }
}
