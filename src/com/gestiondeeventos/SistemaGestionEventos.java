package com.gestiondeeventos;

import java.util.*;

public class SistemaGestionEventos {
    private Map<String, Evento> eventos;
    private Map<String, Participante> participantes;

    public SistemaGestionEventos() {
        this.eventos = new HashMap<>();
        this.participantes = new HashMap<>();
    }

    public void registrarEvento(String nombre, String descripcion, Date fechaInicio, Date fechaFin) throws IllegalArgumentException {
        if (fechaInicio.after(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.");
        }
        Evento evento = new Evento(nombre, descripcion, fechaInicio, fechaFin);
        eventos.put(nombre, evento);
    }

    public void registrarParticipante(String nombre, String id) {
        Participante participante = new Participante(nombre, id);
        participantes.put(id, participante);
    }

    public void asignarParticipanteAEvento(String idParticipante, String nombreEvento) throws EventoNoEncontradoException, ParticipanteNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        Participante participante = participantes.get(idParticipante);
        if (participante == null) {
            throw new ParticipanteNoEncontradoException("Participante no encontrado.");
        }
        evento.asignarParticipante(participante);
    }

    public void registrarResultado(String nombreEvento, Map<Participante, Integer> posiciones) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        Resultado resultado = new Resultado(posiciones);
        evento.setResultado(resultado);
    }

    public List<Evento> consultarEventos() {
        return new ArrayList<>(eventos.values());
    }

    public List<Participante> consultarParticipantesDeEvento(String nombreEvento) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        return evento.getParticipantes();
    }

    public Resultado consultarResultadoDeEvento(String nombreEvento) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        return evento.getResultado();
    }
}