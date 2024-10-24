package capa_negocio;

import java.sql.*;
import capa_datos.clsJDBC;

public class clsProducto {

    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs = null;

    public Integer generarCodigoProducto() throws Exception {
        strSQL = "select COALESCE (Max(codproducto), 0) + 1 as codigo from producto";

        try {
            rs = objConectar.consultarBD(strSQL);

            while (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar codigo de producto -->" + e.getMessage());
        }
        return 0;
    }

    public void registrarProducto(Integer cod, String nom, String desc, Double precio, Integer stock, Boolean vigen, Integer codmar, Integer codcat) throws Exception {
        strSQL = "insert into producto values ( " + cod + ", '" + nom + "', '" + desc + "', " + precio + ", " + stock + ", '" + vigen + "', " + codmar + ", " + codcat + ")";

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar producto Pipipi -->" + e.getMessage());
        }
    }

    public ResultSet listarProductos() throws Exception {
        strSQL = "select P.*, M.nommarca, C.nomcategoria from producto P inner join marca M on P.codmarca = M.codmarca inner join categoria C on P.codcategoria = C.codcategoria order by codproducto";

        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar categorias -->" + e.getMessage());
        }
    }

    public ResultSet buscarProducto(Integer cod) throws Exception {
        strSQL = "select P.*, M.nommarca, C.nomcategoria from producto P inner join marca M on P.codmarca = M.codmarca inner join categoria C on P.codcategoria = C.codcategoria where P.codproducto = " + cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar producto");
        }
    }

    public void eliminarProducto(Integer cod) throws Exception {
        strSQL = "delete from producto where codproducto = " + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar producto");
        }
    }

    public void darBajaProducto(Integer cod) throws Exception {
        strSQL = "update producto set vigencia = false where codproducto = " + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja al producto -->" + e.getMessage());
        }
    }

    public void modificarProducto(Integer cod, String nom, String desc, Double precio, Integer stock, Boolean vigen, Integer codmar, Integer codcat) throws Exception {
        strSQL = "update producto set nomproducto ='" + nom + "', descripcion = '" + desc + "' precio=" + precio + "' stock=" + stock + "',vigencia = " + vigen + "' codmarca=" + codmar + "' codcategoria = " + codcat + " where codproducto =" + cod;

        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar el producto -->" + e.getMessage());
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
        strSQL = "SELECT stock FROM producto WHERE codproducto = " + cod + ";";

        try {
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw new Exception("Error al filtrar productos");
        }
        return 0;
        }
    
    public ResultSet buscarProducto(int cod) throws Exception {
        strSQL="select F.*, M.nommarca, C.nomcategoria from producto P "
                + "inner join Marca M on P.codmarca=M.codMarca "
                + "inner join Categoria C on P.codCategoria=C.codCategoria "
                + "where codProducto=" + cod;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        }catch(Exception e) {
            throw new Exception(e.getMessage() + ": Error al buscar producto.");
        }
    }
    
    public int getPrecioMax() throws Exception{
        strSQL = "select max(precio) from producto;";
        try{
            rs = objConectar.consultarBD(strSQL);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e){
            throw new Exception ("Error al obtener precios");
        }
        return 0;
    }
    
    public ResultSet filtrarMarca(int marca, String nom, int min, int max) throws Exception {
        strSQL="SELECT p.*, m.nommarca, c.nomcategoria FROM "
                + "(SELECT * FROM producto WHERE codmarca = " + marca
                + "AND UPPER(nomproducto) LIKE UPPER('%" + nom + "%') "
                + "AND precio BETWEEN " + min + " AND " + max + ") p "
                + "INNER JOIN marca m ON p.codmarca = m.codmarca "
                + "INNER JOIN categoria c ON p.codcategoria=c.codcategoria;" ;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch(Exception e) {
            throw new Exception("Error al filtrar productos" + e.getMessage());
        }
    }
    
    public ResultSet filtrarCategoria(int categoria, String nom, int min, int max) throws Exception {
        strSQL="SELECT p.*, m.nommarca, c.nomcategoria FROM "
                + "(SELECT * FROM producto WHERE codcateegoria = " + categoria
                + "AND UPPER(nomproducto) LIKE UPPER('%" + nom + "%') "
                + "AND precio BETWEEN " + min + " AND " + max + ") p "
                + "INNER JOIN marca m ON p.codmarca = m.codmarca "
                + "INNER JOIN categoria c ON p.codcategoria=c.codcategoria;" ;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch(Exception e) {
            throw new Exception("Error al filtrar productos" + e.getMessage());
        }
    }
    
    public ResultSet filtrar(String nom, int min, int max) throws Exception {
        strSQL="SELECT p.*, m.nommarca, c.nomcategoria FROM "
                + "(SELECT * FROM producto WHERE UPPER(nomproducto) "
                + "LIKE UPPER('%" + nom + "%') "
                + "AND precio BETWEEN " + min + " AND " + max + ") p "
                + "INNER JOIN marca m ON p.codmarca = m.codmarca "
                + "INNER JOIN categoria c ON p.codcategoria=c.codcategoria;" ;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch(Exception e) {
            throw new Exception("Error al filtrar productos" + e.getMessage());
        }
    }
    
    public ResultSet filtrar(int marca, int categoria, String nom, int min, int max) throws Exception {
        strSQL="SELECT p.*, m.nommarca, c.nomcategoria FROM "
                + "(SELECT * FROM producto WHERE codmarca = " + marca +
                " AND codcategoria = " + categoria + " "
                + "AND UPPER(nomproducto) LIKE UPPER('%" + nom + "%') "
                + "AND precio BETWEEN " + min + " AND " + max + ") p "
                + "INNER JOIN marca m ON p.codmarca = m.codmarca "
                + "INNER JOIN categoria c ON p.codcategoria=c.codcategoria;" ;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch(Exception e) {
            throw new Exception("Error al filtrar productos" + e.getMessage());
        }
    }

}
