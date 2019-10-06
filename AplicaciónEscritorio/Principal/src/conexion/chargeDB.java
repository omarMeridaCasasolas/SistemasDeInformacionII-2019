package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

public class chargeDB {

    public static void main(String[] args) {
        chargeEmpleado();
    }
    private static boolean chargeEmpleado(){
        boolean res;
        Conexion cn = new Conexion();
        res = cn.conectar();
        String url = "insert into empfarmacia (idEmp, nomEmp, apeEmp, ciEmp, fecNacEmp, dirEmp, telEmp, cargoEmp) ";
        String dates;
        dates = "VALUES ('1234567', 'Marcos Cabrera', 'Lopez Oropeza', '9638527', '1973-10-07', 'Av. san roque n/642', '67935428', 'AdministracionFarmacia')";
        cn.update(url+dates);
        dates = "VALUES ('2345678', 'Boris', 'Mendez Rojas', '6385274', '1982-10-07', 'calle el alto n/547', '67926483', 'ControlAlmacen')";
        cn.update(url+dates);
        dates = "VALUES ('3456789', 'Noah Benjamin', 'Petrelli Beneth', '3852741', '1975-10-07', 'Av. siempre viva n/742', '76428428', 'AtencionCliente')";
        cn.update(url+dates);
        cn.desconectar();
        return res;
    }
    
}
