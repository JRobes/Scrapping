package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class App 
{
    public static void main( String[] args )
    {

        //ScrappingAltIndex.getSentimentTicker("nvda");
        //algo para borrar

        int numSamples = 10;
        int numFeatures = 3;
        int sequenceLength = 6;

        // Supongamos que tienes tu array de datos
        String[][] data = new String[numSamples][numFeatures];

        // Rellenar datos simulados
        for (int i = 0; i < numSamples; i++) {
            for (int j = 0; j < numFeatures; j++) {
                data[i][j] = String.valueOf(i) + " " + String.valueOf(j);
            }
        }
        // Escribir los datos en pantalla
        for (int i = 0; i < numSamples; i++) {
            for (int j = 0; j < numFeatures; j++) {
                System.out.print(data[i][j] + "\t\t");
            }
            System.out.println();
        }

        for (int i = 0; i < numSamples - sequenceLength + 1; i++) {
            // Extraer secuencia de características
            String[][] sequenceFeatures = new String[sequenceLength][numFeatures];
            for (int t = 0; t < sequenceLength; t++) {
                sequenceFeatures[t] = data[i + t];
            }
            System.out.println("Una sequence feature: " + i);
            for (int i1 = 0; i1 < sequenceLength ; i1++) {
                for (int j = 0; j < numFeatures; j++) {
                    System.out.print(sequenceFeatures[i1][j] + "\t\t");
                }
                System.out.println();
            }
        }




    }
}
