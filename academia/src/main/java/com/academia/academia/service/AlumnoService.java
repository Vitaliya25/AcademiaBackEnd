/**
 * Interfaz AlumnoService
 * Especifica la interfaz que agrupa las operaciones disponibles para trabajar con la entidad Alumno.
 * Describe las funciones clave que permiten manejar la información de los alumnos, tales como:
 * - obtenerTodos(): retorna la lista completa de alumnos.
 * - obtenerPorId(Long id): busca un alumno por su ID.
 * - guardar(Alumno alumno): guarda o actualiza un alumno.
 * - eliminar(Long id): elimina un alumno por su ID.
 *
 * Además, incluye métodos personalizados de búsqueda:
 * - findByNombreContainingIgnoreCase(String s): busca alumnos por nombre, ignorando mayúsculas/minúsculas.
 * - findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido): busca por nombre o apellido.
 * - findByCursoContainingIgnoreCase(String s): busca alumnos por curso.
 */

package com.academia.academia.service;

import com.academia.academia.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> obtenerTodos();
    Optional<Alumno> obtenerPorId(Long id);
    Alumno guardar(Alumno alumno);
    void eliminar(Long id);


    List<Alumno> findByNombreContainingIgnoreCase(String s);

    List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

    List<Alumno> findByCursoContainingIgnoreCase(String s);
}

