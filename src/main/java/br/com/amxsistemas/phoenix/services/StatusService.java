package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.domains.Status;
import br.com.amxsistemas.phoenix.repositories.StatusRepository;
import br.com.amxsistemas.phoenix.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Transactional
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Transactional
    public String saveList(List<Status> status) {
        try {
            statusRepository.saveAll(status);
            return Messages.getMessage(4);
        } catch(Exception e) {
            return Messages.getMessage(3);
        }
    }

    @Transactional
    public void delete(int id) {
        statusRepository.deleteById(id);
    }

    @Transactional
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Transactional
    public Status getById(int id) {
        var opt = statusRepository.findById(id);
        return opt.orElseThrow(() -> new EntityNotFoundException(Messages.getMessage(2)));
    }

}
