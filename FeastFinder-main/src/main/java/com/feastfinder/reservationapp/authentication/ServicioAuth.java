package com.feastfinder.reservationapp.authentication;
import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.feastfinder.reservationapp.jwt.JwtService;
import com.feastfinder.reservationapp.models.Role;
import com.feastfinder.reservationapp.models.Usuario;
import com.feastfinder.reservationapp.repositories.RepositorioUsuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioAuth {
    
    private final JwtService jwtService;
    private final RepositorioUsuario repositorioUsuario;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(PeticionLogin request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombredecuenta(), request.getContrasena()));
        UserDetails user=repositorioUsuario.findByNombredecuenta(request.getNombredecuenta()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(PeticionRegister request) {
        Usuario usuario = Usuario.builder()
            //.id(1)
            .nombredecuenta(request.getNombredecuenta())
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .contrasena(passwordEncoder.encode(request.getContrasena()))
            .correoElectronico(request.getCorreoElectronico())
            .fecharegistro(LocalDateTime.now()) //
            .estadoSesion('A')//
            .role(Role.USUARIO)
            .build();

        repositorioUsuario.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
