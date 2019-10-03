package conexion;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        Connection cn = (Connection) con.conectar();
        Statement st = cn.createStatement();
        st.close();
        cn.close();
    }
    
}
