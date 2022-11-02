package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void crearobjeto()
    {
        Contacto usuario1 = new Contacto("joaquin","suarez","sj@gmail.com");

        Contacto usuario2 = new Contacto("val","sorty","ssa@gmail.com");


        usuario1.agregarContacto(usuario2.getDrCorreo(),usuario2);

        usuario1.imprimirContacto();

        assertEquals("true",usuario1.imprimir());
    }
}
