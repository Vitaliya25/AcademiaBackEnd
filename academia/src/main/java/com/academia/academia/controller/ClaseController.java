package com.academia.academia.controller;

import com.academia.academia.entity.Alumno;
import com.academia.academia.entity.Clase;
import com.academia.academia.entity.Horario;
import com.academia.academia.entity.Profesor;
import com.academia.academia.service.ClaseService;
import com.academia.academia.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private final ClaseService claseService;
    private final ProfesorService profesorService;


//    public ClaseController(ClaseService claseService) {
//        this.claseService = claseService;
//    }

    public ClaseController(ClaseService claseService, ProfesorService profesorService) {
        this.claseService = claseService;
        this.profesorService = profesorService;
    }

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.getAllClases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable Long id) {
        Optional<Clase> clase = claseService.getClaseById(id);
        return clase.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Clase createClase(@RequestBody Clase clase) {
        if (clase.getProfesorId() != null) {
            Profesor profesor = profesorService.obtenerPorId(clase.getProfesorId())
                    .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id " + clase.getProfesorId()));
            clase.setProfesor(profesor);
        }
        // Asegura que cada horario tenga la referencia a esta clase
        for (Horario horario : clase.getHorarios()) {
            horario.setClase(clase);
        }
        return claseService.saveClase(clase);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable Long id, @RequestBody Clase clase) {
        Optional<Clase> existingClase = claseService.getClaseById(id);
        if (existingClase.isPresent()) {
            //clase.setId(id);
            Clase claseActualizado =existingClase.get();
            claseActualizado.setAsignatura(clase.getAsignatura());
            claseActualizado.setCurso(clase.getCurso());

            if (clase.getProfesorId() != null) {
                Profesor profesor = profesorService.obtenerPorId(clase.getProfesorId())
                        .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id " + clase.getProfesorId()));
                claseActualizado.setProfesor(profesor);
            }

//            claseActualizado.setProfesor(clase.getProfesor());


            claseActualizado.getHorarios().clear();
            for (Horario horario : clase.getHorarios()) {
                horario.setClase(claseActualizado);
            }
            claseActualizado.getHorarios().addAll(clase.getHorarios());

            this.claseService.saveClase(claseActualizado);
            return ResponseEntity.ok(claseActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return ResponseEntity.noContent().build();
    }

}
