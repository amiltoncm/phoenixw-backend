package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.entities.Profile;
import br.com.amxsistemas.phoenix.repositories.ProfileRepository;
import br.com.amxsistemas.phoenix.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProfileService {

    final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    };

    @Transactional
    public Profile save(Profile profile) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now();
        profile.setUpdated(localDateTime);
        return profileRepository.save(profile);
    }

    @Transactional
    public void delete (UUID id) {
        profileRepository.deleteById(id);
    }

    @Transactional
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Transactional
    public Profile getById(UUID id) {
        var opt = profileRepository.findById(id);
        return opt.orElseThrow(() -> new EntityNotFoundException(Messages.getMessage(2)));
    }

}
