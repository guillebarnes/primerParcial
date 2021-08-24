package domain.entities.jugador.estados;

import domain.entities.jugador.Jugador;

import java.time.LocalDate;

public class Lesionado implements Estado {
    private int diasReposo;
    private LocalDate fechaLesion;
    private String descripcion;

    public Lesionado(int diasReposo, LocalDate fechaLesion, String descripcion) {
        this.diasReposo = diasReposo;
        this.fechaLesion = fechaLesion;
        this.descripcion = descripcion;
    }

    public int getDiasReposo() {
        return diasReposo;
    }

    public void setDiasReposo(int diasReposo) {
        this.diasReposo = diasReposo;
    }

    public LocalDate getFechaLesion() {
        return fechaLesion;
    }

    public void setFechaLesion(LocalDate fechaLesion) {
        this.fechaLesion = fechaLesion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean puedeJugar(Jugador jugador) {
        return this.estaRecuperado();
    }

    @Override
    public void jugarPartido(Jugador jugador) throws Exception {

        String mensaje = jugador.getNombre() + " " + jugador.getApellido() + " " + "esta lesionado";
        throw new Exception(mensaje);
    }

    @Override
    public void descanso(Jugador jugador) {
        if (this.estaRecuperado()) {
            jugador.setEstado(new Descansado());
        }
        jugador.aumentarEnergia(1);
    }

    public LocalDate fechaRecuperacion() {
        return this.fechaLesion.plusDays(diasReposo);
    }

    private boolean estaRecuperado() {
        return fechaRecuperacion().isBefore(LocalDate.now());
    }
}

