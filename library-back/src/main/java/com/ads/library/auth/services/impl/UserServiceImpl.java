package com.ads.library.auth.services.impl;

import com.ads.library.auth.repositories.IUserRepository;
import com.ads.library.auth.services.IUserService;
import com.ads.library.auth.models.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
