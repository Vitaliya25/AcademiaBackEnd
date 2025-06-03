/**
 * Repositorio PagoRepository
 *
 * Interfaz que extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Pago.
 * Proporciona métodos personalizados para realizar consultas específicas:
 *
 * - findByAlumnoId: obtiene todos los pagos asociados a un alumno específico.
 * - findByAlumnoIdAndFechaMensualidad: busca un pago realizado por un alumno para una mensualidad concreta.
 * - findByFechaMensualidad: recupera todos los pagos correspondientes a una fecha de mensualidad determinada.
 **/

package com.academia.academia.repository;

import com.academia.academia.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByAlumnoId(Long alumnoId);

    List<Pago> findByAlumnoIdAndFechaMensualidad(Long alumnoId, LocalDate fechaMensualidad);

    List<Pago> findByFechaMensualidad(LocalDate fechaMensualidad);
}
