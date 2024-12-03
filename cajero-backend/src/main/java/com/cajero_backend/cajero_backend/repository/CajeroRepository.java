package com.cajero_backend.cajero_backend.repository;

import com.cajero_backend.cajero_backend.models.Cajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajeroRepository extends JpaRepository<Cajero, Long> {
}
