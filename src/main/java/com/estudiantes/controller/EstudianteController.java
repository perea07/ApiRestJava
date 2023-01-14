package com.estudiantes.controller;

import com.estudiantes.model.EstudianteModel;
import com.estudiantes.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes") //Indicar la ruta general para acceder
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/findAll")
    public ArrayList<EstudianteModel> listarTodos(){
        return estudianteService.getAll();
    }

    @GetMapping(value = "/findById/{id}") //Variable desde la url debe ser id
    public Optional<EstudianteModel> consultarPorId(@PathVariable("id") long id){
        return estudianteService.get(id);
    }

    @PostMapping(value = "/add")
    //@RequestBody capturar datos en formato json (cliente)
    public EstudianteModel registrar(@RequestBody EstudianteModel estudianteModel){
        return estudianteService.save(estudianteModel);
    }

    @PostMapping(value = "/update")
    //@RequestBody capturar datos en formato json (cliente)
    public EstudianteModel actualizar(@RequestBody EstudianteModel estudianteModel){
        return estudianteService.save(estudianteModel);
    }

    @DeleteMapping("delete/{id}")
    //@RequestBody capturar datos en formato json (cliente)
    public ResponseEntity<Object> eliminar(@PathVariable("id") long id){
        boolean res = estudianteService.delete(id);
        Map datos = new HashMap<>();
        datos.put("mensaje", "Datos eliminados con éxito");
        if(!res){
            datos.put("mensaje", "El registro con id " + id + " no existe");
        }
        datos.put("respuesta", res);

        return new ResponseEntity<Object>(datos,HttpStatus.OK);
    }

    @PostMapping(value = "/consultById")
    //@RequestBody capturar datos en formato json (cliente)
    public ArrayList<EstudianteModel> registrar(@RequestBody String doc){
        return estudianteService.consultarDoc(doc);
    }

}
