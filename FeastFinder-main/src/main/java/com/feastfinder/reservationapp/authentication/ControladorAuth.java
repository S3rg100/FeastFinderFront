package com.feastfinder.reservationapp.authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class ControladorAuth {
    
    private final ServicioAuth authService;
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody PeticionLogin request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody PeticionRegister request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
