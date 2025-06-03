/**
 * Define la interfaz que establece los servicios disponibles para la gestión de la entidad Horario.
 * Incluye las operaciones esenciales para administrar los horarios, tales como:
 * - Obtener todos los horarios
 * - Buscar un horario por su ID
 * - Guardar o actualizar un horario
 * - Eliminar un horario por su ID
 */

package com.academia.academia.service;

import com.academia.academia.entity.Horario;
import java.util.List;
import java.util.Optional;

public interface HorarioService {
    List<Horario> getAllHorarios();
    Optional<Horario> getHorarioById(Long id);
    Horario saveHorario(Horario horario);
    void deleteHorario(Long id);
}