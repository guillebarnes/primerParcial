package domain.dao;

public class ClubMapper {
    private int id_ubicacion;

    public ClubMapper(int id_ubicacion){
        this.id_ubicacion = id_ubicacion;
    }

    public int insert(){
        ClubDAO clubDAO = new ClubDAO();
        return clubDAO.insert(this.id_ubicacion);
    }
}
