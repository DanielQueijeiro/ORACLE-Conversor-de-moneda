package Busqueda;

import Modelo.DivisaAPI;
import Modelo.Divisas;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busqueda {

    public double buscarDivisa(String monedaOriginal, String monedaDestino, Double cantidad) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        String direccion = "https://v6.exchangerate-api.com/v6/1b5826fd02b8d5983922035b/latest/" + monedaOriginal;
        try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        DivisaAPI miDivisaAPI = gson.fromJson(json, DivisaAPI.class);
        Divisas miDivisa = new Divisas(miDivisaAPI);

        return miDivisa.convertir(monedaOriginal, monedaDestino, cantidad);
        }catch (NumberFormatException e){
            System.out.println("Revisar la cantidad ingresada: ");
        return -1;
        }catch (IllegalArgumentException e){
            System.out.println("Revisar las monedas ingresadas: ");
            return -1;
        }


    }
}
