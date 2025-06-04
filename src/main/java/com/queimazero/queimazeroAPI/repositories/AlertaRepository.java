package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.Agricultor;
import com.queimazero.queimazeroAPI.models.Alerta;
import com.queimazero.queimazeroAPI.models.PontoQueimada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta,Long> {
    @Query("SELECT CASE WHEN COUNT(ac) > 0 THEN true ELSE false END " +
            "FROM Alerta ac " +
            "WHERE ac.agricultor = :agricultor " +
            "AND ac.pontoQueimada = :pontoQueimada " +
            "AND ac.alertaEnviado = :alertaEnviado")
    boolean existsByAgricultorAndPontoQueimadaAndAlertaEnviado(
            @Param("agricultor") Agricultor agricultor,
            @Param("pontoQueimada") PontoQueimada pontoQueimada,
            @Param("alertaEnviado") Character alertaEnviado);
}
