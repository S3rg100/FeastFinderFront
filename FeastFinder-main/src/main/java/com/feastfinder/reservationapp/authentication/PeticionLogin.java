package com.feastfinder.reservationapp.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeticionLogin {
    String nombredecuenta;
    String contrasena;
}
