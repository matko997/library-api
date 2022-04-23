package com.libraryapp.libraryapp.service;

import com.libraryapp.libraryapp.domain.model.AppUser;
import com.libraryapp.libraryapp.domain.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        if (user.isPresent()) {
            return new User(user.get().getUsername(), user.get().getPassword(), user.get().getAuthorities());
        }

        throw new UsernameNotFoundException("Oops, seems like there is no user " + username);

    }
}
