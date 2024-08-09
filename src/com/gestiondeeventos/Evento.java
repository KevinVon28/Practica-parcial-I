package com.gestiondeeventos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Evento {
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Participante> participantes;
    private Resultado resultado;

    public Evento(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void asignarParticipante(Participante participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
            participante.registrarEvento(this);
        }
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
