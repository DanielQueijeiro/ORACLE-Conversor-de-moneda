package Busqueda;

import java.time.LocalDateTime;

public class Conversion {
    private LocalDateTime fecha;
    private String monedaOriginal;
    private String monedaDestino;
    private Double cantidadOriginal;
    private Double cantidadDestino;

    public Conversion( String monedaOriginal, String monedaDestino, Double cantidadOriginal, Double cantidadDestino) {
        this.fecha = LocalDateTime.now();
        this.monedaOriginal = monedaOriginal;
        this.monedaDestino = monedaDestino;
        this.cantidadOriginal = cantidadOriginal;
        this.cantidadDestino = cantidadDestino;
    }

    public String mostrarConversion() {
        return  "Fecha: " + this.fecha
                + "\nMoneda original: " + this.monedaOriginal
                + "\nCantidad original: " + this.cantidadOriginal
                + "\nMoneda destino: " + this.monedaDestino
                + "\nCantidad destino: " + this.cantidadDestino
                + "\n";
    }
}
