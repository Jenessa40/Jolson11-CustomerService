package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.entities.UserPrincipal;

public interface UserPrincipalRepository extends GenericRepository<Long, UserPrincipal> {
    UserPrincipal getByUsername(String username);
}
