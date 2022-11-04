package com.example;

import java.util.ArrayList;


public abstract class Correo {

    private String asunto;
    private String contenido;
    private Usuario remitente;


    public Correo(String asunto, String contenido, Usuario remitente) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
    }


    public String getAsunto() {
        return asunto;
    }


    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }


    public String getContenido() {
        return contenido;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    public Usuario getRemitente() {
        return remitente;
    }


    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }
    
    
    
    
}
