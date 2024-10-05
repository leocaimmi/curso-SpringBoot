package com.example.CRUD_ALUMNOS.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class Alumno {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Legajo del alumno, generado automáticamente", example = "123")
    private Long legajo;
    @Schema(description = "Nombre del alumno", example = "Juan")
    private String nombre;
    @Schema(description = "Apellido del alumno", example = "Pérez")
    private String apellido;

    @Schema(description = "DNI del alumno", example = "12345678")
    private String dni;//puede contener alguna letra
    @Schema(description = "Correo electrónico del alumno", example = "juan.perez@example.com")
    @Email
    private String email;

    //constructores
    public Alumno() {
        this.nombre = "";
        this.apellido = "";
        this.legajo = null;
        this.dni = "";
    }

    public Alumno(String nombre, String apellido, Long legajo, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.dni = dni;
    }

    //getters y setters

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

    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo=" + legajo +
                ", dni='" + dni + '\'' +
                '}';
    }
}
