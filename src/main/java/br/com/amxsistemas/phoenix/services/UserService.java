package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.entities.User;
import br.com.amxsistemas.phoenix.repositories.UserRepository;
import br.com.amxsistemas.phoenix.utils.Messages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setUpdated(localDateTime);
        return userRepository.save(user);
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User getById(UUID id) {
        var opt = userRepository.findById(id);
        return opt.orElseThrow(() -> new EntityNotFoundException(Messages.getMessage(2)));
    }

}
