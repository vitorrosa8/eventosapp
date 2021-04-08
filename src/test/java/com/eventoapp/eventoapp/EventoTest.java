package com.eventoapp.eventoapp;

import static org.junit.jupiter.api.Assertions.*;

import com.eventoapp.models.Evento;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventoTest {

    private static Evento evento;


    @BeforeAll
    public static void iniciaTest() {
        evento = new Evento();
    }

    @BeforeEach
    public void setAtributosTest(){
        evento.setNome("Aniver do Leo");
        evento.setLocal("Parque");
        evento.setData("08-04-2021");
        evento.setHorario("15:00");
    }

    @Test
    public void inserirEvento() {
      
        assertEquals(evento.getNome(), "Aniver do Leo");
        assertEquals(evento.getLocal(), "Parque");
        assertEquals(evento.getData(), "08-04-2021");
        assertEquals(evento.getHorario(), "15:00");
    }

    @Test
    public void nomeVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setNome("");
        });

        String mensageExpected = "Informe o nome";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void nomeNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setNome(null);
        });

        String mensageExpected = "Informe o nome";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void localVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setLocal("");
        });

        String mensageExpected = "Informe o local";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void localNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setLocal(null);
        });

        String mensageExpected = "Informe o local";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void dataVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setData("");
        });

        String mensageExpected = "Informe a data";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void dataNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setData(null);
        });

        String mensageExpected = "Informe a data";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }
    @Test
    public void horarioVazio() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setHorario("");
        });

        String mensageExpected = "Informe o horario";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

    @Test
    public void horarioNull() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            evento.setHorario(null);
        });

        String mensageExpected = "Informe o horario";
        String mensageRecieved = exception.getMessage();

        assertTrue(mensageRecieved.contains(mensageExpected));
    }

}
