
package com.mycompany.trabajoregresion;

import java.util.ArrayList;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.LinearRegression;

public class Regresion {
    
    public LinearRegression getRegresion() throws Exception {
        LectorCSV lector = new LectorCSV();
        ArrayList<ArrayList<String>> datos = lector.leerCSV();
        
        FastVector fv  = new FastVector(2);
        fv.addElement(new Attribute("NumeroCaptura"));
        fv.addElement(new Attribute("Temperatura"));
        Instances dataset = new Instances("dataset",fv, datos.size());
        dataset.setClassIndex(dataset.numAttributes()-1);
        
        for (int i = 0; i < datos.size(); i++) {
            Instance instance = new Instance(2);
            instance.setValue((Attribute)fv.elementAt(0), i+1);
            instance.setValue((Attribute)fv.elementAt(1), Double.parseDouble(datos.get(i).get(1)));
            dataset.add(instance);
        }
        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);
        return lr;
    }
}