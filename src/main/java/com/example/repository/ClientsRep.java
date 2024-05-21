package com.example.repository;

import com.example.models.Clients;
import org.springframework.data.repository.CrudRepository;
public interface ClientsRep extends CrudRepository<Clients, Integer> {
}
