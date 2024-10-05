
package utp.edu.pe.poo.cuentas;

public enum Plazos {
    unMes(0.01,"Plazo fijo a 30 días"),
    tresMeses(0.012,"Plazo fijo a 90 días"),
    seisMeses(0.03,"Plazo fijo a 180 días"),
    doceMeses(0.05,"Plazo fijo a 360 días");
    private final double tasa;
    private final String descripcion;

    private Plazos(double tasa, String descripcion) {
        this.tasa = tasa;
        this.descripcion = descripcion;
    }

    public double getTasa() {
        return tasa;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
