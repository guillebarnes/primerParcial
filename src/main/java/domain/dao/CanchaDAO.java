package domain.dao;

import java.sql.*;

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
}
