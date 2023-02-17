import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class IA1 extends JFrame
{
    public static JTextField date = new JTextField(8);
    public static JTextField weight = new JTextField(4); 
    public static JTextField repetitions = new JTextField(2);
    public static JTextField RPE = new JTextField(2);  
    public static JMenuBar mb=new JMenuBar();
    public static JLabel true1RM = new JLabel("True 1RM");
    public static JLabel rpe1RM = new JLabel("1RM considering RPE");
    public static JMenu menu, submenu;  
    public static JMenuItem i1, i2, i3;
    public static double trueORM;
    public static double rpeORM;
    public static boolean buttonBORM;
    public static boolean buttonBRORM;
    public static boolean buttonSORM;
    public static boolean buttonSRORM;
    public static boolean buttonDORM;
    public static boolean buttonDRORM;
    public IA1(){
        super("One Repetition Maximum Calculator");
        Container a = getContentPane();
        a.setBackground(Color.LIGHT_GRAY);
    }  
    private static class true1RM implements ActionListener{
        public void actionPerformed(ActionEvent e){
            buttonBORM = true; 
            buttonSORM = true;
            buttonDORM = true;
            Calculations reference = new Calculations();
            String Sweight = weight.getText();
            String Srepetitions = repetitions.getText();
            trueORM = reference.true1RM(Sweight, Srepetitions);
            true1RM.setText("True 1RM: " + trueORM + " lbs");
            if(menu.getText() == "Bench Press"){
                IA1RMBench bench = new IA1RMBench();
                try{
                    bench.storevalueBench();
                }
                catch(IOException io){
                }
            }
            if(menu.getText() == "Squat"){
                IA1RMSquat squat = new IA1RMSquat();
                try{
                    squat.storevalueSquat();
                }
                catch(IOException io){
                }
            }
            if(menu.getText() == "Deadlift"){
                IA1RMSquat squat = new IA1RMSquat();
                try{
                    squat.storevalueSquat();
                }
                catch(IOException io){
                }
            }
        }
    }
    private static class rpe1RM implements ActionListener{
        public void actionPerformed(ActionEvent e){
            buttonBRORM = true;
            buttonSRORM = true; 
            buttonDRORM = true;
            Calculations reference = new Calculations();
            String Sweight = weight.getText();
            String Srepetitions = repetitions.getText();
            String SRPE = RPE.getText();
            rpeORM = reference.rpe1RM(Sweight, Srepetitions, SRPE);
            rpe1RM.setText("1RM Considering RPE: " + rpeORM + " lbs");
        }
    }
    private static class rpeDefinition implements ActionListener{
        public void actionPerformed(ActionEvent e){
            IA1 window = new IA1();
            window.setLayout(new GridLayout(4,1));
            window.setBounds(100,100,670,110);
            JLabel title = new JLabel("RPE (Repetitions Precieved Exhaustion):");
            JLabel definition = new JLabel("RPE stands for Repetitions Precieved Exhaustion.");
            JLabel definition2 = new JLabel("It measures how many repetitions you think you ‘could’ have done until you reached failure (10).");
            JLabel definition3 = new JLabel(" For instance if you complete an exercize at RPE 8, it means you ‘could’ do two more repetitions.");
            title.setFont(new Font("Helvetica", Font.BOLD, 15));
            definition.setFont(new Font("Helvetica", Font.ITALIC, 15));
            definition2.setFont(new Font("Helvetica", Font.ITALIC, 15));
            definition3.setFont(new Font("Helvetica", Font.ITALIC, 15));
            window.add(title);
            window.add(definition);
            window.add(definition2);
            window.add(definition3);
            window.setVisible(true);
        }
    }
    private static class viewProgress implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Graph reference = new Graph("Progress" ,
         "Progress");
            reference.createGraph();
        }
    }
    public static class i1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            menu.setText("Bench Press");
        }
    }
    public static class i2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            menu.setText("Squat");
        }
    }
    public static class i3Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            menu.setText("Deadlift");
        }
    }
    public static void main(String[] args){
        IA1 window = new IA1();
        window.setLayout(new GridLayout(10,2));
        window.setBounds(100,100,690,450);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton findTrue1RM = new JButton("Calculate True 1RM");
        findTrue1RM.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JButton findRPE1RM = new JButton("Calculate RPE 1RM");
        findRPE1RM.setFont(new Font("Helvetica", Font.PLAIN, 15));

        JLabel title = new JLabel("One Repetition Maximum Calculator");
        title.setForeground(Color.RED);
        title.setFont(new Font("Helvetica", Font.PLAIN, 20));
        JLabel date_title = new JLabel ("Date:");
        date_title.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JLabel lift_title = new JLabel("Lift:");
        lift_title.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JLabel weight_title = new JLabel ("Weight (lbs):");
        weight_title.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JLabel repetitions_title = new JLabel ("Repetitions (1-7):");
        repetitions_title.setFont(new Font("Helvetica", Font.PLAIN, 15));
        JButton RPE_title = new JButton ("RPE:");
        RPE_title.setFont(new Font("Helvetica", Font.ITALIC, 15));
        true1RM.setFont(new Font("Helvetica", Font.PLAIN, 20));
        true1RM.setForeground(Color.RED);
        rpe1RM.setFont(new Font("Helvetica", Font.PLAIN, 20));
        rpe1RM.setForeground(Color.RED);

        menu = new JMenu("Choose Lift");
        menu.setFont(new Font("Helvetica", Font.ITALIC, 15));
        i1 = new JMenuItem("Bench Press");
        i1.addActionListener(new i1Listener());
        i2 = new JMenuItem("Squat");
        i2.addActionListener(new i2Listener());
        i3 = new JMenuItem("Deadlift");
        i3.addActionListener(new i3Listener());
        menu.add(i1); menu.add(i2); menu.add(i3);  
        mb.add(menu);
        window.setJMenuBar(mb);
        
        JButton ViewProgress = new JButton("View Progress"); 
        ViewProgress.setFont(new Font("Helvetica", Font.PLAIN, 15));
        
        window.add(title);
        window.add(new JLabel(""));
        window.add(date_title);
        window.add(lift_title);
        window.add(date); //new JPanel_date()
        window.add(mb);
        window.add(weight_title);
        window.add(repetitions_title);
        window.add(weight);
        window.add(repetitions);
        window.add(RPE_title);
        window.add(new JLabel(""));
        window.add(RPE);
        window.add(new JLabel(""));
        window.add(findTrue1RM);
        window.add(findRPE1RM);
        window.add(true1RM);
        window.add(rpe1RM);
        window.add(ViewProgress);

        //add action listener to menu to change equation based on which lift is choosen (also save weight with lift type)
        RPE_title.addActionListener(new rpeDefinition());
        findTrue1RM.addActionListener(new true1RM());
        findRPE1RM.addActionListener(new rpe1RM());
        ViewProgress.addActionListener(new viewProgress());
        
        
        window.setVisible(true);
    }
}