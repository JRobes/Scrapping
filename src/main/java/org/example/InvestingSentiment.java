package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class InvestingSentiment {
    static String path = "https://es.investing.com/equities/banco-santander";
    public static void main( String[] args) {
        String html = "<div>Basándonos en el rendimiento de los principales indicadores técnicos, podemos concluir que...</div>";

        Document doc = null;
        try {
            doc = Jsoup.connect(path)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                    .timeout(5000)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(doc.title());
        // Buscar todos los elementos <div>
        for (Element div : doc.select("div")) {
            String texto = div.text();
            //System.out.println(texto);
            // Verificar si el texto comienza con la frase deseada
            if (texto.startsWith("Basándonos en el rendimiento de los principales indicadores técnico")) {
                System.out.println("Texto encontrado: " + texto);
            }
        }
    }
}
