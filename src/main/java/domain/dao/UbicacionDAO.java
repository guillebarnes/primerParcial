package domain.dao;

import domain.entities.club.Ubicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public Ubicacion select(int id_ubicacion){
        //SELECT * FROM ubicacion WHERE id_ubicacion2 = 1;
        String consulta = "SELECT * FROM ubicacion WHERE id_ubicacion2 = " + id_ubicacion + ";";//recordar cambiar el id_ubicacion2 por id_ubicacion porque me confundi en la bd de prueba

        try{
            this.conexion = nuevaConexion();

            Statement stmt = this.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            if(rs.next()){
                Ubicacion oUbicacion = new Ubicacion();
                oUbicacion.setId(rs.getInt("id_ubicacion2"));
                oUbicacion.setProvincia(rs.getString("provincia"));
                oUbicacion.setCiudad(rs.getString("ciudad"));
                oUbicacion.setDireccion(rs.getString("direccion"));
                oUbicacion.setCodigoPostal(rs.getInt("codigoPostal"));
                return oUbicacion;
            }
            else
                return null;
        } catch (SQLException ex){
            System.out.println("Error al consultar");
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
