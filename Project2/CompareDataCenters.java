package Projects.Project2;

/**
 * compareDataCenters
 * Find a variety of metrics relating to costs for data centers
 * Alex Thach
 * 9-18-24
 * 255-001
 * 1.8.0_422
 */


import java.util.Scanner;

public class CompareDataCenters{

    public static void main(String[] args){

        //Variable used for the purpose of taking in user input
        String firmInp = "";
        //Scanner object declared
        Scanner input = new Scanner(System.in);

        //Numerous arrays holding the names of firms, and their construction costs, it load, and operation cost
        String[] firms = {"Turner" , "Holder" , "HITT" , "DPR" , "Fortis" , "Mortenson" , "JE Dunn" , "Clune" };
        double[] conCost = {442.2, 584.8, 420.7, 726.5, 574.1, 717.0, 763.4, 527.9};
        double[] itLoad = {168.4, 307.2, 21.8, 271.0, 50.5, 117.7, 199.6, 289.1};
        double[] opCost = {19.0, 26.4, 11.1, 24.5, 12.7, 16.2, 20.7, 25.5};

        //Prints out a variety of price metrics relating to data centers
        System.out.printf("The average construction cost in dollars:" + " " + "$%.2fM" + "\n" , calcAvg(conCost));
        System.out.printf("The average IT Load in megawatts is:" + " " + "%.2fMW" + "\n" , calcAvg(itLoad));
        System.out.printf("The highest construction cost in dollars:" + " " + "$%.2fM" + "\n" , findHighValue(conCost));
        System.out.printf("The least operating cost in dollars is:" + " " + "$%.2fM" + "\n" , findLeastValue(opCost));

        //Prints the two construction firms with the highest construction costs
        System.out.println("The two construction firms with the highest construction cost are:");
        for(String i : findHighestTwo(firms , conCost)){
            System.out.println(i);
        }

        //Prints the two construction firms with the lowest IT load
        System.out.println("The two construction firms with the lowest IT Load are:");
        for(String i : findLeastTwo(firms , itLoad)){
            System.out.println(i);
        }
        //Prompts the user to input a construction firm
        System.out.println("Enter a construction firm:");
        firmInp = input.nextLine().trim();

        //Outputs a set of words depending on if the user inputs a firm that exist or DNE
        if(findConstructionFirm(firms , firmInp)){
            System.out.println(firmInp + " " + "is a construction firm in the array.");
        }else{
            System.out.println(firmInp + " " + "is not a construction firm in the array.");
        }

    }

    /**
     * Calculates the average of double[] values
     * @param values double array input
     * @return the average of the double array values
     */
    public static double calcAvg(double[] values){
        double sum = 0;
        for(int i = 0 ; i < values.length ; i++ ){
            sum += values[i];
        }
        return sum / values.length;

    }

    /**
     * Returns the highest value in double[] values
     * @param values double array inputted
     * @return highest, the highest value in double array values
     */
    public static double findHighValue(double[] values){
        double highest = values[0];

        for(int i = 0 ; i < values.length ; i++){
            if(values[i] > highest){
                highest = values[i];
            }
        }

        return highest;
    }

    /**
     * Returns the lowest value in double[] values
     * @param values double array inputted
     * @return lowest, the lowest value in double array values
     */
    public static double findLeastValue(double[] values){
        double lowest = values[0];

        for(int i = 0 ; i < values.length ; i++){
            if(values[i] < lowest){
                lowest = values[i];
            }
        }

        return lowest;
    }

    /**
     * Returns the names of the firms with the two highest for whatever double[] values is
     * @param names a string array inputted
     * @param values a double array inputted
     * @return returns highest two values in double array with their corresponding names being the firms
     */
    public static String[] findHighestTwo(String[] names, double[] values){
        double one = 0;
        double two = 0;
        String a = "";
        String b = "";
        String[] largestTwo = new String[2];

        for(int i = 0 ; i < values.length ; i++){

            if(values[i] > one){
                two = one;
                b = a;
                one = values[i];
                a = names[i];
            }
            else if(values[i] > two){
                two = values[i];
                b = names[i];
            }


        }

        largestTwo[0] = a;
        largestTwo[1] = b;

        return largestTwo;

    }

    /**
     * Returns the name of the firms with the two lowest for a specific double[] values
     * @param names a string array is inputted
     * @param values a double array is inputted
     * @return the lowest two values in the double array with their corresponding name being the firms
     */
    public static String[] findLeastTwo(String[] names, double[] values){
        double lowBot = Double.POSITIVE_INFINITY;
        double highBot = Double.POSITIVE_INFINITY;
        String a = " ";
        String b = " ";
        String[] lowestTwo = new String[2];

        for(int i = 0 ; i < values.length ; i++){

            if(values[i] < lowBot){
                highBot = lowBot;
                b = a;
                lowBot = values[i];
                a = names[i];
            }
            else if(values[i] < highBot){
                highBot = values[i];
                b = names[i];
            }

        }

        lowestTwo[0] = a;
        lowestTwo[1] = b;
        return lowestTwo;


    }

    /**
     * Checks if the constructionFirm user inputs exist
     * @param names a string of arrays inputted
     * @param constructionFirm the construction firm inputted by the user
     * @return true or false if the construction firm exist in the array of names/firms
     */
    public static boolean findConstructionFirm(String[] names, String constructionFirm){
        boolean exist = false;
        for(String i : names){
            if(constructionFirm.equals(i)){
                exist = true;
                break;
            }
        }

        return exist;
    }


}