package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/farmacia";
    private String user = "root";
    private String pass = "";
    private Connection con;
    public Connection conectar(){
        System.out.println("Conectando…");
        try(java.sql.Connection con = DriverManager.getConnection(url, user,pass)){
            System.out.println("Conectado!!");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}