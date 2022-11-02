package com.example;

import java.util.ArrayList;

public abstract class Correo {
    private String asunto;
    private String contenido;
    private Usuario remitente;
    
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    public Correo(String asunto, String contenido, Usuario remitente, ArrayList<Contacto> contactos) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
        this.contactos = contactos;
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

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    
}
