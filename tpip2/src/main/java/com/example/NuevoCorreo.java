package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NuevoCorreo extends Correo{

    ArrayList<Usuario> para = new ArrayList<Usuario>();

    public NuevoCorreo(String asunto, String contenido, Usuario remitente) {
        super(asunto, contenido, remitente);
    }
    
    public void para(Usuario destinatarios){
        para.add(destinatarios);
    }
}
