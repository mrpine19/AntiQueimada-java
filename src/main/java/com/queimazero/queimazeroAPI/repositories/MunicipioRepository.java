package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    boolean existsByNomeMunicipio(String nomeMunicipio);
    Optional<Municipio> findByNomeMunicipio(String nomeMunicipio);
}
