package com.ads.library.auth.services;


import com.ads.library.auth.models.Role;

import java.util.Set;

public interface IRoleService {

    Set<Role> RolesMap(Set<String> strRoles) throws RuntimeException;
}
