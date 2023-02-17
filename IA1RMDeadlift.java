import java.io.*;

public class IA1RMDeadlift
{
    public static void storevalueDeadlift() throws IOException{
        IA1 reference = new IA1();
        String fileLocation = (System.getProperty("user.home") + "/Desktop");
        String trueORM_deadlift = String.valueOf(reference.trueORM);
        String rpeORM_deadlift = String.valueOf(reference.rpeORM);

        File f = null; 
        FileWriter fw = null; 
        BufferedWriter bw = null; 
        PrintWriter pw = null; 
        try{ 
            f = new File(System.getProperty("user.home") + "/Desktop/deadlift1ROM.txt");
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw); 
            pw = new PrintWriter(bw);

            if(reference.buttonDORM == true){
                pw.println(reference.date.getText() + ":" + trueORM_deadlift + " lbs\n");
                reference.buttonDORM = false;
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