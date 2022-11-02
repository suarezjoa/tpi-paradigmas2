package com.example;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String drCorreo;
    
    public Usuario(String nombre, String apellido, String drCorreo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.drCorreo = drCorreo;
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

    public String getDrCorreo() {
        return drCorreo;
    }

    public void setDrCorreo(String drCorreo) {
        this.drCorreo = drCorreo;
    }
    public String imprimir() {
        return "[RecursoMuseo] " + "datos: " + this.getNombre()+this.getApellido()+this.getDrCorreo();

    }
    
}

