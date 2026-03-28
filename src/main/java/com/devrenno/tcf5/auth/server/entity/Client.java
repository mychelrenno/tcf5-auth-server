package com.devrenno.tcf5.auth.server.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Client {

    @Id
    private String id;

    private String razaoSocial;

    private String cnpj;
}
