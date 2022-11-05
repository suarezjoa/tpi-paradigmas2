package com.example;

import java.util.ArrayList;

import com.example.UbicacionCorreo.AccionesCorreo;

public class BandejaDeEvios implements AccionesCorreo{

    ArrayList<Correo> correosEnviados = new ArrayList<Correo>();

    @Override
    public void agregarABandeja(Correo correoEnviado) {
        correosEnviados.add(correoEnviado);
    }
    @Override
    public String mostrarCorreos(){
        String imprimir = "";
        for (Correo c : correosEnviados) {
            imprimir += "" + c.getAsunto()+""+c.getContenido()+""+c.imprimirRemitente();
        }
        return imprimir;
    }
    
}
