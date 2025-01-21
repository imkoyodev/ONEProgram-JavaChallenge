package com.alura.currency;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApi {


    public MonedasApi tasaDeCambio(String origen, String destino, double valor) {
        String apiKey = "b0128cad8f00d21e8d998629";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"+ origen + "/"
                + destino + "/" + valor;
        HttpResponse<String> response;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedasApi.class);

        } catch (Exception e) {
            throw new RuntimeException("No tengo contizacion existente a USD");
        }


    }
}