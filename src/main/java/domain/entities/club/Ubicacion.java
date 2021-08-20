package domain.entities.club;

import domain.dao.UbicacionMapper;

public class Ubicacion {
    private int id;
    private String provincia;
    private String ciudad;
    private String direccion;
    private int codigoPostal;

    public Ubicacion(){

    }

    public Ubicacion(String provincia, String ciudad, String direccion, int codigoPostal) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;

        UbicacionMapper ubicacionMapper = new UbicacionMapper(this.provincia, this.ciudad, this.direccion, this.codigoPostal);
        this.id = ubicacionMapper.insert();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public int getId() { return this.id; }

    public String getDireccion() { return this.direccion; }
}
