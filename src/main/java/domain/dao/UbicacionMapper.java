package domain.dao;

public class UbicacionMapper {
    private String provincia;
    private String ciudad;
    private String direccion;
    private int codigoPostal;

    public UbicacionMapper(String provincia, String ciudad, String direccion, int codigoPostal){
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public int insert(){
        UbicacionDAO ubicacionDAO = new UbicacionDAO();
        return ubicacionDAO.insert(this.provincia, this.ciudad, this.direccion, this.codigoPostal);
    }
}
