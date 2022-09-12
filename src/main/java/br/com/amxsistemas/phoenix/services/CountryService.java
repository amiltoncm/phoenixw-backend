package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.entities.Country;
import br.com.amxsistemas.phoenix.repositories.CountryRepository;
import br.com.amxsistemas.phoenix.utils.Messages;
import br.com.amxsistemas.phoenix.utils.UserLogger;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CountryService {

    final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country save(Country country) {
        LocalDateTime localDateTime = LocalDateTime.now();
        country.setUpdated(localDateTime);
        country.setUserUpdated(UserLogger.getUserLog());
        return countryRepository.save(country);
    }

    @Transactional
    public void delete(UUID id) {
        countryRepository.deleteById(id);
    }

    @Transactional
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country getById(UUID id) {
        var opt = countryRepository.findById(id);
        return opt.orElseThrow(() -> new EntityNotFoundException(Messages.getMessage(2))) ;
    }

}
