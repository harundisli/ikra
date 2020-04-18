package com.ikra.controller;


import com.ikra.config.JwtTokenUtil;
import com.ikra.dto.UserDTO;
import com.ikra.model.JwtResponse;
import com.ikra.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @PostMapping(path = "api/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String emailAsUserName, String password) throws Exception {
        //Objects.requireNonNull(username);
        //Objects.requireNonNull(password);
        if(emailAsUserName!=null && password!=null) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(emailAsUserName, password));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
        }else{
            throw new Exception("INVALID_CREDENTIALS", new BadCredentialsException("Bad Credential"));
        }


    }
}
