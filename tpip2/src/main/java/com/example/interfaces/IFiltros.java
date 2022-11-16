package com.example.interfaces;

import java.util.function.Predicate;

import com.example.Correo;

public interface IFiltros {
    
    public Predicate<Correo> filtroPorAsunto(String asunto);

    public Predicate<Correo> filtroPorContenido(String contenido);

    public Predicate<Correo> filtroPorEmisor(String emisor);
    
}
