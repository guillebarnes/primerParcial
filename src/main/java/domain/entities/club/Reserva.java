package domain.entities.club;

import domain.entities.club.services.TipoDePago;
import domain.entities.jugador.Jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    private Date fecha;
    private Cancha cancha;
    private List<Jugador> jugadores;
    private Boolean pagada;
    private TipoDePago tipoDePago;

    public Reserva(Date fecha, Cancha cancha, List<Jugador> jugadores, TipoDePago tipoDePago) {
        this.fecha = fecha;
        this.cancha = cancha;
        this.jugadores = jugadores;
        this.tipoDePago = tipoDePago;
    }

    public void setPagada(Boolean pagada) {
        this.pagada = pagada;
    }

    private double calcularPrecio(int horasPorJugar){
        return this.cancha.getPrecio() * horasPorJugar;
    }
}
