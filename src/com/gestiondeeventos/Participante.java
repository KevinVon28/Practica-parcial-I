package com.gestiondeeventos;

import java.util.ArrayList;
import java.util.List;

public class Participante extends Persona {
    private List<Evento> eventosRegistrados;

    public Participante(String nombre, String id) {
        super(nombre, id);
        this.eventosRegistrados = new ArrayList<>();
    }

    public List<Evento> getEventosRegistrados() {
        return eventosRegistrados;
    }

    public void registrarEvento(Evento evento) {
        if (!eventosRegistrados.contains(evento)) {
            eventosRegistrados.add(evento);
        }
    }
}
