import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class myFileReader {
    public ArrayList<Double> weightBench = new ArrayList<Double>();
    public ArrayList<String> dateBench = new ArrayList<String>();
    public ArrayList<Double> weightSquat = new ArrayList<Double>();
    public ArrayList<String> dateSquat = new ArrayList<String>();
    public ArrayList<Double> weightDeadlift = new ArrayList<Double>();
    public ArrayList<String> dateDeadlift = new ArrayList<String>();
    public int index = 0; 
    public static File fileBench = new File(System.getProperty("user.home") + "/Desktop/bench1ROM.txt");
    public static File fileSquat = new File(System.getProperty("user.home") + "/Desktop/squat1ROM.txt");
    public static File fileDeadlift = new File(System.getProperty("user.home") + "/Desktop/deadlift1ROM.txt");

    public ArrayList<String> separateDate_Weight(String i){
        ArrayList<String> SDW = new ArrayList<String>();
        String strdate = "";
        String strweight = "";
        int x = 0;
        for(x = x ; x<i.length();){
            if(i.charAt(x) != ':'){
                strdate = strdate + i.charAt(x);
                x++;
            }
            if(i.charAt(x) == ':'){
                break;
            }
        }
        x++;
        for(x = x; x<i.length()-4; x++){
            strweight = strweight + i.charAt(x);
        }
        SDW.add(strweight);
        SDW.add(strdate);
        return SDW;
    }

    public void populateArrayList(Scanner sc, ArrayList<Double> weight, ArrayList<String> date){
        try{
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                if(sc.hasNextLine() != true){
                    break;
                }
                if(i.equals("") && sc.hasNextLine()){
                    i = sc.nextLine();
                }
                ArrayList<String> SDW = separateDate_Weight(i);
                weight.add(round(Double.parseDouble(SDW.get(0)), 2));
                date.add(SDW.get(1));
            }
        }
        catch(Exception e){
            System.out.println(e);  
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void readFile(File a) {
        try {
            Scanner scBench = new Scanner(fileBench);
            Scanner scSquat = new Scanner(fileSquat);
            Scanner scDeadlift = new Scanner(fileDeadlift);

            populateArrayList(scBench, weightBench, dateBench);
            populateArrayList(scSquat, weightSquat, dateSquat);
            populateArrayList(scDeadlift, weightDeadlift, dateDeadlift);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}