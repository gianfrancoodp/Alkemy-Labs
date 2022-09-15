package com.alkemy.disneyapi.auth.filter;

import com.alkemy.disneyapi.auth.service.JwtUtils;
import com.alkemy.disneyapi.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsCustomService.loadUserByUsername(username);

            if (jwtUtils.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authReq =
                        //new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                        new UsernamePasswordAuthenticationToken(userDetails, null, null);
                //Authentication auth = authenticationManager.authenticate(authReq); // TODO: Esto no debería ir
                SecurityContextHolder.getContext().setAuthentication(authReq); //Originalmente era auth en vez de authReq
            }
        }
        filterChain.doFilter(request, response);

    }
}
