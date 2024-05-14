package com.feastfinder.reservationapp.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeticionRegister {
    String nombredecuenta;
    String contrasena;
    String nombre;
    String apellido;
    String correoElectronico; 
}
