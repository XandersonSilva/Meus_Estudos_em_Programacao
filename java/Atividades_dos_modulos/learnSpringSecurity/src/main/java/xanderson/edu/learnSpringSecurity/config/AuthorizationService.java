package xanderson.edu.learnSpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xanderson.edu.learnSpringSecurity.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{
    @Autowired
    UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            return repository.findByUsername(username);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
        }

    }
    
}
