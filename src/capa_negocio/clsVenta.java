package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;


public class clsVenta {
    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs=null;
    Connection con=null;
    Statement sent;
    
    
    public Integer generarCodigoVenta() throws Exception {
        strSQL="select coalesce(max(numventa),0)+1 as codigo from venta";
        try {
            rs=objConectar.consultarBD(strSQL);
            while(rs.next()) {
                return rs.getInt("codigo");
            }
        } catch(Exception e) {
            throw new Exception("Error al generar codigo de venta" + e.getMessage());
        }
        return 0;
    }
    
    
}
