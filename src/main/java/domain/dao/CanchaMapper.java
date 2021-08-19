package domain.dao;

public class CanchaMapper {
    private boolean techada;
    private double precio;

    public CanchaMapper(boolean techada, double precio){
        this.techada = techada;
        this.precio = precio;
    }

    public int insert(){
        CanchaDAO canchaDAO = new CanchaDAO();
        return canchaDAO.insert(this.techada, this.precio);
    }
}
