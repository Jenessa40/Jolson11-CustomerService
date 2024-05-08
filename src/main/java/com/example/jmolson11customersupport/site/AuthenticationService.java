package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.entities.UserPrincipal;

public interface AuthenticationService {
    UserPrincipal authenticate(String username, String password);
    void saveUser(UserPrincipal principal, String newPassword);
}

