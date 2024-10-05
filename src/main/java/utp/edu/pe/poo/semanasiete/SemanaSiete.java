package utp.edu.pe.poo.semanasiete;

import utp.edu.pe.poo.cliente.Cliente;
import utp.edu.pe.poo.cliente.LecturaCliente;
import utp.edu.pe.poo.cuentas.CuentaOperaciones;
import utp.edu.pe.poo.pantalla.Pantalla;

public class SemanaSiete {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();
        Cliente cliente = new Cliente();
        boolean apagado=true;
        int opcion;
        String[] opciones = {"Crear Cliente [1]",
            "Operaciones [2]","Salir [3]"};
        do{
            opcion = pantalla.Menu(
                    "Cajero automático", opciones);             
            switch(opcion){
                case 1:                    
                    cliente = LecturaCliente.lecturaCliente();
                    break;
                case 2:   
                    CuentaOperaciones.hacerOperaciones(cliente);
                    break;
                case 3:                   
                    apagado=false;
                    break;
            }            
        } while(apagado);
    }
}

/*
 // Upcasting : Suv a Auto
        Auto miAuto = new Suv();
        miAuto.acelerar();                 
        // Downcasting: Vehiculo a Suv
        Suv miSuv = (Suv) miAuto;
        miSuv.conducirFueraCarretera(); 

        // Upcasting: Auto a Vehiculo
        Vehiculo miVehiculo = new Auto();
        miVehiculo.acelerar(); 
        Auto otroAuto = (Auto) miVehiculo;
        otroAuto.tocarBocina(); 

        // Upcasting
        Vehiculo miCamion = new Camion();
        miCamion.acelerar(); 
        // Downcasting
        Camion camionReal = (Camion) miCamion;
        camionReal.cargar(); 
*/


