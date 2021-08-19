package domain.dao;

import java.sql.*;

public class CanchaDAO {
    private Connection conexion;

    public Connection nuevaConexion(){
        Connection conexion = null;

        try{
            String connectionUrl = "jdbc:mysql://localhost:3306/primer_parcial";
            conexion = DriverManager.getConnection(connectionUrl, "root", "");

            return conexion;
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            return null;
        }
    }

    public int insert(boolean techada, double precio){
        String consulta = "INSERT INTO cancha (techada, precio) VALUES";

        if(techada)
            consulta = consulta + " (" + 1 + ", " + precio + ");";
        else
            consulta = consulta + " (" + 0 + ", " + precio + ");";

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
