package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.entities.Establishment;
import br.com.amxsistemas.phoenix.repositories.EstablishmentRepository;
import br.com.amxsistemas.phoenix.utils.Messages;
import br.com.amxsistemas.phoenix.utils.UserLogger;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EstablishmentService {

    final EstablishmentRepository establishmentRepository;

    public EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Transactional
    public Establishment save(Establishment establishment) {
        LocalDateTime localDateTime = LocalDateTime.now();
        establishment.setUpdated(localDateTime);
        establishment.setUserUpdated(UserLogger.getUserLog());
        return establishmentRepository.save(establishment);
    }

    @Transactional
    public void delete(UUID id) {
        establishmentRepository.deleteById(id);
    }

    @Transactional
    public List<Establishment> getAll() {
        return establishmentRepository.findAll();
    }

    @Transactional
    public Establishment getById(UUID id) {
        var opt = establishmentRepository.findById(id);
        return opt.orElseThrow(() -> new EntityNotFoundException(Messages.getMessage(2)));
    }

}
