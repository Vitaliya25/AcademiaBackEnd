package com.academia.academia.controller;

import com.academia.academia.entity.Alumno;
import com.academia.academia.entity.Clase;
import com.academia.academia.entity.Horario;
import com.academia.academia.service.ClaseService;
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

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
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

//    @PostMapping
//    public Clase createClase(@RequestBody Clase clase) {
//        return claseService.saveClase(clase);
//    }

    @PostMapping
    public Clase createClase(@RequestBody Clase clase) {
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
            claseActualizado.setProfesor(clase.getProfesor());


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

//@PutMapping("/{id}")
//public ResponseEntity<Clase> updateClase(@PathVariable Long id, @RequestBody Clase clase) {
//    Optional<Clase> existingClaseOpt = claseService.getClaseById(id);
//    if (existingClaseOpt.isEmpty()) {
//        return ResponseEntity.notFound().build();
//    }
//
//    Clase claseExistente = existingClaseOpt.get();
//
//    // Actualizar datos básicos
//    claseExistente.setAsignatura(clase.getAsignatura());
//    claseExistente.setCurso(clase.getCurso());
//    claseExistente.setProfesor(clase.getProfesor());
//
//    // Crear mapa de horarios actuales por ID
//    Map<Long, Horario> horariosActuales = claseExistente.getHorarios().stream()
//            .filter(h -> h.getId() != null)
//            .collect(Collectors.toMap(Horario::getId, h -> h));
//
//    List<Horario> nuevosHorarios = new ArrayList<>();
//
//    for (Horario h : clase.getHorarios()) {
//        if (h.getId() != null && horariosActuales.containsKey(h.getId())) {
//            // Actualizar horario existente
//            Horario existente = horariosActuales.get(h.getId());
//            existente.setDia(h.getDia());
//            existente.setHoraInicio(h.getHoraInicio());
//            existente.setHoraFin(h.getHoraFin());
//            nuevosHorarios.add(existente);
//            horariosActuales.remove(h.getId());
//        } else {
//            // Nuevo horario
//            h.setClase(claseExistente); // vincular a la clase actual
//            nuevosHorarios.add(h);
//        }
//    }
//
//    // Eliminar horarios que ya no están
//    for (Horario eliminado : horariosActuales.values()) {
//        eliminado.setClase(null); // desvincular
//    }
//    claseExistente.getHorarios().removeIf(h -> horariosActuales.containsKey(h.getId()));
//
//    // Agregar/actualizar nuevos horarios
//    for (Horario nuevo : nuevosHorarios) {
//        if (!claseExistente.getHorarios().contains(nuevo)) {
//            claseExistente.getHorarios().add(nuevo);
//        }
//    }
//
//    Clase actualizada = claseService.saveClase(claseExistente);
//    return ResponseEntity.ok(actualizada);
//}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return ResponseEntity.noContent().build();
    }

}
