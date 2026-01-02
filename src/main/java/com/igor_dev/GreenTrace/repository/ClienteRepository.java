package com.igor_dev.GreenTrace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor_dev.GreenTrace.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long>{}
