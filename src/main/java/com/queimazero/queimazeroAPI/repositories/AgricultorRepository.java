package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {

}
