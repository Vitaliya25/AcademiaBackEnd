/**
 * Clase Alumno
 * Esta clase representa la entidad Alumno en la base de datos.
 * Contiene atributos básicos como nombre, apellido, edad, curso, teléfono y email, así como
 * una relación Many-to-One con la entidad Clase.
 * Se usa en el contexto de una aplicación de gestión académica para almacenar y manipular
 * la información de los estudiantes.
 * Incluye:
 * - Anotaciones JPA para definir el mapeo con la base de datos.
 * - Constructor vacío requerido por JPA.
 * - Constructor con parámetros para facilitar la creación de objetos.
 * - Getters y Setters para acceder y modificar los atributos.
 */

package com.academia.academia.entity;
import jakarta.persistence.*;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String apellido;

    private int edad;
    private String curso;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = true)
    private Clase clase;


    public Alumno() {
    }

    public Alumno(String nombre, String apellido, int edad, String curso, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}