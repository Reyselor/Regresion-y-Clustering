package vista;

import com.mycompany.trabajoregresion.LectorCSV;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import weka.classifiers.functions.LinearRegression;

public class GraficaRegresion {
    private LinearRegression lr;
    
    public GraficaRegresion(LinearRegression lr){
        this.lr = lr;
    }
    public ChartPanel generarGrafica() throws IOException, FileNotFoundException, CsvValidationException{
        XYDataset dataset = crearDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Regresion",
            "NumeroCaptura",
            "Temperatura",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);
        ChartPanel cp=new ChartPanel(chart);
        return cp; 
    }
    public XYDataset crearDataset() throws IOException, FileNotFoundException, CsvValidationException{
        LectorCSV lector = new LectorCSV();
        ArrayList<ArrayList<String>> datos = lector.leerCSV();
        
        XYSeries series1 = new XYSeries("Datos Reales");
        XYSeries series2 = new XYSeries("Regresion");
        
        double[] coef = this.lr.coefficients();
        
        for(int i=0; i<datos.size(); i++){
            double pred = coef[0]*i+coef[2];
            series1.add(i+1, Float.valueOf(datos.get(i).get(1)));
            series2.add(i+1, pred);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
}
