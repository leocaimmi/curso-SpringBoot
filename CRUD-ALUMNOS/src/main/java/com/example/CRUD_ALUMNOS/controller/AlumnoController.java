package com.example.CRUD_ALUMNOS.controller;


import com.example.CRUD_ALUMNOS.model.Alumno;
import com.example.CRUD_ALUMNOS.service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;


    //metodo para listar todos los alumnos
    @Operation(summary = "Obtener todos los alumnos", description = "Devuelve una lista de todos los alumnos registrados")

    @GetMapping
    public List<Alumno> listarAlumnos(){
        return alumnoService.obtenerTodosLosAlumnos();
    }
    @Operation(summary = "Obtener un alumno por ID", description = "Devuelve un alumno en base a su legajo")

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Long id){
        return alumnoService.obtenerAlumnoPorId(id)
                .map(alumno -> ResponseEntity.ok(alumno))
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Crear un nuevo alumno", description = "Permite agregar un nuevo alumno a la base de datos")

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno){
        return alumnoService.crearAlumno(alumno);
    }
    @Operation(summary = "Eliminar un alumno", description = "Elimina un alumno en base a su legajo")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id){
         alumnoService.eliminarAlumno(id);
         return ResponseEntity.notFound().build();

    }

}
