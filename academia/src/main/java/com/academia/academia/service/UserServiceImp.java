/**
 * Implementación del servicio UserService
 *
 * Esta clase gestiona la lógica de negocio relacionada con los usuarios,
 * utilizando UserRepository para acceder a la base de datos.
 *
 * Métodos principales:
 * - obtenerTodos(): devuelve la lista completa de usuarios.
 * - obtenerPorId(Long id): obtiene un usuario por su ID.
 * - guardar(Usuario usuario): crea o actualiza un usuario.
 * - eliminar(Long id): elimina un usuario por su ID.
 * - obtenerPorUsername(String username): busca un usuario por su nombre de usuario.
 * - obtenerPorEmail(String email): busca un usuario por su correo electrónico.
 * */
package com.academia.academia.service;

import com.academia.academia.entity.Usuario;
import com.academia.academia.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Obtener todos los alumnos
    @Override
    public List<Usuario> obtenerTodos() {
        return userRepository.findAll();
    }

    // Obtener un alumno por ID
    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return userRepository.findById(id);
    }

    // Crear o actualizar un alumno
    @Override
    public Usuario guardar(Usuario usuario) {
        return userRepository.save(usuario);
    }

    // Eliminar un alumno
    @Override
    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> obtenerPorUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<Usuario> obtenerPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
