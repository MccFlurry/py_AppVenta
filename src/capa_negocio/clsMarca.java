package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsMarca {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarMarcas() throws Exception {
        strSQL = "select * from marca";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar marca: " + e.getMessage());
        }
    }

    public Integer generarCodigoMarca() throws Exception {
        strSQL = "select COALESCE(max(codmarca),0)+1 as codigo from marca";

        try {
            rs = objConectar.consultarBD(strSQL);

            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de marca --> " + e.getMessage());
        }

        return 0;
    }

    public void registrar(int cod, String nom, boolean vig) throws Exception {
        strSQL = "insert into Marca values (" + cod + ", '" + nom + "', " + vig + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar marca --> " + e.getMessage());
        }
    }

    public ResultSet buscarMarca(Integer cod) throws Exception {
        strSQL = "select * from marca where codmarca = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar marca" + e.getMessage());
        }
    }

    public void eliminarMarca(Integer cod) throws Exception {
        strSQL = "delete from marca where codmarca = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la marca: " + e.getMessage());
        }
    }

    public void darBaja(Integer cod) throws Exception {
        strSQL = "update marca set vigencia = false where codmarca = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al cambiar la vigencia de la marca: " + e.getMessage());
        }
    }

    public void modificar(Integer cod, String nom, Boolean vig) throws Exception {
        strSQL = "update marca set nommarca = '" + nom + "', vigencia = " + vig + " where codmarca = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar la marca: " + e.getMessage());
        }
    }

    public Integer obtenerCodigoMarca(String nom) throws Exception {
        strSQL = "select codmarca from marca where nommarca = '" + nom + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codmarca");
            }
        } catch (Exception e) {
            throw new Exception("Erorr al buscar marca");
        }
        return 0;
    }
}
