package com.gestiondeeventos;

public class EventoNoEncontradoException extends Exception {
    public EventoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}