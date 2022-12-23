package com.estudiantes.service;

import com.estudiantes.model.EstudianteModel;
import com.estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired //Instance class
    EstudianteRepository estudianteRepository;

    //Obtener todos los registros de la tabla
    public ArrayList<EstudianteModel> getAll(){
        return (ArrayList<EstudianteModel>) estudianteRepository.findAll();
    }

    //Obtener registros por id
    public Optional<EstudianteModel> get(long id){
        return estudianteRepository.findById(id);
    }

    //Guardar registro en base de datos
    public EstudianteModel save(EstudianteModel estudianteModel){
        return estudianteRepository.save(estudianteModel);
    }

    //Eliminar registro en base de datos
    public boolean delete(long id){
        try {
            estudianteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public ArrayList<EstudianteModel> consultarDoc(String doc){
        return (ArrayList<EstudianteModel>) estudianteRepository.findBydoc(doc);
    }


}
