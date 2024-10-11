package Projects.Project3;

/**
 * OperatingCosts
 *
 * Algorithm to find a variety of cost metrics for data centers based on specific filters, data is entered through the command line
 * _____________________________________________________
 * @author Alex Thach
 * @version 255-001 10-4-24
 * 255-001
 */

public class OperatingCosts {

    public static void main(String[] args) {
        //Arrays that hold metrics, dataCenter values, and valid annualOperations
        //Data is received through the command line
        String[] metrics = getOperatingMetrics(args[0]);
        double[][] dataCenters = getDataCenters(args[1]);
        int[] annualOperations;

        //Prints data centers under the annual cost limit of 18.5 million
        System.out.print("Data Centers under the annual cost limit are: ");
        System.out.print("[");
        annualOperations = findAnnualOperationCost(dataCenters);
        for(int i = 0 ; i < annualOperations.length ; i++){
            if(i < annualOperations.length - 1)
                System.out.print(annualOperations[i] + "," + " ");
            else{
                System.out.print(annualOperations[i]);
            }
        }
        System.out.println("]");

        //Prints the two highest operating cost metric for data center 1
        System.out.println("The two highest value operating cost metrics for Data Center 1 are:" + " " + searchHighestMetric(dataCenters , metrics , 1));
        //Prints the data center with the highest cost for the metric power
        System.out.println("The Data Center with the highest power is:" + " " + searchHighestDataCenter(dataCenters , metrics , "power"));

    }

    /**
     * Returns the string of metrics names in a String array, splits them at the commas
     * @param metricNames String that is to be split
     * @return String array of split string
     */
    public static String[] getOperatingMetrics(String metricNames){
        return metricNames.split(",");
    }

    /**
     * Returns a 2D array of dataCenterMetrics formatted in a with columns representing a metric, and rows representing a data center
     * @param dataCenterMetrics A string of metric values that is to be split into a 2D array
     * @return 2D array of split metric values
     */
    public static double[][] getDataCenters(String dataCenterMetrics){
        String[] centers = dataCenterMetrics.split("<>");
        double[][] dataCenters = new double[centers.length][];

        for(int i = 0 ; i < centers.length ; i++){
            String[] metrics = centers[i].split(",");

            dataCenters[i] = new double[metrics.length];
            for(int j = 0 ; j < metrics.length ; j++){
                dataCenters[i][j] = Double.parseDouble(metrics[j]);
            }
        }
        return dataCenters;

    }

    /**
     * Returns data centers that are under or at 18.5 million for annual operation cost
     * @param dataCenters 2D array that holds data centers cost metrics
     * @return An array that stores data centers with a valid annual operation cost
     */
    public static int[] findAnnualOperationCost(double [][] dataCenters){
        int[] operatingCostsMet;
        int count = 0;
        int newIntIndex = 0;
        double operatingCosts;

        for(int i = 0 ; i < dataCenters.length ; i++){
            operatingCosts = (1 + dataCenters[i][0]) * (dataCenters[i][1] * dataCenters[i][2] + dataCenters[i][3] + (dataCenters[i][4]/dataCenters[i][5]));
            if(operatingCosts <= 18.5){
                count++;
            }
        }

        operatingCostsMet = new int[count];

        for(int i = 0 ; i < dataCenters.length ; i++){
            operatingCosts = (1 + dataCenters[i][0]) * (dataCenters[i][1] * dataCenters[i][2] + dataCenters[i][3] + (dataCenters[i][4]/dataCenters[i][5]));
            if(operatingCosts <= 18.5){
                operatingCostsMet[newIntIndex] = i + 1;
                newIntIndex++;
            }
        }
        return operatingCostsMet;
    }

    /**
     * Return two metrics that are the highest in cost for a specified data center
     * @param dataCenters 2D array of data centers metric values
     * @param metrics An array of metrics for data centers
     * @param dataCenter The specific data center being passed
     * @return two highest metrics for a specified data center
     */
    public static String searchHighestMetric(double [][] dataCenters, String[] metrics, int dataCenter){
        String highestMet = "";
        String secHighestMet = "";
        String twoHighestMetrics = "";
        double highestCos = 0;
        double secHighestCos = 0;

        for(int i = 0 ; i < dataCenters[0].length ; i++){

            if(dataCenters[dataCenter - 1][i] > highestCos){
                secHighestCos = highestCos;
                secHighestMet = highestMet;
                highestCos = dataCenters[dataCenter - 1][i];
                highestMet = metrics[i];
            }
            else if(dataCenters[dataCenter - 1][i] > secHighestCos){
                secHighestCos = dataCenters[dataCenter - 1][i];
                secHighestMet = metrics[i];
            }
        }
        twoHighestMetrics = highestMet + " " + "and" + " " + secHighestMet;
        return twoHighestMetrics;

    }

    /**
     * Finds the data center that has the highest metric value for a specified metric
     * @param dataCenters 2D array holding metric values
     * @param metrics Array that holds data center metrics
     * @param metric Specified metric that is being passed
     * @return The data center with the highest metric for the specified metric passed
     */
    public static int searchHighestDataCenter(double [][] dataCenters, String[] metrics, String metric){
        int metricIndex = 0;
        int largestDataCenter = 0;
        double largestMetric = 0;

        for(int i = 0 ; i < metrics.length ; i++){
            if(metrics[i].equals(metric)){
                metricIndex = i;
                break;
            }
        }

        for(int j = 0 ; j < dataCenters.length ; j++){
            if(dataCenters[j][metricIndex] > largestMetric){
                largestMetric = dataCenters[j][metricIndex];
                largestDataCenter = j;
            }
        }

        return largestDataCenter + 1;
    }



}
