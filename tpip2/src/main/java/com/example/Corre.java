package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Corre extends CorreoBase{

    ArrayList<Usuario> para = new ArrayList<Usuario>();

    public Corre(String asunto, String contenido, Usuario remitente) {
        super(asunto, contenido, remitente);
    }
    
    public void para(Usuario destinatarios){
        para.add(destinatarios);
    }
}
