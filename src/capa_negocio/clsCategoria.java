package capa_negocio;

import capa_datos.clsJDBC;
import java.sql.*;

public class clsCategoria {
    
    clsJDBC objConectar = new clsJDBC();
    String strSQL;
    ResultSet rs=null;
    
    public ResultSet listarCategorias() throws Exception{
        strSQL = "select * from categoria";
        try{
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e){
            throw new Exception("Error al listar categorias: " +e.getMessage());
        }
    }
    
    public Integer generarCodCategoria() throws Exception{
        strSQL = "select COALESCE(max(codcategoria),0)+1 as codigo from categoria";
        
        try{
            rs = objConectar.consultarBD(strSQL);
            
            while (rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e){
            throw new Exception ("Error al generar codigo de categoria --> " + e.getMessage());
        }
        
        return 0;
    }
    
    public void registrar (int cod, String nom, String desc, boolean vig) throws Exception {
        strSQL = "insert into categoria values (" + cod + ", '" +nom+ "', '" +desc+ "', " + vig + ")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e){
            throw new Exception ("Error al registrar categoria --> " +e.getMessage());
        }
    }
    
    public ResultSet buscarCategoria(Integer cod) throws Exception{
        strSQL = "select * from categoria where codcategoria = " +cod;
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e){
            throw new Exception ("Error al buscar categoria" +e.getMessage());
        }
    }
    
    public void eliminarCategoria(Integer cod) throws Exception{
        strSQL = "delete from categoria where codcategoria = " +cod;
        try{
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e){
            throw new Exception ("Error al eliminar la categoria: " +e.getMessage());
        }
    }
    
    public void darBaja (Integer cod) throws Exception {
        strSQL = "update categoria set vigencia = false where codcategoria = " +cod;
        try{
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e){
            throw new Exception ("Error al cambiar la vigencia de la categoria: "+e.getMessage());
        }
    }
    
    public void modificar(Integer cod, String nom, String desc, Boolean vig) throws Exception{
        strSQL = "update categoria set nomcategoria = '" +nom+ "', descripcion = '" +desc+ "', vigencia = "+vig+ " where codcategoria = " +cod;
        try{
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e){
            throw new Exception ("Error al modificar la categoria: "+e.getMessage());
        }
    }
    
    public Integer obtenerCodigoCategoria (String nom) throws Exception{
        strSQL = "select codcat from categoria where nomcategoria = '" +nom+ "'";
        try{
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()) return rs.getInt("codcategoria");
        } catch (Exception e){
            throw new Exception ("Error al buscar categoria: "+e.getMessage());
        }
        return 0;
    }
    
}
