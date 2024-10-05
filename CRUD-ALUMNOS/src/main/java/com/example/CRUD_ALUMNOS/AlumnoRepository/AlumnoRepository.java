package com.example.CRUD_ALUMNOS.AlumnoRepository;

import com.example.CRUD_ALUMNOS.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
