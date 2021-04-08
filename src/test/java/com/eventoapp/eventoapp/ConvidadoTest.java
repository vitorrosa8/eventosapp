package com.eventoapp.eventoapp;

import static org.junit.jupiter.api.Assertions.*;

import com.eventoapp.models.Convidado;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvidadoTest {

    private static Convidado convidado;


    @BeforeAll
    public static void iniciaTest() {
        convidado = new Convidado();
    }

    @BeforeEach
    public void setAtributosTest(){
        convidado.setNomeConvidado("Augusto");
        convidado.setCpf("1616");
    }

    @Test
    public void inserirConviado() {
      
        assertEquals(convidado.getNomeConvidado(), "Augusto");
        assertEquals(convidado.getCpf(), "1616");

    }

    @Test
    public void nomeConvidadoVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            convidado.setNomeConvidado("");
        });

        String mensageExpected = "Informe o nome do convidado";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void nomeConvidadoNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            convidado.setNomeConvidado(null);
        });

        String mensageExpected = "Informe o nome do convidado";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void cpfVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            convidado.setCpf("");
        });

        String mensageExpected = "Informe o cpf do convidado";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void cpfNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            convidado.setCpf(null);
        });

        String mensageExpected = "Informe o cpf do convidado";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

}
