package com.gestiondeeventos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SistemaGestionEventos sistema = new SistemaGestionEventos();

        try {
            // Registrar eventos
            sistema.registrarEvento("Maratón", "Carrera de 42km", new Date(), new Date(System.currentTimeMillis() + 3600000));
            sistema.registrarEvento("100m planos", "Carrera de 100m", new Date(), new Date(System.currentTimeMillis() + 1800000));

            // Registrar participantes
            sistema.registrarParticipante("Juan Pérez", "JP001");
            sistema.registrarParticipante("María Gómez", "MG001");
            sistema.registrarParticipante("David Flores", "PG002");

            // Asignar participantes a eventos
            sistema.asignarParticipanteAEvento("JP001", "Maratón");
            sistema.asignarParticipanteAEvento("MG001", "Maratón");
            sistema.asignarParticipanteAEvento("PG002", "Maratón");
            sistema.asignarParticipanteAEvento("JP001","100m planos");
            
            // Registrar resultados
            Map<Participante, Integer> posicionesMaraton = new HashMap<>();
            posicionesMaraton.put(sistema.consultarParticipantesDeEvento("Maratón").get(0), 1);
            posicionesMaraton.put(sistema.consultarParticipantesDeEvento("Maratón").get(1), 2);
            posicionesMaraton.put(sistema.consultarParticipantesDeEvento("Maratón").get(2), 3);
            sistema.registrarResultado("Maratón", posicionesMaraton);

            // Consultar eventos
            System.out.println("Eventos registrados:");
            for (Evento evento : sistema.consultarEventos()) {
                System.out.println(evento.getNombre() + " - " + evento.getDescripcion());
            }

            // Consultar participantes de un evento
            System.out.println("\nParticipantes en Maratón:");
            for (Participante participante : sistema.consultarParticipantesDeEvento("Maratón")) {
                System.out.println(participante.getNombre());
            }

            // Consultar resultados de un evento
            Resultado resultadoMaraton = sistema.consultarResultadoDeEvento("Maratón");
            System.out.println("\nResultados de Maratón:");
            for (Map.Entry<Participante, Integer> entry : resultadoMaraton.getPosiciones().entrySet()) {
                System.out.println(entry.getKey().getNombre() + " - Posición: " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}