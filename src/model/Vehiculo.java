package model;

public class Vehiculo implements Comparable<Vehiculo>{
    //Atributos de la clase vehiclos (los datos de cada vehiculo que estan en el txt)
    private String placa;
    private String dpi;
    private String nombre;
    private String marca;
    private String modelo;
    private int anio;
    private int cantidadMultas;
    private int cantidadTraspasos;
    
    //el constructor de la clase
    public Vehiculo(String placa, String dpi, String nombre, String marca, String modelo, int anio, int cantidadMultas, int cantidadTraspasos) {
        this.placa = placa;
        this.dpi = dpi;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cantidadMultas = cantidadMultas;
        this.cantidadTraspasos = cantidadTraspasos;
    }
    
    //Getters (métodos para acceder a los datos)
    public String getPlaca() {
        return placa;
    }

    public String getDpi() {
        return dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public int getCantidadMultas() {
        return cantidadMultas;
    }

    public int getCantidadTraspasos() {
        return cantidadTraspasos;
    }

    @Override
    public String toString() {
        return placa + " - " + dpi + " - " + nombre + " - " + marca + " " + modelo + " (" + anio + ") - " + cantidadMultas + " - " + cantidadTraspasos;
    }
    
    @Override
    public int compareTo(Vehiculo otro) {
        return this.placa.compareTo(otro.placa);
    }
}
