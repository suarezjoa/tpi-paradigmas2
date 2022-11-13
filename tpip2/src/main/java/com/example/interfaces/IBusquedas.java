package com.example.interfaces;

import com.example.Usuario;

public interface IBusquedas {
    
    public Usuario obtenerUsuario(String email);

    public String datosDeUsuario(String email);

}
