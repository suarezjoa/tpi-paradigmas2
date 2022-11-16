package com.example;

import java.util.Hashtable;

import com.example.interfaces.IBusquedas;

public class GestorContactos implements IBusquedas{

    Hashtable<String, Usuario> contactos = new Hashtable<String, Usuario>();
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
    @Override
    public Usuario obtenerUsuario(String email){
        return contactos.get(email);
    }
    @Override
    public String datosDeUsuario(String email){
        return obtenerUsuario(email).getApellido()+","+obtenerUsuario(email).getNombre()+","+obtenerUsuario(email).getEmail();
    }

    public Hashtable<String, Usuario> getContactos() {
        return contactos;
    }
    


}

