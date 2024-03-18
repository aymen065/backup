package com.ads.library.auth.services;


import com.ads.library.auth.models.User;

public interface IUserService {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    void createUser(User user);

}
