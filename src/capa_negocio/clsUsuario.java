package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsUsuario {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    
    public String login(String usu, String con) throws Exception {
        strSQL = "select nombres, ape_paterno, ape_materno from usuario where nom_usuario ='" + usu + "' and clave = '" +con+ "' and estado = true";
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                String nombres = rs.getString("nombres");
                String apPaterno = rs.getString("ape_paterno");
                String apMaterno = rs.getString("ape_materno");
                return nombres + " " + apMaterno + " " +apPaterno;
            }
        }catch (Exception e){
            throw new Exception ("Error al iniciar sesion");
        }
        return "";
    }
    
    public Boolean validarVigencia (String usu) throws Exception{
        strSQL ="select estado from usuario where nom_usuario='" +usu+ "'";
        try{
            rs = objConectar.consultarBD(strSQL);
            while(rs.next()){
                return rs.getBoolean("estado");
            }
        }catch (Exception e){
            throw new Exception ("Error al validar usuario");
        }
        return false;
    }
}
