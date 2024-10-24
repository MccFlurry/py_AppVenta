package capa_negocio;

import java.sql.*;
import capa_datos.clsJDBC;

public class clsUsuario {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    private String loggedInUsername;

    
    public String login(String usu, String con) throws Exception {
        strSQL = "select nombres || ' ' || ape_paterno || ' ' || ape_materno as nombre_completo from usuario where nom_usuario='" + usu + "' and clave='" + con + "' and estado = true";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                loggedInUsername = rs.getString("nombre_completo");
                System.out.println(loggedInUsername);
                return loggedInUsername;
            }
        } catch (Exception e) {
            throw new Exception("Error al iniciar sesi�n...");
        }
        return "";
    }

    public Boolean validarVigencia(String usu) throws Exception {
        strSQL = "select estado from usuario where nom_usuario ='" + usu + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getBoolean("estado");
            }
        } catch (Exception e) {
            throw new Exception("Error al iniciar sesi�n...");
        }

        return false;
    }
    
    public String getUsername() {
        return loggedInUsername;
    }
}
