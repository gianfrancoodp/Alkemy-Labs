package com.alkemy.disneyapi.auth.controller;

import com.alkemy.disneyapi.auth.dto.AuthenticationRequest;
import com.alkemy.disneyapi.auth.dto.AuthenticationResponse;
import com.alkemy.disneyapi.auth.dto.UserDTO;
import com.alkemy.disneyapi.auth.service.JwtUtils;
import com.alkemy.disneyapi.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UserDTO userDTO) throws Exception {
        userDetailsService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse authenticationResponse = userDetailsService.singIn(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}
