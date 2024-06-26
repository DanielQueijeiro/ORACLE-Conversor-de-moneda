package Modelo;

import java.util.Map;

public class Divisas {
    private String nombre;
    private final Map<String, Double> conversiones;

    public Divisas(String nombre, Map<String, Double> conversiones) {
        this.nombre = nombre;
        this.conversiones = conversiones;
    }

    public Divisas(DivisaAPI miDivisaAPI) {
        this.nombre = miDivisaAPI.base_code();
        if(miDivisaAPI.base_code() == null || miDivisaAPI.conversion_rates() == null) {
            throw new IllegalArgumentException("No se encontraron las monedas en la lista de conversiones");
        }
        this.conversiones = miDivisaAPI.conversion_rates();
    }

    public Double convertir(String monedaOriginal, String monedaDestino, Double cantidad) {
        if(!conversiones.containsKey(monedaDestino) || !conversiones.containsKey(monedaOriginal)) {
            throw new IllegalArgumentException("No se encontraron las monedas en la lista de conversiones");
        }

        double tasaDeCambio = conversiones.get(monedaDestino);
        return cantidad * tasaDeCambio;
    }



}
