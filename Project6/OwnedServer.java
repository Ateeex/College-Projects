package Projects.Project6;
/**
 * Project6
 *
 * OwnedServer type manages matters related to Owned servers , subclass of Server
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/14/24
 * 255-001
 */
//OwnedServer sublcass of Server
public class OwnedServer extends Server{

    //Private data fields
    private double maintenanceCost;
    private double failureRate;
    private double baseCost;

    /**
     * Parameter constructor for OwnedServer
     * @param name brand that owns the server
     * @param maintenance maintenance cost for server
     * @param failure failure rate for the server
     * @param cost cost of the server
     */
    public OwnedServer(String name, double maintenance, double failure, double cost) {
        super(name);
        this.maintenanceCost = maintenance;
        this.failureRate = failure;
        this.baseCost = cost;
    }

    /**
     * Returns the maintenance cost
     * @return maintenanceCost
     */
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * Sets a new maintenance cost for the server
     * @param cost cost for new server
     */
    public void setMaintenanceCost(double cost) {
        this.maintenanceCost = cost;
    }

    /**
     * Returns the failure rate for the server
     * @return failureRate
     */
    public double getFailureRate() {
        return failureRate;
    }

    /**
     * Sets a new failureRate for the server
     * @param rate new failure rate for the server
     */
    public void setFailureRate(double rate) {
        this.failureRate = rate;
    }

    /**
     * Returns the base cost for the server
     * @return baseCost
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Sets a new base cost for the server
     * @param cost new base cost for the server
     */
    public void setBaseCost(double cost) {
        this.baseCost = cost;
    }

    /**
     * Returns the operating cost for the owned server
     * @param years used in formula to determine cost
     * @return baseCost + (1 + failureRate) * years * maintenanceCost
     */
    @Override
    public double getOperatingCost(int years) {
        return  baseCost + (1 + failureRate) * years * maintenanceCost;
    }

    /**
     * toString that returns brand,maintenance cost, failure rate, and base cost
     * @return String.format(" % s, N / A, % .2f, % .2f, % .2f, N / A, N / A ", getBrand (), getMaintenanceCost(), getFailureRate(), getBaseCost());
     */
    @Override
    public String toString() {
        return String.format("%s,N/A,%.2f,%.2f,%.2f,N/A,N/A",
                getBrand(), getMaintenanceCost(), getFailureRate(), getBaseCost());
    }

}
