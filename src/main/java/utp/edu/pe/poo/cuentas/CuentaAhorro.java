
package utp.edu.pe.poo.cuentas;

public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(double saldo, String numeroCuenta) {
        super(saldo, numeroCuenta);
    }
    
    private final static double INTERES = 0.001;
    
    public void calculoIntereses(){
        super.saldo += super.saldo * (1+CuentaAhorro.INTERES); 
    }
}
