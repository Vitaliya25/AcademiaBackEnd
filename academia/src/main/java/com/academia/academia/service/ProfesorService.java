/**
 * Interfaz ProfesorService
 *
 * Define las operaciones para gestionar profesores dentro del sistema.
 * Permite obtener, guardar, eliminar profesores y asignarles clases.
 * También incluye búsquedas basadas en nombre o apellido con insensibilidad a mayúsculas.
 *
 * Métodos clave:
 * - obtenerTodos(): devuelve la lista completa de profesores.
 * - obtenerPorId(Long id): obtiene un profesor por su ID.
 * - guardarProfesor(Profesor profesor): crea o actualiza un profesor.
 * - eliminarProfesor(Long id): elimina un profesor según su ID.
 * - asignarClase(Long idProfesor, Long idClase): asigna una clase a un profesor.
 * - findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido): busca profesores por nombre o apellido.
 */
package com.academia.academia.service;

import com.academia.academia.entity.Profesor;
import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<Profesor> obtenerTodos();
    Optional<Profesor> obtenerPorId(Long id);
    Profesor guardarProfesor(Profesor profesor);
    void eliminarProfesor(Long id);
    Optional<Profesor> asignarClase(Long idProfesor, Long idClase);

    List<Profesor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

}
