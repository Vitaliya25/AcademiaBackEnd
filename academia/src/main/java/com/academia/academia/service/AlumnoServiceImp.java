/**
 * Implementación del servicio AlumnoService
 *
 * Esta clase gestiona la lógica de negocio relacionada con los alumnos,
 * usando AlumnoRepository para acceder y manipular los datos.
 *
 * Funciones principales:
 * - obtenerTodos(): devuelve todos los alumnos.
 * - obtenerPorId(Long id): obtiene un alumno por su ID.
 * - guardar(Alumno alumno): crea o actualiza un alumno.
 * - eliminar(Long id): elimina un alumno dado su ID.
 * - findByNombreContainingIgnoreCase(String nombre): busca alumnos por nombre (ignorando mayúsculas).
 * - findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido): busca alumnos por nombre o apellido.
 * - findByCursoContainingIgnoreCase(String curso): busca alumnos por curso.
 * */

package com.academia.academia.service;

import com.academia.academia.entity.Alumno;
import com.academia.academia.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImp implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImp(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    // Obtener todos los alumnos
    @Override
    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    // Obtener un alumno por ID
    @Override
    public Optional<Alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    // Crear o actualizar un alumno
    @Override
    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    // Eliminar un alumno
    @Override
    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<Alumno> findByNombreContainingIgnoreCase(String nombre) {
        return alumnoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Alumno> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre,String apellido) {
        return alumnoRepository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(nombre,apellido);
    }

    @Override
    public List<Alumno> findByCursoContainingIgnoreCase(String curso) {
        return alumnoRepository.findByCursoContainingIgnoreCase(curso);
    }
}