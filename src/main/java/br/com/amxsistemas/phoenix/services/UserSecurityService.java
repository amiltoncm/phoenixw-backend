package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.repositories.UserRepository;
import br.com.amxsistemas.phoenix.utils.messages.Messages;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecurityService implements UserDetailsService {

    final UserRepository userRepository;

    public UserSecurityService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var opt = userRepository.findByName(username);
        var user = opt.orElseThrow(()-> new UsernameNotFoundException(Messages.getMessage(5)));
        return new UserDetails(user.getName(), user.getPassword());
    }
}
