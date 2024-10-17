package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsProducto {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public ResultSet listarProductos() throws Exception {
        strSQL = "select P.*, M.nommarca, C.nomcat from producto P "
                + "inner join marca M on P.codmarca = M.codmarca "
                + "inner join categoria C on P.codcategoria = C.codcategoria order by codproducto";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage() + ": Error al consultar productos");
        }
    }

    public Integer generarCodigoProducto() throws Exception {
        strSQL = "select coalesce(max(codproducto),0)+1 as codigo from producto";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo del producto: " + e.getMessage());
        }
        return 0;
    }

    public void registrarProducto(Integer cod, String nom, String des, Double pre, Integer sto, Boolean vig, Integer codmarca, Integer codcat) throws Exception {
        strSQL = "insert into producto values (" + cod + ", '" + nom + "', '" + des + "', " + pre + ", " + sto + ", '" + vig + "', " + codmarca + ", " + codcat + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar producto:" + e.getMessage());
        }
    }

    public ResultSet buscarProducto(Integer cod) throws Exception {
        strSQL = "select P.*, M.nommarca, C.nomcat from producto P "
                + "inner join marca M on P.codmarca = M.codmarca "
                + "inner join categoria C on P.codcategoria = C.codcategoria "
                + "where codproducto = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + ": Error al buscar producto");
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    public void eliminarProducto(Integer cod) throws Exception {
        strSQL = "delete from producto where codproducto = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar producto!: " + e.getMessage());
        }
    }

    public void darBajaProducto(Integer cod) throws Exception {
        strSQL = "update producto set vigencia = false where codproducto = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja un producto" + e.getMessage());
        }
    }

    public void modificarProducto(Integer cod, String nom, String des, Double pre,
            Integer sto, Boolean vig, Integer codMar, Integer codCat) throws Exception {
        strSQL = "update Producto set nomProducto='" + nom + "', descripcion='" + des
                + "', precio=" + pre + ", stock=" + sto + ", vigencia=" + vig
                + ", codMarca=" + codMar + ", codcategoria=" + codCat
                + " where codProducto=" + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar un producto! " + e.getMessage());
        }
    }

    public ResultSet filtrar(String nom) throws Exception {
        strSQL = "SELECT p.*, m.nommarca, c.nomcategoria FROM (SELECT * FROM producto "
                + "WHERE UPPER(nomproducto) LIKE UPPER('%" + nom + "%') AND vigencia=true) p "
                + "INNER JOIN marca m ON p.codmarca = m.codmarca INNER JOIN categoria c "
                + "ON p.codcategoria = c.codcategoria;";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al filtrar productos");
        }
    }
    
    public int getStock(int cod) throws Exception {
        strSQL = "select stock from producto where codproducto = " +cod+ ";";
        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt(strSQL);
            }
        } catch (Exception e){
            throw new Exception ("Error al obtener stock");
        }
        
        return 0;
    }

}
