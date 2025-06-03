/**
 * Interfaz UserService
 *
 * Define las operaciones para gestionar usuarios en el sistema.
 * Permite obtener, crear, actualizar y eliminar usuarios,
 * así como buscar usuarios por username o email.
 *
 * Métodos principales:
 * - obtenerTodos(): devuelve la lista completa de usuarios.
 * - obtenerPorId(Long id): obtiene un usuario por su ID.
 * - guardar(Usuario usuario): crea o actualiza un usuario.
 * - eliminar(Long id): elimina un usuario por su ID.
 * - obtenerPorUsername(String username): busca un usuario por su nombre de usuario.
 * - obtenerPorEmail(String email): busca un usuario por su correo electrónico.
 */
package com.academia.academia.service;

import com.academia.academia.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Usuario> obtenerTodos();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);

    Optional<Usuario> obtenerPorUsername(String username);
    Optional<Usuario> obtenerPorEmail(String email);
}
