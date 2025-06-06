package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.PontoQueimada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PontoQueimadaRepository extends JpaRepository<PontoQueimada, Long> {
    @Query("SELECT pq FROM PontoQueimada pq WHERE pq.dataQueimada >= :dataQueimada")
    List<PontoQueimada> findByDataQueimadaAfter(@Param("dataQueimada") LocalDateTime dataQueimada);
}
