package domain.dao;

public class CanchaMapper {
    private boolean techada;
    private double precio;
    private int id_club;

    public CanchaMapper(boolean techada, double precio, int id_club){
        this.techada = techada;
        this.precio = precio;
        this.id_club = id_club;
    }

    public int insert(){
        CanchaDAO canchaDAO = new CanchaDAO();
        return canchaDAO.insert(this.techada, this.precio, this.id_club);
    }
}
