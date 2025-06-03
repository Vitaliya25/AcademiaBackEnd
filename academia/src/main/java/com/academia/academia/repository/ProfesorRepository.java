/**
 * Repositorio ProfesorRepository
 *
 * Interfaz que extiende JpaRepository para realizar operaciones CRUD sobre la entidad Profesor.
 * Incluye  método de búsqueda personalizada:
 * - findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase: permite buscar profesores cuyo nombre
 *   o apellido contenga una determinada cadena de texto, sin importar mayúsculas o minúsculas.
 **/

package com.academia.academia.repository;

import com.academia.academia.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    List<Profesor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

}
