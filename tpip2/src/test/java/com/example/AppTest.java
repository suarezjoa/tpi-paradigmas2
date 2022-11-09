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

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecividos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));

        usuario1.enviarCorreo(correoPrueba);
        
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());

    }
    @Test
    public void pruebaEnviarCorreo_usuario1_A_MuchosUsuarios()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecividos());

        Usuario usuario3 = new Usuario("Carla", "perez", "calitarperez@gmail.com", new BandejaDeRecividos());

        Usuario usuario4 = new Usuario("valentina", "regidor", "valenrigi@gmail.com", new BandejaDeRecividos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);
        contactosUsuario1.agregar(usuario3);
        contactosUsuario1.agregar(usuario4);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));
        correoPrueba.para(contactosUsuario1.obtenerUsuario("calitarperez@gmail.com"));
        correoPrueba.para(contactosUsuario1.obtenerUsuario("valenrigi@gmail.com"));
        
        usuario1.enviarCorreo(correoPrueba);
        
        //assertEquals("mandarCoreo prueba suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com", usuario3.mostrarCorreos());
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com", usuario4.mostrarCorreos());

    }
    @Test
    public void pruebaEnviarMasDeUnCorreo_usuario1_A_usuario2()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecividos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);
        Correo correoPrueba1 = new Correo ("Viaje de vacaciones","t7", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));
        correoPrueba1.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));

        usuario1.enviarCorreo(correoPrueba);
        
        usuario1.enviarCorreo(correoPrueba1);
        
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.comA-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.comA-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());

    }
    @Test
    public void PruebaMostrarCorreoConFiltro_Filtro_Asunto()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecividos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);
        Correo correoPrueba1 = new Correo ("Viaje de vacaciones","t7", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));
        correoPrueba1.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));

        usuario1.enviarCorreo(correoPrueba);
        
        usuario1.enviarCorreo(correoPrueba1);
        
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.comA-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.comA-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());

        String filtroAsunto="mandarCoreo";

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mf(filtroAsunto));
    }

}
