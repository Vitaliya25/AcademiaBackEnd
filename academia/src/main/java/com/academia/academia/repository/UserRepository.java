/**
 * Repositorio UserRepository
 *
 * Interfaz que extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Usuario.
 * Incluye métodos personalizados de búsqueda por atributos únicos:
 *
 * - findByUsername: busca un usuario por su nombre de usuario.
 * - findByEmail: busca un usuario por su correo electrónico.
 **/

package com.academia.academia.repository;

import com.academia.academia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
}
