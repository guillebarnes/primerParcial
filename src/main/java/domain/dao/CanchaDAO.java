package domain.dao;

import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Ubicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanchaDAO {
    private Connection conexion;

    public Connection nuevaConexion(){
        Conexion conn = new Conexion();

        return conn.getConnection();
    }

    public int insert(boolean techada, double precio, int id_club){
        String consulta = "INSERT INTO cancha (techada, precio, id_club) VALUES";
        //INSERT INTO cancha (techada, precio, id_club) VALUES (1, precio, id_club);
        if(techada)
            consulta = consulta + " (" + 1 + ", " + precio + ", " + id_club + ");";
        else
            consulta = consulta + " (" + 0 + ", " + precio + ", " + id_club + ");";

        try {
            this.conexion = nuevaConexion();

            PreparedStatement stmt = this.conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;
        } catch (SQLException ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }
    public List<Cancha> select(int id_club){
        String consulta = "SELECT * FROM cancha WHERE id_club = " + id_club + ";";

        try{
            this.conexion = nuevaConexion();

            Statement stmt = this.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            List<Cancha> canchas = new ArrayList<>();
            UbicacionDAO ubicacionDAO = new UbicacionDAO();
            while(rs.next()){
                Cancha oCancha = new Cancha();
                oCancha.setId(rs.getInt("id_cancha"));
                oCancha.setTechada(rs.getBoolean("techada"));
                oCancha.setPrecio(rs.getDouble("precio"));

                canchas.add(oCancha);

            }
            return canchas;

        } catch (SQLException ex){
            System.out.println("Error al consultar");
            return null;
        }
    }
    public boolean update(int id_cancha, double nuevoPrecio){
        String consulta = "UPDATE cancha SET precio = " + nuevoPrecio + "WHERE id_cancha = " + id_cancha + ";";

        try{
            this.conexion = nuevaConexion();
            PreparedStatement stmt = this.conexion.prepareStatement(consulta);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Error al consultar");
            return false;
        }
    }
}
