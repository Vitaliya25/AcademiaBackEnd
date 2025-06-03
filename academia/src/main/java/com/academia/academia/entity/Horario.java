/**
 * Clase Horario
 * Representa entidad Horario en el que se imparte una clase dentro del sistema académico.
 * Incluye el día de la semana, la hora de inicio y fin, y la relación con la entidad Clase.
 * Está relacionada con Clase mediante una relación @ManyToOne, una clase puede
 * tener varios horarios asignados.
 */

package com.academia.academia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private DiaSemana dia; // Ej: "Lunes", "Martes"
    @Enumerated(EnumType.STRING)  // Especifica que se almacenará como String en la base de datos
    private DiaSemana dia;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    // Relación con Clase
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clase_id", nullable = false)
    @JsonBackReference
    private Clase clase;

    public Horario() {
    }

    public Horario(DiaSemana dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @JsonProperty("claseId")
    public Long getClaseId() {
        return clase != null ? clase.getId() : null;
    }
}

