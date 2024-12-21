package Projects.Project4;
/**
 * Project4
 *
 * Manages the details of server racks(s)
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 10/18/24
 * 255-001
 */




public class ServerRack {
    //Instance variables of serverRack class
    private String brand;
    private int rackID;
    private double operatingCost;
    private OS operatingSystem;
    private Cooling cooling;
    private Ownership ownership;



    /**
     * Default constructor
     */
    public ServerRack(){
        this.brand = "";
        this.rackID = 0;
        this.operatingCost = 0;
        this.operatingSystem = OS.WINDOWS;
        this.cooling = Cooling.AIR;
        this.ownership = Ownership.RENTAL;
    }

    /**
     * Constructor that assigns instance variables to parameter variables
     * @param aBrand , brand name
     * @param aRackID , rack identification number
     * @param anOperatingCost , cost to operate the sever
     * @param anOperatingSystem , the operating system for the server
     * @param aCooling , the type of cooling being used for the server
     * @param anOwnership , how is the server rack owned
     */
    public ServerRack(String aBrand, int aRackID, double anOperatingCost, OS anOperatingSystem, Cooling aCooling, Ownership anOwnership){
        this.brand = aBrand;
        this.rackID = aRackID;
        this.operatingCost = anOperatingCost;
        this.operatingSystem = anOperatingSystem;
        this.cooling = aCooling;
        this.ownership = anOwnership;
    }

    /**
     * Returns brand name using the server rack
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns server rack's identification number
     * @return rackID
     */
    public int getRackID() {
        return rackID;
    }

    /**
     * Returns the operating cost of the server rack
     * @return operatingCost
     */
    public double getOperatingCost() {
        return operatingCost;
    }

    /**
     * Returns the operating system of the server rack
     * @return operatingSystem
     */
    public OS getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * The cooling type of the server rack
     * @return coolingType
     */
    public Cooling getCooling() {
        return cooling;
    }

    /**
     * The ownership type of the server rack
     * @return ownType
     */
    public Ownership getOwnership() {
        return ownership;
    }

    /**
     * Sets the brand that is using the server rack
     * @param brand , brand name
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Sets the server rack's ID
     * @param rackID , rack's identification number
     */
    public void setRackID(int rackID) {
        this.rackID = rackID;
    }

    /**
     * Sets the operating cost for the server rack
     * @param operatingCost, operating cost for the server rack
     */
    public void setOperatingCost(double operatingCost) {
        this.operatingCost = operatingCost;
    }

    /**
     * Sets the operating system for the server rack
     * @param operatingSystem , operating system type
     */
    public void setOperatingSystem(OS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * Sets the cooling type for the server rack
     * @param cooling, cooling type
     */
    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

    /**
     * Sets the ownership type for the server rack
     * @param ownership ownership type for the server rack
     */
    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    /**
     * Returns the server rack details
     * @return brand,rackID,operatingCost,operatingSystem,coolingType,ownType
     */
    public String toString(){
        return String.format("\n\t%s\n\t%d\n\t%.2f\n\t%s\n\t%s\n\t%s\n",
                brand,
                rackID,
                operatingCost,
                operatingSystem,
                cooling,
                ownership);
    }





}
