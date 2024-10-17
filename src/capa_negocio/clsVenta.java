package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsVenta {
    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    Connection con = null;
    Statement sent;

    public Integer generarCodigoVenta() throws Exception {
        strSQL = "SELECT COALESCE(max(numventa),0)+1 AS codigo FROM venta;";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de venta");
        }
        return 0;
    }
}