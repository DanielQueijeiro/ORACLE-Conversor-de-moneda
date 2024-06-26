package Modelo;

import java.util.Map;

public record DivisaAPI(String base_code, Map<String, Double> conversion_rates){
}
