package domain.validador;

import domain.entities.club.Reserva;

public class CriterioMinimoJugador implements CriterioReserva {
    private int cantMinimaJugadores;

    public CriterioMinimoJugador(int cantMinimaJugadores) {
        this.cantMinimaJugadores = cantMinimaJugadores;
    }

    @Override
    public boolean esValida(Reserva reserva) {
        return reserva.getJugadores().size() <= cantMinimaJugadores;
    }
}
