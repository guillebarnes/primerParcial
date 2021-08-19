package domain.dao;

import java.sql.Connection;

public class CanchaDAO {
    private Connection conexion;

    public int insert(boolean techada, double precio){
        String consulta = "INSERT INTO cancha (techada, precio) VALUES";

        if(techada)
            consulta = consulta + " (" + 1 + ", " + precio + ");";
        else
            consulta = consulta + " (" + 0 + ", " + precio + ");";


        return 1;
    }
}
