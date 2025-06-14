package model;

public class Multa {
    private String placa;
    private String fecha;
    private String descripcion;
    private double monto;

    public Multa(String placa, String fecha, String descripcion, double monto) {
        this.placa = placa;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return placa + ", " + fecha + ", " + descripcion + ", " + monto;
    }
}
