package Projects.Project4;

import java.util.ArrayList;

/**
 * Project4
 *
 * Manages the details of a data center
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 10/18/24
 * 255-001
 */




public class DataCenter {
    //Instance variables for DataCenter
    private String centerName;
    private int capacity;
    private double budget;
    private ArrayList<ServerRack> rackList;

    
    /**
     * Default constructor
     */
    public DataCenter(){
        this.centerName = "";
        this.capacity = 0;
        this.budget = 0;
        this.rackList = new ArrayList<>();
    }

    /**
     * Parameter constructor that assingns parameter values to instance variables
     * @param aCenterName data center's name
     * @param aCapacity , the data center's capacity
     * @param aBudget , the budget for the data center
     */
    public DataCenter(String aCenterName, int aCapacity, double aBudget){
        this.centerName = aCenterName;
        this.capacity = aCapacity;
        this.budget = aBudget;
        this.rackList = new ArrayList<>();
    }


    /**
     * Returns data center's name
     * @return centerName
     */
    public String getCenterName() {
        return centerName;
    }

    /**
     * Return's data center's capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Return's the budget for the data cetner
     * @return budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Assigns centerName to a set name
     * @param centerName the set name
     */
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    /**
     * Assigns capacity to a set capacity
     * @param capacity the set capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Assigns a budget to a set budget
     * @param budget the set budget
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }


    /**
     * Adds a server rack to the rackList
     * @param rack the rack being added
     */
    public void addServerRack(ServerRack rack){
        rackList.add(rack);
    }

    /**
     * Returns the number of racks in the rackList
     * @return rackList.size()
     */
    public int getNumServerRacks(){
        return rackList.size();
    }

    /**
     * Returns the list of objects in rackList
     * @return rackList
     */
    public ArrayList<ServerRack> getServerRacks(){
        return rackList;
    }

    /**
     * Checks to see if the cost of the rackList is within budget
     * @return totCost <= budget
     */
    public boolean isInBudget(){
        double totCost = 0;

        for(ServerRack rack : rackList){
            totCost += rack.getOperatingCost();
        }

        return totCost <= budget;
    }

    /**
     * Returns the data centers details
     * @return dataCenter.toString()
     */
    public String toString() {
        StringBuilder dataCenter = new StringBuilder();
        dataCenter.append(centerName)
                .append("\n")
                .append(capacity)
                .append("\n")
                .append(String.format("%.2f", budget))
                .append("\n")
                .append("ServerRacks:\n");

        for(int i = 0 ; i < rackList.size() ; i++){
            dataCenter.append(rackList.get(i).toString());
        }



        return dataCenter.toString();
    }

}




















