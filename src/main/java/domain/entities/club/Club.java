package domain.entities.club;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Club {
    private AtomicInteger id = new AtomicInteger();
    private Ubicacion ubicacion;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Cancha> canchas = new ArrayList<>();

    public Club() {

    }

    public Club(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;

        //ClubMapper clubMapper = new ClubMapper(ubicacion.getId());
        //this.id = clubMapper.insert();
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Cancha> getCanchas() {
        return this.canchas;
    }

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }

    public int getId() {
        return this.id.get();
    }


    public void setId(int id) {
        this.id.set(id);

    }

    public void agregarCancha(boolean techada, double precio) {
        Cancha oCancha = new Cancha(techada, precio, this);
        this.canchas.add(oCancha);
    }


    public void recibirReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void agregarCancha(Cancha cancha) {
        this.canchas.add(cancha);
    }
}
