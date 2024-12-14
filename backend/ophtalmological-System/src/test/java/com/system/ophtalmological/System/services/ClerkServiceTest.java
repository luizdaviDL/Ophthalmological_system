package com.system.ophtalmological.System.services;

import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.repository.ClerckRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClerkServiceTest {
    @Autowired
    public ClerckRepository repository;

    @Test
    void getDocument() {
        String cpf = "48752144777";
        Optional<Clerk> fingDocument = repository.findByCpf(cpf);

    }
}