package com.example.interfaces;

import java.util.List;

import com.example.Correo;

public interface AccionesBandeja {

    public void agregarABandeja(Correo correoEnviado);

    public String mostrarCorreos();

    public List<Correo> filtroPorAsunto(String filtro);
    
    public String mostrarCorreosfiltados(String filtroString);
    
}
