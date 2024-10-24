package capa_negocio;

import java.sql.*;
import capa_datos.clsJDBC;

public class clsCliente {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarClientes() throws Exception {
        strSQL = "select * from cliente C inner join TIPO_CLIENTE T on C.codcliente = T.codigo";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar clientes -->" + e.getMessage());
        }
    }

    public ResultSet listarTipoClientes() throws Exception {
        strSQL = "select * from tipo_cliente";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tipo de clientes -->" + e.getMessage());
        }
    }

    public Integer obtenerCodigoTipoCliente(String nom) throws Exception {
        strSQL = "select codigo from tipo_cliente where nombre = '" + nom + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar tipo de cliente");
        }

        return 0;
    }

    public Integer generarCodigoCliente() throws Exception {
        strSQL = "select COALESCE (Max(codcliente), 0) + 1 as codigo from cliente";

        try {
            rs = objConectar.consultarBD(strSQL);

            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de cliente -->" + e.getMessage());
        }
        return 0;
    }

    public void registrar(Integer cod, Integer codTipo, String dni, String ruc, String nom, String tel, String cor, String dir, Boolean vig) throws Exception {
        if (codTipo == 1) {
            strSQL = "insert into cliente values (" + cod + ",'" + dni + "',null,'" + nom + "', '" + tel + "', '" + cor + "', '" + dir + "'," + vig + "," + codTipo + ")";
        }

        if (codTipo == 2) {
            strSQL = "insert into cliente values (" + cod + ",'" + dni + "',null,'" + nom + "', '" + tel + "', '" + cor + "', '" + dir + "'," + vig + "," + codTipo + ")";
        }

        if (codTipo == 3) {
            strSQL = "insert into cliente values (" + cod + ",'" + dni + "',null,'" + nom + "', '" + tel + "', '" + cor + "', '" + dir + "'," + vig + "," + codTipo + ")";
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar cliente");
        }
    }

    public void eliminarCliente(Integer cod) throws Exception {
        strSQL = "delete from cliente where codcliente =" + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar cliente");
        }
    }

    public void darBajaCliente(Integer cod) throws Exception {
        strSQL = "update cliente set vigencia = false where codcliente = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja al cliente");
        }
    }

    public void modificar(Integer cod, Integer codTipo, String dni, String ruc, String nom, String tel, String cor, String dir, Boolean vig) throws Exception {
        strSQL = "";
        if (codTipo == 1) {
            strSQL = "update CLIENTE set codcliente=" + cod + ", dni='" + dni + "', ruc=null, nombres='" + nom + "',"
                    + " telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig
                    + ", codtipo=" + codTipo + " where codcliente=" + cod + ";";
        }

        if (codTipo == 2) {
            strSQL = "update CLIENTE set codcliente=" + cod + ", dni=null, ruc='" + ruc + "', nombres='" + nom + "',"
                    + " telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig
                    + ", codtipo=" + codTipo + " where codcliente=" + cod + ";";
        }

        if (codTipo == 3) {
            strSQL = "update CLIENTE set codcliente=" + cod + ", dni='" + dni + "', ruc='" + ruc + "', nombres='" + nom + "',"
                    + " telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig
                    + ", codtipo=" + codTipo + " where codcliente=" + cod + ";";
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar cliente");
        }
    }

    public ResultSet buscarCliente(Integer cod) throws Exception {
        strSQL = "select * from CLIENTE C inner join TIPO_CLIENTE T on C.codTipo = T.codTipo where codCliente = " + cod + ";";
        try {
            ResultSet rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente");
        }
    }

}
