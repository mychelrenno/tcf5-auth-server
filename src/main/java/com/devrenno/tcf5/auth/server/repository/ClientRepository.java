package com.devrenno.tcf5.auth.server.repository;

import com.devrenno.tcf5.auth.server.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
}
