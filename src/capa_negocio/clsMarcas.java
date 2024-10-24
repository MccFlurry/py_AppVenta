package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.ResultSet;

public class clsMarcas {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarMarcas() throws Exception {
        strSQL = "select * from marca";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar marca -->" + e.getMessage());
        }
    }

    public Integer generarCodigoMarca() throws Exception {
        strSQL = "select COALESCE (Max(codmarc), 0) + 1 as codigo from marca";

        try {
            rs = objConectar.consultarBD(strSQL);

            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de marca -->" + e.getMessage());
        }
        return 0;
    }

    public void registrar(int cod, String nom, boolean vigen) throws Exception {
        strSQL = "insert into marca values ( " + cod + ", '" + nom + "', " + vigen + ")";

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar la marca -->" + e.getMessage());
        }
    }

    public ResultSet buscarMarca(Integer cod) throws Exception {
        strSQL = "select * from marca where codMarca = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar marca");
        }
    }

    public void eliminarMarca(Integer cod) throws Exception {
        strSQL = "delete from marca where codMarca = " + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la marca -->" + e.getMessage());
        }
    }

    public void darBaja(Integer cod) throws Exception {
        strSQL = "update marca set vigencia = false where codMarca = " + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja la marca -->" + e.getMessage());
        }
    }

    public void modificar(Integer cod, String nom, boolean vigen) throws Exception {
        strSQL = "update marca set nomMarca ='" + nom + "', vigencia = " + vigen + " where codMarca = " + cod;

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
    
    public Integer obtenerCodigoMarca (String nom) throws Exception {
        strSQL = "select codmarca from marca where nommarca = '" + nom + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) return rs.getInt("codmarca");
        } catch (Exception e) {
            throw new Exception ("Error al buscar marca");
        }
        
        return 0;
    }

}
