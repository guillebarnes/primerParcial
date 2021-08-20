package domain.dao;

import java.sql.*;

public class UbicacionDAO {
    private Connection conexion;

    public Connection nuevaConexion(){
        Conexion conn = new Conexion();

        return conn.getConnection();
    }

    public int insert(String provincia, String ciudad, String direccion, int codigoPostal){
        //INSERT INTO ubicacion (provincia, ciudad, direccion, codigoPostal) VALUES ('provincia', 'ciudad', 'direccion', codigoPostal);
        String consulta = "INSERT INTO ubicacion (provincia, ciudad, direccion, codigoPostal) VALUES ('"+ provincia +"','" + ciudad + "','" + direccion + "'," + codigoPostal + ");";

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
