
package com.mycompany.trabajoregresion;

import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) throws Exception {
        LectorCSV lectorCSV = new LectorCSV();
        ArrayList<ArrayList<String>> alv = lectorCSV.leerCSV();
        for (int i = 0; i < alv.size(); i++) {
            for (int j = 0; j < alv.get(i).size(); j++) {
                System.out.println(alv.get(i).get(j));
            }
        }
        
        /*Regresion r = new Regresion();
        LinearRegression alv = r.getRegresion();
        System.out.println("Resultados: "+alv);
        System.out.println("Coeficientes: "+Arrays.toString(alv.coefficients()));
        
        double[] coef = alv.coefficients();
        double pred = coef[0]*210+coef[2];
        System.out.println(pred);
        /////////////////////////////////////////////////////////////////////////////////
        
        Cluster c = new Cluster();
        SimpleKMeans skm1 = new SimpleKMeans();//Temperatura vs Humedad
        SimpleKMeans skm2 = new SimpleKMeans();//Temperatura vs Velocidad del Viento
        skm1 = c.getCluster(1,2);
        skm2 = c.getCluster(1,3);
        
        System.out.println("Modelo: \n"+skm1);
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////tumadre");
        System.out.println("Modelo: \n"+skm2);*/
    }
}