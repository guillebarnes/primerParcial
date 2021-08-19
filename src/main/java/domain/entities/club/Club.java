package domain.entities.club;

import domain.entities.club.services.TipoDePago;
import domain.entities.jugador.Jugador;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Club {
    private Ubicacion ubicacion;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cancha> canchas = new ArrayList<>();

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public List<Cancha> getCanchas(){
        return this.canchas;
    }

    public void agregarCancha(Cancha cancha){
        canchas.add(cancha);
    }


    public void recibirReserva(Date fecha, Cancha cancha, List<Jugador> jugadores, TipoDePago tipoDePago){
        Reserva oReserva = new Reserva(fecha, cancha, jugadores, tipoDePago);
        reservas.add(oReserva);
    }
}
