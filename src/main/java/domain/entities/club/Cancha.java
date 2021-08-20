package domain.entities.club;

import domain.dao.CanchaMapper;

public class Cancha {
    private int id;
    private boolean techada;
    private double precio;

    public Cancha(Boolean techada, double precio, int id_club) {
        this.techada = techada;
        this.precio = precio;

        CanchaMapper canchaMapper = new CanchaMapper(this.techada, this.precio, id_club);
        this.id = canchaMapper.insert();

    }

    public int getId() { return this.id; }

    public Boolean esTechada() {
        return techada;
    }

    public double getPrecio() {
        return precio;
    }

}
