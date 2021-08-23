package domain.entities.club;

import java.util.concurrent.atomic.AtomicInteger;

public class Cancha {
    private AtomicInteger id = new AtomicInteger();
    private boolean techada;
    private double precio;
    private Club club;

    public Cancha() {

    }

    public Cancha(Boolean techada, double precio, Club club) {
        this.techada = techada;
        this.precio = precio;
        this.club = club;

        //CanchaMapper canchaMapper = new CanchaMapper(this.techada, this.precio, this.club.getId());
        //this.id = canchaMapper.insert();

    }

    public boolean isTechada() {
        return techada;
    }

    public void setTechada(boolean techada) {
        this.techada = techada;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getId() {
        return this.id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Boolean esTechada() {
        return techada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Ubicacion getUbicacion() {
        return this.club.getUbicacion();
    }

}
