package com.ikra.service;

import com.ikra.dto.UserDTO;
import com.ikra.model.JwtResponse;

public interface AuthenticationService {

    JwtResponse authenticate(UserDTO authenticationRequest) throws Exception;
}
