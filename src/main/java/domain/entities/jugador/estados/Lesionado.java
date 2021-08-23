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

    @Override
    public boolean puedeJugar(Jugador jugador) {
        return false;
    }

    @Override
    public void jugarPartido(Jugador jugador) {

    }

    @Override
    public void descanso(Jugador jugador) {
        if (fechaRecuperacion().isBefore(fechaLesion)) {
            jugador.setEstado(new Descansado());
        }
        jugador.aumentarEnergia(1);
    }

    public LocalDate fechaRecuperacion() {
        return this.fechaLesion.plusDays(diasReposo);
    }
}

