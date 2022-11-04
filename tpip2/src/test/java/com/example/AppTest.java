package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void CrearUsuarioYImprimir()
    {
        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com");

        assertEquals("[Usuario] datos: val,sorty,ssa@gmail.com",usuario2.imprimir());
    }

    @Test
    public void CreaGestorDeUnContactoMasImprimir()
    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com");

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com");

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        assertEquals("[Usuario] datos: val,sorty,ssa@gmail.com",contactosUsuario1.imprimir());
    }

    @Test
    public void Requerimiento1_Unusuario_podra_crear_un_Correo_electronico_Y_agregarDestinatarios()

    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com");

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com");

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);


        contactosUsuario1.agregar(usuario2);

        NuevoCorreo correoPrueba = new NuevoCorreo("mandarCoreo", "prueba", usuario2);

        correoPrueba.para(contactosUsuario1.obtener(usuario2.getEmail()));


    }

}
