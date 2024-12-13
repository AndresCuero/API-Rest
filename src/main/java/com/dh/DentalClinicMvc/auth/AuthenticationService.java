package com.dh.DentalClinicMvc.auth;

import com.dh.DentalClinicMvc.Repository.IUserRepository;
import com.dh.DentalClinicMvc.configuration.JwtService;
import com.dh.DentalClinicMvc.entity.Role;
import com.dh.DentalClinicMvc.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository iUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        iUserRepository.save(user);

        var jwt = jwtService.geneteToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request){
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       request.getEmail(),
                       request.getPassword()
               )
       );
       var user = iUserRepository.findByEmail(request.getEmail())
               .orElseThrow();

        var jwt = jwtService.geneteToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
