package domain.entities.club;

public class Cancha {
    private boolean techada;
    private double precio;

    public Cancha(Boolean techada, double precio) {
        this.techada = techada;
        this.precio = precio;
    }

    public Boolean esTechada() {
        return techada;
    }

    public double getPrecio() {
        return precio;
    }

}
