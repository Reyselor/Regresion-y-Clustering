package com.mycompany.trabajoregresion;
import java.util.ArrayList;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;


public class Cluster {
    
    private int[] nClu;
    
    public SimpleKMeans getCluster(int a, int b) throws Exception {
        LectorCSV lector = new LectorCSV();
        ArrayList<ArrayList<String>> datos = lector.leerCSV();
        
        FastVector fv = new FastVector(2);
        fv.addElement(new Attribute("Temperatura"));
        fv.addElement(new Attribute("Humedad"));
        Instances data = new Instances("dataset", fv, datos.size());
        
        for(int i = 0; i < datos.size(); i++){
            Instance temp = new Instance(2);
            temp.setValue((Attribute)fv.elementAt(0), Float.parseFloat(datos.get(i).get(a)));
            temp.setValue((Attribute)fv.elementAt(1), Float.parseFloat(datos.get(i).get(b)));
            data.add(temp);
        }
        SimpleKMeans skm = new SimpleKMeans();
        skm.setNumClusters(3);
        skm.setPreserveInstancesOrder(true);
        skm.buildClusterer(data);
        
        this.nClu = (int[])skm.getAssignments();
        
        return skm;
    }
    
    public int[] getNClu (){
        return this.nClu;
    }
}
