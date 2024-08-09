package com.gestiondeeventos;

import java.util.Map;

public class Resultado {
    private Map<Participante, Integer> posiciones;

    public Resultado(Map<Participante, Integer> posiciones) {
        this.posiciones = posiciones;
    }

    // Getters y setters
    public Map<Participante, Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(Map<Participante, Integer> posiciones) {
        this.posiciones = posiciones;
    }

    public Participante getGanador() {
        return posiciones.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
