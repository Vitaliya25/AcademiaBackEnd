/**
 * Clase Usuario
 * Representa a entidad Usuario del sistema, utilizado para autenticación y gestión de acceso.
 * Contiene campos básicos como nombre de usuario (username), contraseña (password) y correo electrónico (email).
 * Esta clase puede ser utilizada para gestionar inicios de sesión y autorizaciones para diferentes usuarios.
 */

package com.academia.academia.entity;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    public Usuario() {
    }

    public Usuario(String username, String password, String email){//, Rol role) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



