package com.example;

import java.util.function.Predicate;

public class Filtro {

    private String nombreFiltro;

    private Predicate<Correo> predicado;

    public Filtro(String nombreFiltro, Predicate<Correo> predicado) {
        this.nombreFiltro = nombreFiltro;
        this.predicado = predicado;
    }
    public Filtro(String nombreFiltro) {
        this.nombreFiltro = nombreFiltro;
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }

    public void setNombreFiltro(String nombreFiltro) {
        this.nombreFiltro = nombreFiltro;
    }

    public Predicate<Correo> getPredicado() {
        return predicado;
    }

    public void setPredicado(Predicate<Correo> predicado) {
        this.predicado = predicado;
    }
    
    public Predicate<Correo> generarFiltroPorContenido(String filtro) {
        
        Predicate<Correo> filtroPorContenido = cor -> cor.getContenido().equals(filtro);
        setPredicado(filtroPorContenido);
        return filtroPorContenido;
    }
    public Predicate<Correo> generarFiltroPorEmisor(String filtro) {

        Predicate<Correo> filtroPorRemitente = cor -> cor.getEmisor().getEmail().equals(filtro);
        setPredicado(filtroPorRemitente);
        return filtroPorRemitente;
    }

    public Predicate<Correo> generarFiltroPorAsunto(String argumento){

        Predicate<Correo> filtroPorAsunto = cor -> cor.getAsunto().equals(argumento);
        setPredicado(filtroPorAsunto);
        return filtroPorAsunto;
    }

    public Predicate<Correo> generarFiltroPorAsuntoYEmisor(String argumento0,String argumento1){

        Predicate<Correo> asunto = generarFiltroPorAsunto(argumento0);
        Predicate<Correo> emisor = generarFiltroPorEmisor( argumento1);
        Predicate<Correo> union = asunto.and(emisor);
        setPredicado(union);
        return union;
    }
    public Predicate<Correo> generarFiltroPorContenidoYEmisor(String argumento0,String argumento1){

        Predicate<Correo> contenido = generarFiltroPorContenido(argumento0);
        Predicate<Correo> emisor = generarFiltroPorEmisor( argumento1);
        Predicate<Correo> union = contenido.and(emisor);
        setPredicado(union);
        return union;
    }

}
