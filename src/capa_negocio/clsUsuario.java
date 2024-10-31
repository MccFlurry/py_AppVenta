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

    public Boolean validarVigencia2(String usu) throws Exception {
        strSQL = "select estado from usuario2 where nomusuario = ?";
        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setString(1, usu);
            rs = sp.executeQuery();
            while (rs.next()) {
                return rs.getBoolean("estado");
            }
            objConectar.desconectar();
        } catch (Exception e) {
            throw new Exception("Error al validar usuario" + e.getMessage());
        }
        return false;
    }

    public void login2(String usu, String con) throws Exception {
        strSQL = "select nombrecompleto, codusuario from usuario2 " + "where nomusuario=? and clave=md5(? || ? || 'FIJO383') and estado=true";
        boolean acceso = false;
        try {
            Connection micon = null;
            objConectar.conectar();
            micon = objConectar.getCon();
            PreparedStatement sp = micon.prepareStatement(strSQL);
            sp.setString(1, usu);
            sp.setString(2, con);
            sp.setString(3, usu);
            ResultSet rs = sp.executeQuery();
            while (rs.next()) {
                clsFunciones.USUARIO_INICIO_SESION = rs.getString("nombrecompleto");
                clsFunciones.ID_INICIO_SESION = rs.getInt("codusuario");
                acceso = true;
            }
            objConectar.desconectar();
        } catch (Exception e) {
            throw new Exception("Error al iniciar sesión.\n" + e.getMessage());
        }
        if (!acceso) {
            clsFunciones.USUARIO_INICIO_SESION = "";
            clsFunciones.ID_INICIO_SESION = -1;
        }
    }

}
