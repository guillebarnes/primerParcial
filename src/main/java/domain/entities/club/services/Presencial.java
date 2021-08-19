package domain.entities.club.services;

import domain.entities.club.Reserva;

public class Presencial extends TipoDePago {
    @Override
    public void execute(Reserva reserva) {
        reserva.setPagada(Boolean.FALSE);
    }
}
