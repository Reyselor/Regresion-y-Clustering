package com.mycompany.trabajoregresion;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCSV {
    
    public ArrayList<ArrayList<String>> leerCSV() throws FileNotFoundException, IOException, CsvValidationException{
        
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
        
        String archCSV = "popayan.csv";
        CSVReader csvReader = new CSVReader(new FileReader(archCSV));
        String[] fila = null;
        while((fila = csvReader.readNext()) != null) {
            ArrayList<String> datosTemporal = new ArrayList<String>();
            for(String dato : fila){
                datosTemporal.add(dato);
            }
            if(datosTemporal.get(0).substring(0, 1).matches("[0-9]*")){
                datos.add(datosTemporal);
            }
        }

        csvReader.close();
        
        return datos;
    }   
}