package com.devrenno.tcf5.auth.server.controller;

import com.devrenno.tcf5.auth.server.entity.Client;
import com.devrenno.tcf5.auth.server.service.ClientService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Client> findById(@PathVariable String id) {
        var client = clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/validate/{id}")
    public ResponseEntity<Boolean> validade(@PathVariable String id) {
        var isValid = clientService.validade(id);
        return ResponseEntity.ok(isValid);
    }
}
