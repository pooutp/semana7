
package utp.edu.pe.poo.cuentas;

public class CuentaPlazo extends Cuenta{
    private Plazos tiempoEnMeses;

    public CuentaPlazo(double saldo, String numeroCuenta, 
            Plazos tiempoEnMeses) {
        super(saldo, numeroCuenta);
        this.tiempoEnMeses = tiempoEnMeses;
    }

    @Override
    public boolean transferirCuentaOtroBanco(String numeroCCI, String banco, 
            double montoTransferir) {
        return super.transferirCuentaOtroBanco(numeroCCI, 
                banco, montoTransferir); 
    }

    @Override
    public boolean transferirEntreCuentas(String numeroCuenta, double montoTransferir) {
        return super.transferirEntreCuentas(numeroCuenta, 
                montoTransferir); 
    }

    @Override
    public void abonarCuenta(double montoAbonar) {
        super.abonarCuenta(montoAbonar); 
    }

    @Override
    public boolean retirarCuenta(double montoRetirar) {
        return super.retirarCuenta(montoRetirar); 
    }
    
    public void calcularIntereses(){
        
    }
    
}
