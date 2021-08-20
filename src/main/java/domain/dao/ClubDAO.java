package domain.dao;

import java.sql.*;

public class ClubDAO {
    private Connection conexion;

    public Connection nuevaConexion(){
        Conexion conn = new Conexion();

        return conn.getConnection();
    }

    public int insert(int id_ubicacion) {
        String consulta = "INSERT INTO club (id_ubicacion) VALUES (" + id_ubicacion + ");";

        try{
            this.conexion = nuevaConexion();

            PreparedStatement stmt = this.conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if(generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;
        }catch(SQLException ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }
}
