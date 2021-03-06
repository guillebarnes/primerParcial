package domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn;
    private static final String driver ="com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/prueba";//cambiar a primer_parcial

    public Conexion() {
        conn = null;
        try{
            Class.forName(driver);
            //aca nos conectamos
            conn = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al Conctar" + e);
        }
    }
    //llamo a esta conexion desde cualquier lugar para conectarnos
    public Connection getConnection(){

        return  conn;
    }
    // sirve para desconectarnos de la base de datos
    public void desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada");

        }
    }
}
