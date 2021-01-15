
package vista;

import com.mycompany.trabajoregresion.LectorCSV;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class GraficaCluster {
        
    private int[] nClu;
        
    public GraficaCluster(int[] nClu){
        this.nClu = nClu;
    }
    public ChartPanel generarGrafica1() throws Exception{
        
        XYDataset dataset=crearDataset(1,2);
        JFreeChart chart=ChartFactory.createScatterPlot("Temp vs Humedad","Temperatura", "Humedad", dataset);
        ChartPanel cp=new ChartPanel(chart);
        return cp; 
    }
    public ChartPanel generarGrafica2() throws Exception{
        
        XYDataset dataset=crearDataset(1,3);
        JFreeChart chart=ChartFactory.createScatterPlot("Temp vs Velocidad","Temperatura", "Velocidad", dataset);
        ChartPanel cp=new ChartPanel(chart);
        return cp;
    }
    public XYDataset crearDataset(int a, int b) throws Exception{
        LectorCSV lector = new LectorCSV();
        ArrayList<ArrayList<String>> datos = lector.leerCSV();
        
        XYSeriesCollection dataset=new XYSeriesCollection();
        XYSeries c1=new XYSeries("C1");
        XYSeries c2=new XYSeries("C2");
        XYSeries c3=new XYSeries("C3");
        
        for (int i = 0; i < datos.size(); i++) {
            if(nClu[i]==0){
                c1.add(Float.valueOf(datos.get(i).get(a)),Float.valueOf(datos.get(i).get(b)));
            }else if(nClu[i]==1){
                c2.add(Float.valueOf(datos.get(i).get(a)),Float.valueOf(datos.get(i).get(b)));
            }else{
                c3.add(Float.valueOf(datos.get(i).get(a)),Float.valueOf(datos.get(i).get(b)));
            }
        }
        dataset.addSeries(c1);
        dataset.addSeries(c2);
        dataset.addSeries(c3);
        return dataset; 
    }

}
