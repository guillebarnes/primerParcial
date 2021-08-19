package domain.entities.club.services;

import domain.entities.club.Reserva;

public class Online extends TipoDePago{

    @Override
    public void execute(Reserva reserva) {
        //Se debe ejecutar algún metodo para que el usuario ingrese su tarjeta y abone el monto de la reserva
        reserva.setPagada(Boolean.TRUE);
    }
}
