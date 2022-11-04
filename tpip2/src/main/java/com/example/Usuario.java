package com.example;

import java.util.Hashtable;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String Email;
    
    public Usuario(String nombre, String apellido, String Email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Email = Email;
        
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String imprimir() {
        return "[Usuario] " + "datos: " + this.getNombre()+","+this.getApellido()+","+this.getEmail();

    }
    
}

