package domain.entities.club;

public class Ubicacion {
    private String provincia;
    private String ciudad;
    private String direccion;
    private int codigoPostal;

    public Ubicacion(String provincia, String ciudad, String direccion, int codigoPostal) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
}
