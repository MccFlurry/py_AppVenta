package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;
import javax.swing.JTable;

public class clsVenta {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;
    Connection con = null;
    Statement sent;

    public Integer generarCodigoVenta() throws Exception {
        strSQL = "select coalesce(max(numventa),0)+1 as codigo from venta";
        try {
            rs = objConectar.consultarBD(strSQL);
            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de venta" + e.getMessage());
        }
        return 0;
    }

    public ResultSet buscarVenta(Integer numVenta) throws Exception {
        strSQL = "SELECT V.*, C.dni, C.ruc FROM venta V "
                + "inner join cliente C on V.codCliente = C.codCliente "
                + "WHERE numVenta=" + numVenta;

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar venta");
        }
    }

    public ResultSet listarDetalleVenta(Integer numVenta) throws Exception {
        strSQL = "SELECT D.*, P.nomProducto FROM detalle D "
                + "inner join Producto P on D.codProducto = P.codProducto "
                + "WHERE numVenta=" + numVenta;

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar detalle");
        }
    }

    public void registrar(String cod, String total, String subtotal, String igv,
            boolean tipo, String cliente, JTable tblDetalle) throws Exception {
        try {
            objConectar.conectar();
            con = objConectar.getCon();
            con.setAutoCommit(false);
            sent = con.createStatement();

            strSQL = "INSERT INTO venta VALUES (" + cod + ", CURRENT_DATE, "
                    + total + ", " + subtotal + ", " + igv + ", " + tipo
                    + ", false, " + cliente + "," + clsFunciones.ID_INICIO_SESION + " );";
            sent.executeUpdate(strSQL);

            int ctd = tblDetalle.getRowCount();
            for (int i = 0; i < ctd; i++) {
                String descuento = tblDetalle.getValueAt(i, 4).toString();

                strSQL = "INSERT INTO detalle VALUES (" + cod + ", "
                        + tblDetalle.getValueAt(i, 0).toString() + ", "
                        + tblDetalle.getValueAt(i, 3).toString() + ", "
                        + tblDetalle.getValueAt(i, 5).toString() + ", "
                        + descuento.substring(0, descuento.length() - 1) + ", "
                        + tblDetalle.getValueAt(i, 6).toString() + ");";
                sent.executeUpdate(strSQL);
            }

            for (int i = 0; i < ctd; i++) {
                strSQL = "UPDATE producto SET stock = stock - "
                        + Integer.parseInt(tblDetalle.getValueAt(i, 3).toString())
                        + " WHERE codProducto = "
                        + Integer.parseInt(tblDetalle.getValueAt(i, 0).toString()) + ";";
                sent.executeUpdate(strSQL);
            }

            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw new Exception("Error al guardar Venta");
        } finally {
            objConectar.desconectar();
        }
    }
}
