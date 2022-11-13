package com.example.interfaces;

import java.util.List;
import java.util.function.Predicate;

import com.example.Correo;
import com.example.Filtro;
import com.example.Usuario;

public interface IAccionesBandeja {

    public void agregarABandeja(Correo correoEnviado);

    public String mostrarCorreos();

    public String mostrarCorreosAUX(List<Correo> lista);
    
    public String mostrarCorreosfiltrados( Filtro comoFiltrar);
    
}
