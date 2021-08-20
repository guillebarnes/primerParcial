package domain.entities.club;

import domain.dao.ClubMapper;
import domain.entities.club.services.TipoDePago;
import domain.entities.jugador.Jugador;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Club {
    private int id;
    private Ubicacion ubicacion;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cancha> canchas = new ArrayList<>();

    public Club(){

    }

    public Club(Ubicacion ubicacion){
        this.ubicacion = ubicacion;

        ClubMapper clubMapper = new ClubMapper(ubicacion.getId());
        this.id = clubMapper.insert();
    }

    public void setId(int id) { this.id = id; }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public List<Cancha> getCanchas(){
        return this.canchas;
    }

    public int getId() { return this.id; }

    public void agregarCancha(boolean techada, double precio){
        Cancha oCancha = new Cancha(techada, precio, this.id);
        this.canchas.add(oCancha);
    }


    public void recibirReserva(Date fecha, Cancha cancha, List<Jugador> jugadores, TipoDePago tipoDePago){
        Reserva oReserva = new Reserva(fecha, cancha, jugadores, tipoDePago);
        reservas.add(oReserva);
    }
}
