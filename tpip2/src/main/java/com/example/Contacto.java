package com.example;

import java.util.Collection;
import java.util.Hashtable;

public class Contacto extends Usuario {

    Hashtable<String, Contacto> htpersona = new Hashtable<String, Contacto>( 50);

    public Contacto(String nombre, String apellido, String drCorreo) {
        super(nombre, apellido, drCorreo);
    }

    public void agregarContacto(String correo,Contacto elem){
        htpersona.put(correo, elem);
    }

    public void eliminarContacto(String correo){
        htpersona.remove(correo);
    }
    
    public String imprimir() {
        String imprimir = "concto ";
        for (Contacto recurso : htpersona.values()) {
            imprimir += "" + recurso.imprimir();
        }
        return imprimir;
    }
    public void imprimirContacto() {
        for (Contacto recurso : htpersona.values()) {
            System.out.println(recurso.imprimir());
        }
    }

    public void setHtpersona(Hashtable<String, Contacto> htpersona) {
        this.htpersona = htpersona;
    }
    
    public Object mostrar(String ad){
        return htpersona.get(ad);
    }
}

