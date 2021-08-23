package domain.validador;

import domain.entities.club.Reserva;

public interface CriterioReserva {
    public boolean esValida(Reserva reserva);
}
