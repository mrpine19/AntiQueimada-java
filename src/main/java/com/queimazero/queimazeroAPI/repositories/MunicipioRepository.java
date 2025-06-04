package com.queimazero.queimazeroAPI.repositories;

import com.queimazero.queimazeroAPI.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    boolean existsByNomeMunicipio(String nomeMunicipio);
    Municipio findByNomeMunicipio(String nomeMunicipio);
}
