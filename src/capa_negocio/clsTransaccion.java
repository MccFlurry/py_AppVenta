package capa_negocio;

import capa_datos.clsJDBC;

public class clsTransaccion {

    clsJDBC objConectar = new clsJDBC();
    String strSQL, strSQL1, strSQL2, strSQL3;

    public void ejecutarSentencias() throws Exception {
        try {
            strSQL = "insert into marca values(8,'HP',true);";
            objConectar.ejecutarBD(strSQL);

            strSQL = "insert into categoria values(5,'Parlantes','Dispositivos de audio',true);";
            objConectar.ejecutarBD(strSQL);

            strSQL = "insert into producto values(8,'Parlantes Wi','Parlantes inalambricos',250,20,true,0.5);";
            objConectar.ejecutarBD(strSQL);

        } catch (Exception e) {
            throw new Exception("Error al ejecutar sentencias...");
        }
    }

    // transaccion valida
    public void ejecutarSentenciasTransacciones1() throws Exception {
        try {
            strSQL1 = "insert into marca values(10,'Canon',true);";
            strSQL2 = "insert into categoria values(10,'Scanner','Dispositivos para escaneo',true);";
            strSQL3 = "insert into producto values(8,'ImageFormula DR-C240','escaneo color y duplex',550,50,true,10,10);";
            objConectar.ejecutarBDTransacciones(strSQL1, strSQL2, strSQL3);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar sentencias...");
        }
    }

    // transaccion invalida
    public void ejecutarSentenciasTransacciones2() throws Exception {
        try {
            strSQL1 = "insert into marca values(11,'Samsung',true);";
            strSQL2 = "insert into categoria values(11,'Visor 3D','Dispositivos par visores 3D',true);";
            strSQL3 = "insert into producto values(11,'Gear VR','escaneo color y duplex',550,50,true,20,20);";
            objConectar.ejecutarBDTransacciones(strSQL1, strSQL2, strSQL3);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar sentencias...");
        }
    }

}
