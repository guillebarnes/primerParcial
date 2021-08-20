package domain.entities.club;

import domain.dao.CanchaMapper;

public class Cancha {
    private int id;
    private boolean techada;
    private double precio;

    public Cancha(){

    }
    public Cancha(Boolean techada, double precio, int id_club) {
        this.techada = techada;
        this.precio = precio;

        CanchaMapper canchaMapper = new CanchaMapper(this.techada, this.precio, id_club);
        this.id = canchaMapper.insert();

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTechada(boolean techada) {
        this.techada = techada;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() { return this.id; }

    public Boolean esTechada() {
        return techada;
    }

    public double getPrecio() {
        return precio;
    }

}
