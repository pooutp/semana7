package utp.edu.pe.poo.cuentas;

public class Cuenta {
    protected double saldo;
    protected String numeroCuenta;
    protected static final double ITF = 0.00005;
    protected static final double COMISIONINTERBANCARIA = 10;
    
    public Cuenta(double saldo, String numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }
    
   public double getSaldo() {
        return saldo;
    }  
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
        
    protected double cobroITF(double monto){
        return monto * Cuenta.ITF;
    }
    
    public boolean retirarCuenta(double montoRetirar){
        montoRetirar += cobroITF(montoRetirar);       
        if (saldoSuficiente(montoRetirar)) {
            saldo-= montoRetirar;
            return true;
        }
        return false;
    }
    
    protected boolean saldoSuficiente(double montoOperacion){
        return (saldo>= montoOperacion);
    }
    
    public void abonarCuenta(double montoAbonar){       
        saldo+= (montoAbonar-cobroITF(montoAbonar));
    }
    
    public boolean transferirEntreCuentas(String numeroCuenta, 
            double montoTransferir){
        return retirarCuenta(montoTransferir);
    }  
    
    public boolean transferirCuentaOtroBanco(String numeroCCI, 
            String banco, double montoTransferir){
        return retirarCuenta(montoTransferir+Cuenta.COMISIONINTERBANCARIA);
    } 
}