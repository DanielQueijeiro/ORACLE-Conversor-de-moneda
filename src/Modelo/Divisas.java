package Modelo;

import java.util.Map;

public class Divisas {
    private final Map<String, Double> conversiones;


    public Divisas(DivisaAPI miDivisaAPI) {
        String nombre = miDivisaAPI.base_code();
        this.conversiones = miDivisaAPI.conversion_rates();
        if(nombre == null || this.conversiones == null) {
            throw new IllegalArgumentException("No se encontraron las monedas en la lista de conversiones");
        }

    }

    public Double convertir(String monedaOriginal, String monedaDestino, Double cantidad) {
        if(!conversiones.containsKey(monedaDestino) || !conversiones.containsKey(monedaOriginal)) {
            throw new IllegalArgumentException("No se encontraron las monedas en la lista de conversiones");
        }

        double tasaDeCambio = conversiones.get(monedaDestino);
        return cantidad * tasaDeCambio;
    }



}
