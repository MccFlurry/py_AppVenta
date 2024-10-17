package capa_negocio;

import capa_datos.clsJDBC;

public class clsTransaccion {
    clsJDBC objConectar = new clsJDBC();
    String strSQL, strSQL1, strSQL2, strSQL3;
    
    
    public void ejecutarSentencias() throws Exception {
        try {
            strSQL="insert into marca values(5, 'HP', true);";
            objConectar.ejecutarBD(strSQL);
            strSQL="insert into categoria values(10, 'Parlantes', 'Dispositivos de audio', true);";
            objConectar.ejecutarBD(strSQL);
            strSQL="insert into producto values(15, 'Parlantes Wi', 'Parlantes inhalambricos', 250, 20, true, 5, 10);";
            objConectar.ejecutarBD(strSQL);
        } catch(Exception e) {
            throw new Exception("Error al ejecutar sentencias" + e.getMessage());
        }
    }
    
    public void ejecutarSentenciasTransacciones1() throws Exception {
        try{
            strSQL1="insert into marca values(6, 'Canon', true);";
            strSQL2="insert into categoria values(11, 'Scanner', 'Dispositivos para escaneo', true);";
            strSQL3="insert into producto values(16, 'ImageFormula DR-C240', 'Escaneo color y duplex',  550, 50, true, 6, 11);";
            objConectar.ejecutarBDTransacciones(strSQL1, strSQL2, strSQL3);
        } catch(Exception e) {
            throw new Exception("Error al ejecutar sentencias..." + e.getMessage());
        }
    }
    
    public void ejecutarSentenciasTransacciones2() throws Exception {
        try{
            strSQL1="insert into marca values(7, 'Samsung', true);";
            strSQL2="insert into categoria values(8, 'Visor 3D', 'Dispositivos para visores 3D', true);";
            strSQL3="insert into producto values(17, 'Gear VR', 'escaneo color y duplex',  550, 50, true, 20, 20);";
            objConectar.ejecutarBDTransacciones(strSQL1, strSQL2, strSQL3);
        } catch(Exception e) {
            throw new Exception("Error al ejecutar sentencias..." + e.getMessage());
        }
    }
    
    
}
