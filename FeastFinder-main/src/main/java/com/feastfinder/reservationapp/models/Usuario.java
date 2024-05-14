package com.feastfinder.reservationapp.models;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    String apellido;

    @Column(name = "correoelectronico", nullable = false)
    String correoElectronico;

    @Column(name = "contrasena", nullable = false, length = 300)
    String contrasena;

    @Column(name = "nombredecuenta", nullable = false, length = 255)
    String nombredecuenta;

    @Column(name = "estadosesion", nullable = true, length = 1)
    char estadoSesion;

    @Column(name = "fecharegistro", nullable = false)
    LocalDateTime fecharegistro;

    Role role;

    @OneToMany
    @JoinColumn(name = "UsuarioID")
    private Set<Pqr> pqrs;

    @OneToMany
    @JoinColumn(name = "UsuarioID")
    private Set<Reserva> reservas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }
    

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.nombredecuenta;
    }
}