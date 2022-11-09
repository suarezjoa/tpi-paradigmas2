package com.example;

import java.util.Iterator;

import com.example.interfaces.AccionesBandeja;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String Email;
    private AccionesBandeja bandeja;
    
    public Usuario(String nombre, String apellido, String Email, AccionesBandeja bandeja) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Email = Email;
        this.bandeja = bandeja;
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
    public void enviarCorreo(Correo correoEnviado){

        Iterator<Usuario> iterador = correoEnviado.getPara().iterator();

        while(iterador.hasNext()) {

            iterador.next().bandeja.agregarABandeja(correoEnviado);
            
        }

        bandeja.agregarABandeja(correoEnviado);

    }

    public String mostrarCorreos(){
        return bandeja.mostrarCorreos();
    }
    public String mf(String argumento){
        return bandeja.mostrarCorreosfiltados(argumento);
    }
}

