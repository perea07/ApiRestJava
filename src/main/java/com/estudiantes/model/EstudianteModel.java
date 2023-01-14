package com.estudiantes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class EstudianteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar de 1 en 1
    private long id;
    @Column(name = "documento", unique = true, length = 15, nullable = false) //Personalizar un campo en la tabla
    private String doc;

    @Column(length = 40, nullable = false) //Personalizar un campo en la tabla
    private String nombre;

    @Column(length = 60, nullable = false) //Personalizar un campo en la tabla
    private String apellido;

    @Column(length = 200, nullable = false, unique = true) //Personalizar un campo en la tabla
    private String correo;

    public EstudianteModel() {
    }

    public EstudianteModel(long id, String doc, String nombre, String apellido, String correo) {
        this.id = id;
        this.doc = doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public EstudianteModel(String doc, String nombre, String apellido, String correo) {
        this.doc = doc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
