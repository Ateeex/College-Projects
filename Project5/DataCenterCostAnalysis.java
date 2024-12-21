package Projects.Project5;

/**
 * Project5
 *
 * Does cost analysis of the data center
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/1/24
 * 255-001
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataCenterCostAnalysis {

    public static void main(String[] args) {

        //Declare file objects and arraylist to be used
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        ArrayList<String> fileLines = new ArrayList<>();
        ArrayList<DataCenter> dataCenters;

        //Try catch to make sure input file exists
        try{
            fileLines = openFile(inputFile);
            System.out.println("Input file correct");
        }catch(FileNotFoundException e){
            System.out.println("Incorrect input filename");
        }

        //Create data center objects out of fileLines an assigns it to dataCenters arraylist
        dataCenters = createObjects(fileLines);

        //Calls to numerous methods to find the mean, highest value, mean data center, and data centers below the mean
        //Assigns the return values of the method calls to variables accordingly
        double meanConstructionCost = findMean(dataCenters, DataCenterAttributes.CONSTRUCTION_COST);
        double highestITLoad = findHighValue(dataCenters, DataCenterAttributes.IT_LOAD);
        DataCenter closestToMean = findMeanDataCenter(dataCenters , DataCenterAttributes.CONSTRUCTION_COST , meanConstructionCost);
        ArrayList<DataCenter> lowestDataCenters = findLowestDataCenters(dataCenters , DataCenterAttributes.CONSTRUCTION_COST , meanConstructionCost);

        //Try catch to check if output file exists
        try{
            PrintWriter out = new PrintWriter(outputFile);
            System.out.println("Output file correct");

            //Writes to an output file a variety of metrics of the data centers
            outputToFile("The average construction cost of all data centers is: ", meanConstructionCost, out);
            outputToFile("The highest IT load of all data centers is: ", highestITLoad, out);
            outputToFile("The data center closest to the average construction cost is: ", closestToMean, out);
            outputToFile("The data centers below the average value for construction cost are: ", lowestDataCenters, out);

            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect output filename");
        }

    }

    /**
     * Returns a string arraylist of a file's details
     * @param inputFile file being inputted
     * @return fileLines
     * @throws FileNotFoundException throws error if file does not exist
     */
    public static ArrayList<String> openFile(File inputFile) throws FileNotFoundException {

        ArrayList<String> fileLines = new ArrayList<>();

        //Loops through each line of the file and adds each line to an arraylist
        try(Scanner sc = new Scanner(inputFile);){
            while (sc.hasNextLine()) {
                fileLines.add(sc.nextLine());
            }
        }

        return fileLines;
    }

    /**
     * Returns an arraylist of data centers from a string arraylist
     * @param lines arraylist of data centers
     * @return dataCenters
     */
    public static ArrayList<DataCenter> createObjects(ArrayList<String> lines){

        ArrayList<DataCenter> dataCenters = new ArrayList<>();

        //Loops through the entirety of the string arraylist and splits up the values accordingly
        for(String line : lines){
            String[] firm = line.split("\t");

            String constructionFirm = firm[0];
            double constructionCost = acceptableDouble(firm[1]);
            double ITLoad = acceptableDouble(firm[2]);
            double operatingCost = acceptableDouble(firm[3]);

            DataCenter dataCenter = new DataCenter(constructionFirm , constructionCost , ITLoad , operatingCost);
            dataCenters.add(dataCenter);
        }

        return dataCenters;
    }

    /**
     * Helper method that checks if a cost metric is an acceptable value being either above 0 and a number
     * @param metric string metric that is checked if it can be parsed and is above 0
     * @return parsedVal or 0.0
     */
    public static double acceptableDouble(String metric){

        try{
            double parsedVal = Double.parseDouble(metric);
            if(parsedVal < 0.0){
                return 0.0;
            }else{
                return parsedVal;
            }
        }catch(NumberFormatException nfe){
            return 0.0;
        }

    }

    /**
     * finds the mean value of all the data centers based on a specific attribute
     * @param dataCenters arraylist of data centers
     * @param attribute specific attribute being averaged for
     * @return total / count
     */
    public static double findMean(ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute){

        double total = 0;
        double count = 0;

        //Loops through the specific attribute for all data centers
        //Finds total and count of the data center and its specific attribute
        for(DataCenter metric : dataCenters){
            total += getAttributeValue(metric , attribute);
            count++;
        }

        return total / count;

    }

    /**
     * Helper method to get an attribute value
     * @param dc the data center
     * @param attribute the attribute being searched
     * @return dc.getConstructionCost , dc.getITLoad, dc.GetOperatingCost, 0.0
     */
    private static double getAttributeValue(DataCenter dc, DataCenterAttributes attribute) {

        switch (attribute) {
            case CONSTRUCTION_COST:
                return dc.getConstructionCost();
            case IT_LOAD:
                return dc.getITLoad();
            case OPERATING_COST:
                return dc.getOperatingCost();
            default:
                return 0.0;

        }
    }

    /**
     * Returns the highest value of specified attribute amongst the data centers
     * @param dataCenters arraylist of data centers
     * @param attribute specific attribute being searched for
     * @return max
     */
    public static double findHighValue(ArrayList<DataCenter> dataCenters,  DataCenterAttributes attribute){

        double max = 0;

        //Loops through dataCenters and compares data centers to max to find max value
        for(DataCenter metric : dataCenters){
            double currentVal = getAttributeValue(metric , attribute);
            if(currentVal > max){
                max = currentVal;
            }
        }

        return max;
    }

    /**
     * Finds closest data center to meanValue for a specific attribute
     * @param dataCenters arraylist of data centers
     * @param attribute specified attribute being used
     * @param meanValue mean value of all data centers
     * @return meanDataCenter
     */
    public static DataCenter findMeanDataCenter(ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute, double meanValue){

        DataCenter meanDataCenter = null;
        double smallestDif = Double.MAX_VALUE;

        //Loops through each data center in dataCenters
        for(DataCenter metric : dataCenters){

            //Finds the difference between a data center's attribute value to mean value difference
            double attributeVal = getAttributeValue(metric , attribute);
            double difference = Math.abs(attributeVal - meanValue);

            //Assigns smallest difference between mean value and a data center's current attribute value
            if(difference < smallestDif){
                smallestDif = difference;
                meanDataCenter = metric;
            }


        }

        return meanDataCenter;

    }

    /**
     * Finds data centers below a designated mean value for an attribute
     * @param dataCenters arraylist of data centers
     * @param attribute specific attribute being used
     * @param value mean value of all data centers
     * @return lowerDataCenters
     */
    public static ArrayList<DataCenter> findLowestDataCenters(ArrayList<DataCenter> dataCenters, DataCenterAttributes attribute, double value){

        ArrayList<DataCenter> lowerDataCenters = new ArrayList<>();

        //Loops through dataCenters for each data center
        for(DataCenter metric : dataCenters){

            //Get specified attribute for the current data center
            double currentVal = getAttributeValue(metric , attribute);

            //Checks if specified attribute value is below value and adds to lowerDataCenters accordingly
            if(currentVal < value){
                lowerDataCenters.add(metric);
            }

        }

        return lowerDataCenters;

    }

    /**
     * Writes to a file of all the data center objects
     * @param outputMessage what the method intends to output
     * @param dataCenters arraylist of data centers to be written on output file
     * @param out PrintWriter object to be written on
     */
    public static void outputToFile(String outputMessage, ArrayList<DataCenter> dataCenters, PrintWriter out){
        out.print(outputMessage);
        for(DataCenter dc : dataCenters){
            out.print(dc.toString() + " ");
        }
        out.println();
        out.println();
    }

    /**
     * Writes to a file of a specific data center
     * @param outputMessage what the method intends to output
     * @param dataCenter dataCenter value that will be written to output file
     * @param out PrintWriter object to be written on
     */
    public static void outputToFile(String outputMessage, DataCenter dataCenter, PrintWriter out){
        out.print(outputMessage + dataCenter.toString());
        out.println();
        out.println();

    }

    /**
     * Writes a specific double value to a file
     * @param outputMessage what the method intends to output
     * @param value double value to be written on the output file
     * @param out PrintWriter object to be written on
     */
    public static void outputToFile(String outputMessage, double value, PrintWriter out){
        out.printf("%s" + "%.2f" , outputMessage , value);
        out.println();
        out.println();
    }












}