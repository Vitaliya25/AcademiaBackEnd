/**
 * Implementación del servicio ClaseService
 *
 * Esta clase maneja la lógica de negocio relacionada con las clases,
 * utilizando ClaseRepository para acceder y manipular los datos.
 *
 * Funciones principales:
 * - getAllClases(): devuelve todas las clases disponibles.
 * - getClaseById(Long id): obtiene una clase por su ID.
 * - saveClase(Clase clase): crea o actualiza una clase.
 * - deleteClase(Long id): elimina una clase dado su ID.
 * */

package com.academia.academia.service;

import com.academia.academia.entity.Clase;
import com.academia.academia.repository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImp implements ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseServiceImp(ClaseRepository claseRepository){
        this.claseRepository = claseRepository;
    }

    @Override
    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    @Override
    public Optional<Clase> getClaseById(Long id) {
        return claseRepository.findById(id);
    }

    @Override
    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }

}
