package domain.entities.club;

import domain.dao.CanchaMapper;

public class Cancha {
    private int id;
    private boolean techada;
    private double precio;

    public Cancha(Boolean techada, double precio) {
        this.techada = techada;
        this.precio = precio;

        CanchaMapper canchaMapper = new CanchaMapper(this.techada, this.precio);
        this.id = canchaMapper.insert();

    }

    public Boolean esTechada() {
        return techada;
    }

    public double getPrecio() {
        return precio;
    }

}
