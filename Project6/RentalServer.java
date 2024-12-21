package Projects.Project6;
/**
 * Project6
 *
 * RentalServer type manages matters related to rental servers , subclass of Server
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/14/24
 * 255-001
 */
//RentalServer subclass of Server
public class RentalServer extends Server {

    //Private data fields
    private double annualRent;

    /**
     * Parameter constructor for RentalServer
     * @param name name of the brand
     * @param rent rent for the server
     */
    public RentalServer(String name, double rent) {
        super(name);
        this.annualRent = rent;
    }

    /**
     * Returns rent for the server
     * @return annualRent
     */
    public double getAnnualRent() {
        return annualRent;
    }

    /**
     * Sets a new annual rent for the server
     * @param rent new annual rent for the server
     */
    public void setAnnualRent(double rent) {
        this.annualRent = rent;
    }

    /**
     * Returns the operating cost for rental server
     * @param years years parameter to determine cost
     * @return annualRent * years
     */
    @Override
    public double getOperatingCost(int years) {
        return annualRent * years;
    }

    /**
     * toString that returns brand and annual rent for the server
     * @return String.format("%s,%.2f,N/A,N/A,N/A,N/A,N/A", getBrand(), getAnnualRent());
     */
    @Override
    public String toString() {
        return String.format("%s,%.2f,N/A,N/A,N/A,N/A,N/A", getBrand(), getAnnualRent());
    }
}
