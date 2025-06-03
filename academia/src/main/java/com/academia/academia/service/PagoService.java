/**
 * Interfaz PagoService
 *
 * Define las operaciones principales para gestionar los pagos en el sistema.
 * Proporciona métodos para obtener, guardar y eliminar pagos, así como
 * para consultar pagos filtrados por alumno y fecha de mensualidad.
 *
 * Métodos clave:
 * - obtenerTodos(): obtiene todos los pagos registrados.
 * - obtenerPorId(Long id): obtiene un pago específico por su ID.
 * - guardar(Pago pago): guarda o actualiza un pago.
 * - eliminar(Long id): elimina un pago por su ID.
 * - obtenerPorAlumno(Long alumnoId): obtiene todos los pagos de un alumno.
 * - obtenerPorFechaMensualidad(LocalDate fechaMensualidad): obtiene pagos para una fecha específica.
 * - obtenerPorAlumnoYMensualidad(Long alumnoId, LocalDate fechaMensualidad): filtra pagos por alumno y fecha.
 */

package com.academia.academia.service;

import com.academia.academia.entity.Pago;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> obtenerTodos();
    Optional<Pago> obtenerPorId(Long id);
    Pago guardar(Pago pago);
    void eliminar(Long id);

    List<Pago> obtenerPorAlumno(Long alumnoId);

    List<Pago> obtenerPorFechaMensualidad(LocalDate fechaMensualidad);

    List<Pago> obtenerPorAlumnoYMensualidad(Long alumnoId, LocalDate fechaMensualidad);
}
