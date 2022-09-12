package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {}
