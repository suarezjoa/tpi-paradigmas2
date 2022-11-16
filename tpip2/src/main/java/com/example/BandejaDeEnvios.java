package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.interfaces.IAccionesBandeja;
import com.example.interfaces.IFiltros;


public class BandejaDeEnvios implements IAccionesBandeja,IFiltros{

    ArrayList<Correo> correosEnviados = new ArrayList<Correo>();

    @Override
    public Predicate<Correo> filtroPorAsunto(String asunto){

        Predicate<Correo> filtroPorAsunto = cor -> cor.getAsunto().equals(asunto);

        return filtroPorAsunto;
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
    public String mostrarCorreosfiltrados(Filtro filtro){
            List<Correo> CorreosListaFiltada = correosEnviados.stream().filter(filtro.getPredicado()).collect(Collectors.toList());
            return mostrarCorreosAUX(CorreosListaFiltada);
    }

    @Override
    public Predicate<Correo> filtroPorContenido(String contenido) {
        
        Predicate<Correo> filtroPorContenido = cor -> cor.getContenido().equals(contenido);
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