package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/farmacia";
    private String user = "root";
    private String pass = "";
    public Connection conectar(){
        Connection con = null;
        System.out.println("Conectando…");
        try{
            con = DriverManager.getConnection(url, user,pass);
            System.out.println("Conectado!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}