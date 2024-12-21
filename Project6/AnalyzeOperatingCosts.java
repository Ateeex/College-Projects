package Projects.Project6;
/**
 * Project6
 *
 * AnalyzeOperatingCost class that inputs the data
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/14/24
 * 255-001
 */
import java.io.*;
import java.util.*;

public class AnalyzeOperatingCosts {
    public static void main(String[] args) {

        //Gets values from the command line
        ArrayList<Server> servers = new ArrayList<>();
        String inputFile = args[0];
        String outputFile = args[1];
        int compareYears = Integer.parseInt(args[2]);


        // Update static compareNumYears in Server class
        Server.setCompareNumYears(compareYears);



        // Read input file
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                try {
                    servers.add(createServerFromData(data));
                } catch (IllegalArgumentException e) {

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }


        // Sort servers based on operating cost over compareNumYears
        Collections.sort(servers);

        // Write output file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("Brand,rent,maintenance,failure rate,base cost,loan term,apr");

            for (Server server : servers) {
                writer.println(server.toString());
            }

        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }

    /**
     * Method for creating a new server from the line data in the input file
     * @param data line of data
     * @return a server of a specific type
     */
    public static Server createServerFromData(String[] data) {
        String brand = data[0];
        String rentStr = data[1];
        String maintenanceStr = data[2];
        String failureRateStr = data[3];
        String baseCostStr = data[4];
        String loanTermStr = data[5];
        String aprStr = data[6];

        if (!rentStr.equals("N/A")) {
            double rent = Double.parseDouble(rentStr);
            return new RentalServer(brand, rent);
        } else if (!loanTermStr.equals("N/A") && !aprStr.equals("N/A")) {
            double maintenance = Double.parseDouble(maintenanceStr);
            double failureRate = Double.parseDouble(failureRateStr);
            double baseCost = Double.parseDouble(baseCostStr);
            int loanTerm = Integer.parseInt(loanTermStr);
            double apr = Double.parseDouble(aprStr);
            return new FinancedServer(brand, maintenance, failureRate, baseCost, loanTerm, apr);
        } else if (!maintenanceStr.equals("N/A")) {
            double maintenance = Double.parseDouble(maintenanceStr);
            double failureRate = Double.parseDouble(failureRateStr);
            double baseCost = Double.parseDouble(baseCostStr);
            return new OwnedServer(brand, maintenance, failureRate, baseCost);
        } else {
            throw new IllegalArgumentException("Invalid data format");
        }
    }
}

