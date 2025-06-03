/**
 * Repositorio AlumnoRepository
 *
 * Interfaz que extiende JpaRepository para proporcionar operaciones CRUD sobre la entidad Alumno.
 * Incluye métodos personalizados para realizar búsquedas filtradas:
 *
 * - findByNombreContainingIgnoreCase: busca alumnos cuyo nombre contenga la cadena indicada, sin distinguir mayúsculas/minúsculas.
 * - findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase: busca por coincidencia parcial en nombre o apellido.
 * - findByCursoContainingIgnoreCase: busca alumnos por coincidencia parcial en el nombre del curso.
 **/

package com.academia.academia.repository;

import com.academia.academia.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> findByNombreContainingIgnoreCase(String nombre);

    List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

    List<Alumno> findByCursoContainingIgnoreCase(String curso);

}
