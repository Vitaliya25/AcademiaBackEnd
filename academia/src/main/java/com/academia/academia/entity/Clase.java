/**
 * Clase Clase
 * Representa la entidad Clase en el sistema de gestión académica.
 * Contiene los atributos de una clase como asignatura y curso, y define
 * las relaciones:
 * - Muchos a Uno con la entidad Profesor (cada clase tiene un profesor).
 * - Uno a Muchos con la entidad Horario (una clase puede tener varios horarios).
 * - Uno a Muchos con la entidad Alumno (una clase puede tener varios alumnos).
 * También tiene un campo transitorio `profesorId` para facilitar la comunicación
 * con el frontend sin incluir el objeto completo del profesor.
 */

package com.academia.academia.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asignatura;
    private String curso;

    @ManyToOne()
    @JoinColumn(name = "profesor_id")
   // @JsonIgnore
    @JsonIgnoreProperties({"clases"})
    private Profesor profesor;

    // Relación con Horario

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Horario> horarios = new ArrayList<>();


    // Relación con Alumnos
    @OneToMany(mappedBy = "clase")
    private List<Alumno> alumnos;


    @Transient
    private Long profesorId;

    public Long getProfesorId() {
        return profesor != null ? profesor.getId() : null;
    }

    public Clase() {
    }

    public Clase(String asignatura, String curso) {
        this.asignatura = asignatura;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setProfesorId(Long profesorId) {
        if (this.profesor == null) {
            this.profesor = new Profesor();
        }
        this.profesor.setId(profesorId);
    }


}
