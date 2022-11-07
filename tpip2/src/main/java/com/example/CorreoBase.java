package com.example;

public abstract class CorreoBase {

    private String asunto;
    private String contenido;
    private Usuario emisor;


    public CorreoBase(String asunto, String contenido, Usuario emisor) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.emisor = emisor;
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


    public Usuario getEmisor() {
        return emisor;
    }


    public void setReceptor(Usuario emisor) {
        this.emisor = emisor;
    }
    public String imprimirReceptor(){
        return emisor.getApellido()+""+emisor.getNombre()+""+emisor.getEmail();
    }
    
    
    
}
