package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
}
