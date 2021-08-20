package domain.entities.club;

import domain.dao.UbicacionMapper;

public class Ubicacion {
    private int id;
    private String provincia;
    private String ciudad;
    private String direccion;
    private int codigoPostal;

    public Ubicacion(String provincia, String ciudad, String direccion, int codigoPostal) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;

        UbicacionMapper ubicacionMapper = new UbicacionMapper(this.provincia, this.ciudad, this.direccion, this.codigoPostal);
        this.id = ubicacionMapper.insert();
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }
}
