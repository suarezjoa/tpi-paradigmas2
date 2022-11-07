package com.example;

import java.util.HashSet;
import java.util.Set;


public class Correo extends CorreoBase{

    Set<Usuario> para = new HashSet<Usuario>();

    public Correo(String asunto, String contenido, Usuario remitente) {
        super(asunto, contenido, remitente);
    }

    public void para(Usuario destinatarios){
        para.add(destinatarios);
    }
    
    public int cantidadReceptor(){
        return para.size();
    }

    public Set<Usuario> getPara() {
        return para;
    }   

}
