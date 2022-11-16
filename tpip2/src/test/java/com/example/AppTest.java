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

        assertEquals(usuario2,correoPrueba.getPara().iterator().next());

    }
    @Test
    public void pruebaPrimerEnvioDeCorreo_usuario1_A_usuario2()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

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

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

        Usuario usuario3 = new Usuario("Carla", "perez", "calitarperez@gmail.com", new BandejaDeRecibidos());

        Usuario usuario4 = new Usuario("valentina", "regidor", "valenrigi@gmail.com", new BandejaDeRecibidos());

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

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

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

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

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

        Filtro filtro0 = new Filtro("filtro loco");
        filtro0.generarFiltroPorAsunto("mandarCoreo");

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro0));
    }
    @Test
    public void PruebaMostrarCorreoConFiltro_Filtro_Contenido()

    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

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

        Filtro filtro0 = new Filtro("filtro loco");
        filtro0.generarFiltroPorContenido("prueba");

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro0));
    }
    @Test
    public void PruebaMostrarCorreoConFiltro_Filtro_Emisor()
    {
        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

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

        Filtro filtro0 = new Filtro("filtro loco");
        filtro0.generarFiltroPorEmisor(usuario1.getEmail());

        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.comA-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro0));
    }
    @Test
    public void PruebaMostrarCorreoConFiltroDeDosCampos_Filtro_EmisorYAsunto()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);
        Correo correoPrueba1 = new Correo ("Viaje de vacaciones","t7", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));
        correoPrueba1.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));

        usuario1.enviarCorreo(correoPrueba1);

        usuario1.enviarCorreo(correoPrueba);
        
        
        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());

        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());



        Filtro filtro0 = new Filtro("Filtro Por emisor");
        filtro0.generarFiltroPorEmisor("sj@gmail.com");
        Filtro filtro1= new Filtro("Filtro por emisor y asunto");
        filtro1.generarFiltroPorAsuntoYEmisor("mandarCoreo","sj@gmail.com");

        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro0));
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro1));
    }
    @Test
    public void PruebaMostrarCorreoConFiltroDeDosCampos_Filtro_ContenidoYEmisor()

    {

        Usuario usuario1 = new Usuario("joaquin","suarez","sj@gmail.com", new BandejaDeEnvios());

        Usuario usuario2 = new Usuario("andres","briend","andresbriend@gmail.com", new BandejaDeRecibidos());

        GestorContactos contactosUsuario1 = new GestorContactos(usuario1);

        contactosUsuario1.agregar(usuario2);

        Correo correoPrueba = new Correo("mandarCoreo", "prueba", usuario1);
        Correo correoPrueba1 = new Correo ("Viaje de vacaciones","t7", usuario1);

        correoPrueba.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));
        correoPrueba1.para(contactosUsuario1.obtenerUsuario("andresbriend@gmail.com"));

        usuario1.enviarCorreo(correoPrueba1);

        usuario1.enviarCorreo(correoPrueba);
        
        
        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreos());

        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario2.mostrarCorreos());



        Filtro filtro0 = new Filtro("Filtro Por emisor");
        filtro0.generarFiltroPorEmisor("sj@gmail.com");
        Filtro filtro1= new Filtro("Filtro por emisor y asunto");
        filtro1.generarFiltroPorContenidoYEmisor("prueba","sj@gmail.com");

        assertEquals("A-Viaje de vacaciones C-t7 E-suarezjoaquinsj@gmail.comA-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro0));
        assertEquals("A-mandarCoreo C-prueba E-suarezjoaquinsj@gmail.com",usuario1.mostrarCorreosfiltrados(filtro1));
    }

}
