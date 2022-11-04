package com.example;

import java.util.Collection;
import java.util.Hashtable;

import com.example.interfaces.Busquedas;

public class GestorContactos{

    Hashtable<String, Usuario> contactos = new Hashtable<String, Usuario>( 50);
    Usuario propietario;


    public GestorContactos(Usuario propietario) {
        this.propietario = propietario;
    }
    
    public Usuario getPropietario(){
        return propietario;
    }

    public void agregar(Usuario usuario){
        contactos.put(usuario.getEmail(), usuario);
    }

    public void eliminar(String correo){
        contactos.remove(correo);
    }
    
    public String imprimir() {
        String imprimir = "";
        for (Usuario u : contactos.values()) {
            imprimir += "" + u.imprimir();
        }
        return imprimir;
    }
    
    public Usuario obtener(String email){
        return contactos.get(email);
    }

    public Hashtable<String, Usuario> getContactos() {
        return contactos;
    }


}

