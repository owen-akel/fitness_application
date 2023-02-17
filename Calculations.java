public class Calculations
{
    public static double true1RM (String Sweight, String Srepetitions){
        int intWeight = Integer.parseInt(Sweight);
        double doubleWeight = intWeight;
        int intRepetitions = Integer.parseInt(Srepetitions);
        double doubleRepetitions = intRepetitions; 
        double ORM = intWeight * (1 + (doubleRepetitions/30));
        return ORM;
    }

    public static double rpe1RM (String Sweight, String Srepetitions,String SRPE){
        int intWeight = Integer.parseInt(Sweight);
        double doubleWeight = intWeight; 
        int intRPE = 10 - Integer.parseInt(SRPE);
        int intRepetitions = Integer.parseInt(Srepetitions) + intRPE;
        double doubleRepetitions = intRepetitions; 
        double ORM = doubleWeight * (1 + (doubleRepetitions/30));
        return ORM;
    }
}
