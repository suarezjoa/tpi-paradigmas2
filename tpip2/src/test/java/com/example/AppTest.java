package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void CrearUsuarioYImprimir()
    {
        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com", null);

        assertEquals("[Usuario] datos: val,sorty,ssa@gmail.com",usuario2.imprimir());
    }

    @Test
    public void CreaGestorDeUnContactoMasImprimir()
    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", null);

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com", null);

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        assertEquals("[Usuario] datos: val,sorty,ssa@gmail.com",contactosUsuario1.imprimir());

        assertEquals("sorty,val,ssa@gmail.com",contactosUsuario1.datosDeUsuario("ssa@gmail.com"));
    }
    @Test
    public void CreaGestorDeVariosContactosMasImprimirYelSolicitado()
    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com",null);

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com",null);

        Usuario usuario3 = new Usuario("valentira", "regidor", "algo@gmail.com",null);

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);
        contactosUsuario1.agregar(usuario3);

        assertEquals("regidor,valentira,algo@gmail.com",contactosUsuario1.datosDeUsuario("algo@gmail.com"));
    }

    @Test
    public void Requerimiento1_Unusuario_podra_crear_un_Correo_electronico_Y_agregarDestinatarios()

    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", null);

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com", null);

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario2);

        correoPrueba.para(contactosUsuario1.obtenerUsuario(usuario2.getEmail()));

    }
    @Test
    public void pruebaPrimerEnvioDeCorreo_usuario1_A_usuario2()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEvios());

        Usuario usuario2 = new Usuario("val","sorty","ssa@gmail.com", new BandejaDeRecividos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);

        correoPrueba.para(usuario2);

        usuario1.enviarCorreo(correoPrueba);

        assertEquals("mandarCoreopruebasuarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());
        assertEquals("mandarCoreopruebasuarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());

    }


}
