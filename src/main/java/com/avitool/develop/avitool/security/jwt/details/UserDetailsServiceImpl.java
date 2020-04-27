package com.avitool.develop.avitool.security.jwt.details;

import com.avitool.develop.avitool.models.User;
import com.avitool.develop.avitool.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findUserByLogin(login);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
            return new UserDetailsImpl(user);
        }
        System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGgg");
        throw new UsernameNotFoundException("User not found with this login or password");
    }
}
