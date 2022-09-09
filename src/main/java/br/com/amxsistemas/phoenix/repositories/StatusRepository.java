package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.domains.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository <Status, Integer> {}
