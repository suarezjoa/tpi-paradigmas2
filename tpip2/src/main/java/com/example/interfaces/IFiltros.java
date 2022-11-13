package com.example.interfaces;

import java.util.function.Predicate;

import com.example.Correo;

public interface IFiltros {
    
    public Predicate<Correo> filtroPorAsunto(String argumento);

    public Predicate<Correo> filtroPorContenido(String argumento);

    public Predicate<Correo> filtroPorEmisor(String argumento);
    
}
