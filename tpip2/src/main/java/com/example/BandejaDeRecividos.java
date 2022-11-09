package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.interfaces.AccionesBandeja;

public class BandejaDeRecividos implements AccionesBandeja{
    
    
    ArrayList<Correo> correosEnviados = new ArrayList<Correo>();

    @Override
    public List<Correo> filtroPorAsunto(String argumento){

        Predicate<Correo> filtroPorAsunto = cor -> cor.getAsunto().equals(argumento);

        List<Correo> CorreosListaFiltada = correosEnviados.stream().filter(filtroPorAsunto).collect(Collectors.toList());

        return CorreosListaFiltada;
    }

    @Override
    public void agregarABandeja(Correo correoEnviado) {
        correosEnviados.add(correoEnviado);
    }

    @Override
    public String mostrarCorreos(){
        String imprimir = "";
        for (Correo c : correosEnviados) {
            imprimir += "A-" + c.getAsunto()+" C-"+c.getContenido()+" E-"+c.imprimirEmisor();
        }
        return imprimir;
    }   
    @Override
    public String mostrarCorreosfiltados(String argumento){

        String imprimir = "";
        for (Correo c : filtroPorAsunto(argumento)) {
            imprimir += "A-" + c.getAsunto()+" C-"+c.getContenido()+" E-"+c.imprimirEmisor();
        }
        return imprimir;
    }
    
}


