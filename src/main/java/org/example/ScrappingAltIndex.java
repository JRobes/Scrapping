package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrappingAltIndex {
    private static String baseUrl = "https://altindex.com/ticker/";

    private static final String regex = "\\[(\\d+),\\s*(\\d+)\\]";


    public static void getSentimentTicker(String ticker){
        String url = baseUrl + ticker + "/sentiment";
        try {
            // Conectar y obtener el documento HTML de la página
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                    .timeout(5000)
                    .get();
            //System.out.println(doc.body());
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(doc.html());
            // Mapa para almacenar los pares
            Map<Long, Integer> pairsMap = new HashMap<>();

            // Buscar coincidencias y procesarlas
            while (matcher.find()) {
                // Extraer los valores de la coincidencia
                long key = Long.parseLong(matcher.group(1)); // Primer número (long)
                int value = Integer.parseInt(matcher.group(2)); // Segundo número (int)

                // Guardar el par en el mapa
                pairsMap.put(key, value);
            }

            // Imprimir el mapa resultante
            System.out.println("Pares encontrados:");
            for (Map.Entry<Long, Integer> entry : pairsMap.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
