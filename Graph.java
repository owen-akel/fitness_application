import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.File;
import java.util.ArrayList;

public class Graph extends ApplicationFrame {
    public static myFileReader reference = new myFileReader();
    public static bst treesort = new bst();
    public Graph( String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Date","Weight (lbs)",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( ) {
        ArrayList<dateWeight> Sorted = new ArrayList<dateWeight>();
        Sorted = treesort.sort(reference.dateBench, reference.weightBench);
        treesort.sort(reference.dateSquat, reference.weightSquat);
        treesort.sort(reference.dateDeadlift, reference.weightDeadlift);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 0; 
        int finalIndex = reference.dateBench.size();
        ArrayList<dateWeight> Bench = new ArrayList<dateWeight>();
        ArrayList<dateWeight> Squat = new ArrayList<dateWeight>();
        ArrayList<dateWeight> Deadlift = new ArrayList<dateWeight>();
        for(i = i; i<finalIndex; i++){
            Bench.add(Sorted.get(i));
        }
        for(i = i; i<Sorted.size()-reference.dateDeadlift.size(); i++){
            Squat.add(Sorted.get(i));
        }
        for(i = i; i<Sorted.size(); i++){
            Deadlift.add(Sorted.get(i));
        }
        for(int y = 0; y<Bench.size(); y++){
            dataset.addValue(Bench.get(y).weight, "Bench Press", Bench.get(y).x);
        }
        for(int y = 0; y<Squat.size(); y++){
            dataset.addValue(Squat.get(y).weight, "Squat", Squat.get(y).x);
        }
        for(int y = 0; y<Deadlift.size(); y++){
            dataset.addValue(Deadlift.get(y).weight, "Deadlift", Deadlift.get(y).x);
        }
        return dataset;
    }

    public static void createGraph() {
        reference.readFile(reference.fileBench);
        Graph chart = new Graph(
                "Progress" ,
                "Progress");

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}