package model;

public class Traspaso {
    private String placa;
    private String dpiAnterior;
    private String nombreAnterior;
    private String fecha;
    private String dpiNuevo;
    private String nombreNuevo;

    public Traspaso(String placa, String dpiAnterior, String nombreAnterior, String fecha, String dpiNuevo, String nombreNuevo) {
        this.placa = placa;
        this.dpiAnterior = dpiAnterior;
        this.nombreAnterior = nombreAnterior;
        this.fecha = fecha;
        this.dpiNuevo = dpiNuevo;
        this.nombreNuevo = nombreNuevo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDpiAnterior() {
        return dpiAnterior;
    }

    public String getNombreAnterior() {
        return nombreAnterior;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDpiNuevo() {
        return dpiNuevo;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    @Override
    public String toString() {
        return placa + ", " + dpiAnterior + ", " + nombreAnterior + ", " + fecha + ", " + dpiNuevo + ", " + nombreNuevo;
    }
}
