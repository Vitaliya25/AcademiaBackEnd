/**
 * Especifica la interfaz que agrupa las operaciones disponibles para trabajar con la entidad Clase.
 * Describe las funciones clave que permiten gestionar las clases, tales como:
 * - Obtener todas las clases
 * - Buscar una clase por su ID
 * - Guardar una nueva clase o actualizar una existente
 * - Eliminar una clase por su ID
 */

package com.academia.academia.service;

import com.academia.academia.entity.Clase;

import java.util.List;
import java.util.Optional;

public interface ClaseService {
    List<Clase> getAllClases();
    Optional<Clase> getClaseById(Long id);
    Clase saveClase(Clase clase);
    void deleteClase(Long id);
}