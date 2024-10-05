
package utp.edu.pe.poo.cuentas;

import java.util.HashMap;
import java.util.Map;
import utp.edu.pe.poo.cliente.Cliente;
import utp.edu.pe.poo.pantalla.LecturaInformacion;
import utp.edu.pe.poo.pantalla.Pantalla;

public class CuentaOperaciones {
    
    private static Pantalla pantalla = new Pantalla(); 
    private static LecturaInformacion lecturaDatos = new LecturaInformacion();
    
    public static void hacerOperaciones( Cliente cliente){
        String[] opciones = {"Crear Cuenta [1]", "Deposito [2]", 
            "Transferencia [3]", "Retiro [4]", 
            "Saldo disponible [5]", "Terminar [6]"};
                
    boolean apagado=true;
    int opcion;
    double valor=0.00;

    do{
        opcion = pantalla.Menu("Operaciones", opciones); 
        switch(opcion){
            case 1:
                crearCuenta(cliente);
                break;
            case 2:   
                realizarAbonos(cliente, valor);
                break;
            case 3:   
                hacerTransferencias(cliente);
                break;
            case 4:                   
                realizarRetiros(cliente, valor);
                break;
             case 5:                   
                System.out.println("Saldo disponible S/: " 
                        +cliente.getCuenta().getSaldo());               
                break;
            case 6:                   
                apagado=false;
                break;
            }            
        } while(apagado);
    }
    
    private static void realizarAbonos(Cliente cliente, double valor){
         valor = lecturaDatos.lecturaDouble("DEPOSITO A LA CUENTA", 
                        "Monto a depositar S/: ");
                cliente.getCuenta().abonarCuenta(valor);
    }
    
    private static void realizarRetiros(Cliente cliente, double valor)
    {
        valor = lecturaDatos.lecturaDouble("RETIRO DE LA CUENTA", 
                        "Monto a retirar S/: ");
                cliente.getCuenta().retirarCuenta(valor);
    }
    
    private static void crearCuenta(Cliente cliente){
        String[] cuentas = {"Cuenta de Ahorros [1]",
            "Cuenta Corriente [2]", "Cuenta Sueldo [3]", "Cuenta Plazo [4]"};
        Map listaCuentas = new HashMap<>();
        listaCuentas.put(1,new CuentaAhorro(0, 
                    "0001-2026-432555"));
        listaCuentas.put(2,new CuentaCorriente(0, 
                    "0002-2026-432555"));
        listaCuentas.put(3, new CuentaSueldo(0, 
                    "0003-2026-432555" ));
        listaCuentas.put(4, new CuentaPlazo(0, 
                    "0004-2026-432555",
                    Plazos.doceMeses));
        int tipoCuenta;
        double valor;
        tipoCuenta = pantalla.Menu("Cuentas", cuentas);
        Cuenta cuenta = (Cuenta)listaCuentas.get(tipoCuenta);
        cliente.crearCuenta(cuenta);
        /*if(tipoCuenta==1){
            cliente.crearCuenta(new CuentaAhorro(0, 
                    "0001-2026-432555"));
        } else if(tipoCuenta==2){
            cliente.crearCuenta(new CuentaCorriente(0, 
                    "0002-2026-432555"));
        }
        else if(tipoCuenta==3){
            cliente.crearCuenta(new CuentaSueldo(0, 
                    "0003-2026-432555" ));
        }
         else if(tipoCuenta==4){
            cliente.crearCuenta(new CuentaPlazo(0, 
                    "0004-2026-432555",
                    Plazos.doceMeses));
        }
        */
        valor = lecturaDatos.lecturaDouble("creando cuenta", 
                "Monto de apertura S/: ");
        //*if(valor>=500
        cliente.getCuenta().abonarCuenta(valor);
        
    }
    
    private static void hacerTransferencias(Cliente cliente){
        String[] transferencias = {"A otra cuenta del banco [1]",
            "A cuenta de otro banco [2]"};
        int destino;
        double valor;
        destino = pantalla.Menu("TRANSFERENCIA", transferencias); 
        if(destino == 1){
            String NumeroCuenta;                    
            NumeroCuenta = lecturaDatos.lecturaString("", 
                    "Ingrese numero cuenta: ");
            valor = lecturaDatos.lecturaDouble("", 
                "Monto a transferir S/: ");
            if(cliente.getCuenta().transferirEntreCuentas(
                    NumeroCuenta, valor) )
                System.out.println("Tranferencia efectuada con éxito");
            else System.out.println("Saldo insuficiente");
        }
        if(destino == 2){
            String CCI;
            String banco;
            CCI = lecturaDatos.lecturaString("", 
                    "Ingrese numero CCI: ");
            banco = lecturaDatos.lecturaString("", 
                    "Ingrese nombre del banco: ");
            valor = lecturaDatos.lecturaDouble("", 
                "Monto a transferir S/: ");
            if(cliente.getCuenta().transferirCuentaOtroBanco(
                    CCI, banco, valor))
                System.out.print("Tranferencia efectuada con éxito");
            else System.out.print("Saldo insuficiente");
        }
    }
}
