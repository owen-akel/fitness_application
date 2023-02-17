import java.io.*;

public class IA1RMBench
{
    public static File f = null; 
    public static FileWriter fw = null; 
    public static BufferedWriter bw = null; 
    public static PrintWriter pw = null; 
    public static void storevalueBench() throws IOException{
        IA1 reference = new IA1();
        String fileLocation = (System.getProperty("user.home") + "/Desktop");
        String trueORM_bench = String.valueOf(reference.trueORM);
        String rpeORM_bench = String.valueOf(reference.rpeORM);
        
        try{ 
            f = new File (System.getProperty("user.home") + "/Desktop/bench1ROM.txt");
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw); 
            pw = new PrintWriter(bw);

            if(reference.buttonBORM == true){
                pw.println(reference.date.getText() + ":" + trueORM_bench + " lbs\n");
                reference.buttonBORM = false;
            }
            pw.flush();
        } finally {
            try{
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException e){
            }
        }
    }
}
/*
 * Relevant Links; 
 * create text file -- https://www.w3schools.com/java/java_files.asp
 * append text file -- https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html
*/