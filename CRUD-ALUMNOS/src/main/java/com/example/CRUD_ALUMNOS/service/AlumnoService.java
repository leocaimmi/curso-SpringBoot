package com.example.CRUD_ALUMNOS.service;

import com.example.CRUD_ALUMNOS.AlumnoRepository.AlumnoRepository;
import com.example.CRUD_ALUMNOS.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    //atributos
    @Autowired
    private AlumnoRepository alumnoRepository;
    //constructores
   // @Autowired
    //public AlumnoService() {
       /* alumnos.add(new Alumno("Leonardo","AAAAA", (long) (alumnos.size()+1),"12345678"));
        alumnos.add(new Alumno("Constanza","BBBBB", (long) (alumnos.size()+1),"1234567"));
        alumnos.add(new Alumno("Gabriel","CCCCC", (long) (alumnos.size()+1),"123456"));
        alumnos.add(new Alumno("Marcos","DDDDD", (long) (alumnos.size()+1),"12345"));*/

   // }
    //metodos
    //Buscar alumnos por rango de edad y nombre
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
