package com.alura.currency;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GenerarJson {
    public void  archivo(MonedasApi convertido, String origen, String destino) throws IOException {
        Gson gson = new GsonBuilder().
                setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(origen + "-" + destino + ".json");
        escritura.write(gson.toJson(convertido));
        escritura.close();


    }


}