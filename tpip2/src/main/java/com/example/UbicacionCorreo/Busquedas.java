package com.example.UbicacionCorreo;

import com.example.Usuario;

public interface Busquedas {
    
    public Usuario obtenerUsuario(String email);

    public String datosDeUsuario(String email);

}
