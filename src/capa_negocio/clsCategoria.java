package capa_negocio;

import java.sql.*;
import capa_datos.clsJDBC;

public class clsCategoria {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarCategoria() throws Exception {
        strSQL = "select * from categoria";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar categorias -->" + e.getMessage());
        }
    }

    public Integer generarCodigoCategoria() throws Exception {
        strSQL = "select COALESCE (Max(codcategoria), 0) + 1 as codigo from categoria";

        try {
            rs = objConectar.consultarBD(strSQL);

            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de categoria -->" + e.getMessage());
        }
        return 0;
    }

    public void registrar(int cod, String nom, String desc, boolean vigen) throws Exception {
        strSQL = "insert into categoria values ( '" + cod + "', '" + nom + "', '" + desc + "', '" + vigen + "')";

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar la categoria -->" + e.getMessage());
        }
    }

    public ResultSet buscarCategoria(Integer cod) throws Exception {
        strSQL = "select * from marca where codMarca = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar categoria");
        }
    }

    public void eliminarCategoria(Integer cod) throws Exception {
        strSQL = "delete from categoria where codcategoria = " + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la categoria -->" + e.getMessage());
        }
    }

    public void darBaja(Integer cod) throws Exception {
        strSQL = "update categoria set vigencia = false where codCategoria = " + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja la categoria -->" + e.getMessage());
        }
    }

    public void modificar(Integer cod, String nom, String desc, boolean vigen) throws Exception {
        strSQL = "update categoria set nomcategoria ='" + nom + "', descripcion = '" + desc + "',vigencia = " + vigen + " where codCategoria =" + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar la marca -->" + e.getMessage());
        }
    }

    public ResultSet obtenerVigencia(Integer cod) throws Exception {
        strSQL = "select vigencia from marca where codMarca = " + cod;

        try {
            rs = objConectar.consultarBD(strSQL);

            if (rs != null && rs.next()) {
                boolean vigencia = rs.getBoolean("vigencia");
                System.out.println("Vigencia: " + vigencia);
            }

            return rs;

        } catch (Exception e) {
            throw new Exception("Error al obtener la vigencia -->" + e.getMessage());
        }
    }
    
    public Integer obtenerCodigoCategoria (String nom) throws Exception {
        strSQL = "select codcategoria from categoria where nomcategoria = '" + nom + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) return rs.getInt("codcategoria");
        } catch (Exception e) {
            throw new Exception ("Error al buscar categoria");
        }
        
        return 0;
    }
}
