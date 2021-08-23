package domain.validador;

import domain.entities.club.Reserva;
import domain.entities.jugador.Jugador;

public class CriterioEstadoJugadores implements CriterioReserva {

    @Override
    public boolean esValida(Reserva reserva) {
        return reserva.getJugadores().stream().allMatch(Jugador::puedeJugar);
    }
}
