package com.estudiantes.repository;

import com.estudiantes.model.EstudianteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteModel, Long> {

    //Query personalizado
    public abstract ArrayList<EstudianteModel> findBydoc(String doc);
}
