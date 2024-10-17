package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsCliente {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarClientes() throws Exception {
        strSQL = "select * from cliente c inner join tipo_cliente t on c.codtipo = t.codtipo";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar clientes: " + e.getMessage());
        }
    }

    public ResultSet listarTipoClientes() throws Exception {
        strSQL = "select * from tipo_cliente";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar tipo cliente: " + e.getMessage());
        }
    }

    public Integer obtenerCodigoTipoCliente(String nom) throws Exception {
        strSQL = "select codtipo from tipo_cliente where nombre = '" + nom + "'";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codtipo");
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar tipo cliente: " + e.getMessage());
        }

        return 0;
    }

    public Integer generarCodigoCliente() throws Exception {
        strSQL = "select coalesce(max(codcliente),0)+1 as codigo from cliente";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt(strSQL);
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de cliente: " + e.getMessage());
        }
        return 0;
    }

    public void registrar(Integer cod, Integer codTipo, String dni, String ruc, String nom, String tel,
            String cor, String dir, Boolean vig) throws Exception {
        String strSQL = "";

        if (codTipo == 1) {
            strSQL = "insert into CLIENTE values(" + cod + ",'" + dni + "',null,'" + nom + "','" + tel + "','" + cor + "','" + dir + "','" + vig + "'," + codTipo + ")";
        }
        if (codTipo == 2) {
            strSQL = "insert into CLIENTE values(" + cod + ",null,'" + ruc + "','" + nom + "','" + tel + "','" + cor + "','" + dir + "','" + vig + "'," + codTipo + ")";
        }
        if (codTipo == 3) {
            strSQL = "insert into CLIENTE values(" + cod + ",'" + dni + "','" + ruc + "','" + nom + "','" + tel + "','" + cor + "','" + dir + "','" + vig + "'," + codTipo + ")";
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar cliente");
        }
    }

    public ResultSet buscarCliente(Integer cod) throws Exception {
        strSQL = "select * from CLIENTE C inner join TIPO_CLIENTE T on C.codTipo = T.codTipo where codCliente = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar cliente");
        }
    }

    public void eliminarCliente(Integer cod) throws Exception {
        strSQL = "delete from CLIENTE where codCliente = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar cliente");
        }
    }

    public void darBajaCliente(Integer cod) throws Exception {
        strSQL = "update CLIENTE set vigencia = false where codCliente = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja al cliente");
        }
    }

    public void modificar(Integer cod, Integer codTipo, String dni, String ruc, String nom, String tel,
            String cor, String dir, Boolean vig) throws Exception {
        strSQL = "";

        if (codTipo == 1) {
            strSQL = "update CLIENTE set codCliente=" + cod + ", dni='" + dni + "', ruc=null, nombres='" + nom + "',"
                    + "telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig + ", codTipo=" + codTipo + " where codCliente=" + cod;
        }
        if (codTipo == 2) {
            strSQL = "update CLIENTE set codCliente=" + cod + ", dni=null, ruc='" + ruc + "', nombres='" + nom + "',"
                    + "telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig + ", codTipo=" + codTipo + " where codCliente=" + cod;
        }
        if (codTipo == 3) {
            strSQL = "update CLIENTE set codCliente=" + cod + ", dni='" + dni + "', ruc='" + ruc + "', nombres='" + nom + "',"
                    + "telefono='" + tel + "', correo='" + cor + "', direccion='" + dir + "', vigencia=" + vig + ", codTipo=" + codTipo + " where codCliente=" + cod;
        }

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar cliente");
        }
    }

}
