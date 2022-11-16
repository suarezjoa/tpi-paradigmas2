package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.interfaces.IAccionesBandeja;
import com.example.interfaces.IFiltros;

public class BandejaDeRecibidos implements IAccionesBandeja,IFiltros{
    
    
    ArrayList<Correo> correosRecividos = new ArrayList<Correo>();
    

    @Override
    public Predicate<Correo> filtroPorAsunto(String asunto){

        Predicate<Correo> filtroPorAsunto = cor -> cor.getAsunto().equals(asunto);

        return filtroPorAsunto;
    }

    @Override
    public void agregarABandeja(Correo correoEnviado) {
        correosRecividos.add(correoEnviado);
    }

    @Override
    public String mostrarCorreos(){
        String imprimir = "";
        for (Correo c : correosRecividos) {
            imprimir += "A-" + c.getAsunto()+" C-"+c.getContenido()+" E-"+c.imprimirEmisor();
        }
        return imprimir;
    }   
    @Override
    public String mostrarCorreosfiltrados(Filtro filtro){
            List<Correo> CorreosListaFiltada = correosRecividos.stream().filter(filtro.getPredicado()).collect(Collectors.toList());
            return mostrarCorreosAUX(CorreosListaFiltada);
    }

    @Override
    public Predicate<Correo> filtroPorContenido(String cotenido) {
        
        Predicate<Correo> filtroPorContenido = cor -> cor.getContenido().equals(cotenido);
        return filtroPorContenido;
    }

    @Override
    public Predicate<Correo> filtroPorEmisor(String emisor) {
        Predicate<Correo> filtroPorRemitente = cor -> cor.getEmisor().getEmail().equals(emisor);
        return filtroPorRemitente;
    }
    @Override
    public String mostrarCorreosAUX(List<Correo> lista){
        String imprimir = "";
        for (Correo c : lista) {
            imprimir += "A-" + c.getAsunto()+" C-"+c.getContenido()+" E-"+c.imprimirEmisor();
        }
        return imprimir;
    }   
}

