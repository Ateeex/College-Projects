package Projects.Project6;
/**
 * Project6
 *
 * Abstract class that defines the properties of Server
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/14/24
 * 255-001
 */
//Server implements interface Comparable
public abstract class Server implements Comparable<Server> {

    //Private data fields
    private String brand;
    private static int compareNumYears = 5;

    /**
     * Parmeter constructor
     * @param brand that owns the server
     */
    public Server(String brand) {
        this.brand = brand;
    }

    /**
     * Getter method for brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for brand
     * @param brand new name for brand owning server
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter method for compareNumYears
     * @return compareNumYears
     */
    public static int getCompareNumYears() {
        return compareNumYears;
    }

    /**
     * Sets new compare num years for the server
     * @param compareNumYears new compare num years to be set
     */
    public static void setCompareNumYears(int compareNumYears) {
        Server.compareNumYears = compareNumYears;
    }

    /**
     * Compare to method compares server objects
     * @param other the object to be compared.
     * @return Double.compare(this.getOperatingCost(compareNumYears) , other.getOperatingCost(compareNumYears));
     */
    public int compareTo(Server other){
        return Double.compare(this.getOperatingCost(compareNumYears) , other.getOperatingCost(compareNumYears));
    }

    /**
     * Abstract method for getOperatingCost
     * @param years year parameter to determine cost for subclasses
     * @return double(Cost)
     */
    public abstract double getOperatingCost(int years);

    /**
     * Returns brand name
     * @return brand
     */
    @Override
    public String toString() {
        return brand;
    }
}
