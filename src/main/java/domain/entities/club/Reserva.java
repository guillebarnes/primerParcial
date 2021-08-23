package domain.entities.club;

import domain.entities.club.services.TipoDePago;
import domain.entities.jugador.Jugador;

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

    public Reserva() {

    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Boolean getPagada() {
        return pagada;
    }

    public void setPagada(Boolean pagada) {
        this.pagada = pagada;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(TipoDePago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    private double calcularPrecio(int horasPorJugar) {
        return this.cancha.getPrecio() * horasPorJugar;
    }

    private Ubicacion getUbicacion() {
        return this.cancha.getUbicacion();
    }
}
