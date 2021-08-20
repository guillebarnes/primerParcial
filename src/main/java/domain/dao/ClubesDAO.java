package domain.dao;

import domain.entities.club.Club;
import domain.entities.club.Ubicacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClubesDAO {
    private Connection conexion;

    public Connection nuevaConexion(){
        Conexion conn = new Conexion();

        return conn.getConnection();
    }

    public List<Club> select(){
        String consulta = "SELECT * FROM club ";

        try{
            this.conexion = nuevaConexion();

            Statement stmt = this.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            List<Club> clubes = new ArrayList<>();
            UbicacionDAO ubicacionDAO = new UbicacionDAO();
            while(rs.next()){
                Club oClub = new Club();
                oClub.setId(rs.getInt("id_club"));

                Ubicacion oUbicacion = ubicacionDAO.select(rs.getInt("id_ubicacion"));

                oClub.setUbicacion(oUbicacion);

                clubes.add(oClub);
            }

            return clubes;
        } catch (SQLException ex){
            System.out.println("Error al consultar");
            return null;
        }
    }
}
