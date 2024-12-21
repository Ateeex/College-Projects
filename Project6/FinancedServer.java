package Projects.Project6;
/**
 * Project6
 *
 * Financed type manages matters related to Financed servers , subclass of OwnedServer
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/14/24
 * 255-001
 */
//FinancedServer is a subclass of OwnedServer
public class FinancedServer extends OwnedServer {

    //Private data fields
    private int loanTerm;
    private double apr;

    /**
     * Parameter constructor for FinancedServer
     * @param name name of the server owner
     * @param maintenance mainteance for the server
     * @param failure failure rate of the server
     * @param cost cost for the server
     * @param term term for financing the server
     * @param rate apr for the financing
     */
    public FinancedServer(String name, double maintenance, double failure, double cost, int term, double rate) {
        super(name, maintenance, failure, cost);
        this.loanTerm = term;
        this.apr = rate;
    }

    /**
     * Returns loan term
     * @return loanTerm
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * Sets a new loan term
     * @param years new loan term to be set
     */
    public void setLoanTerm(int years) {
        this.loanTerm = years;
    }

    /**
     * Returns the apr of the financed server
     * @return apr
     */
    public double getApr() {
        return apr;
    }

    /**
     * Sets a new apr for the financed server
     * @param newApr the new apr to be set
     */
    public void setApr(double newApr) {
        this.apr = newApr;
    }

    /**
     * Returns the operating cost for the financed server
     * @param years used in formula to determine cost
     * @return operating cost
     */
    @Override
    public double getOperatingCost(int years) {
        if(years > loanTerm){
            return getBaseCost() * apr * loanTerm + getBaseCost() + (1 + getFailureRate()) * years * getMaintenanceCost();
        }else {
            return getBaseCost() * apr * years + (getBaseCost()/loanTerm) * years + (1 + getFailureRate()) * years * getMaintenanceCost();
        }
    }

    /**
     * Returns the financed server details
     * @return String.format("%s,N/A,%.2f,%.2f,%.2f,%d,%.2f", getBrand(), getMaintenanceCost(), getFailureRate(), getBaseCost(), getLoanTerm(), getApr())
     */
    @Override
    public String toString() {
        return String.format("%s,N/A,%.2f,%.2f,%.2f,%d,%.2f", getBrand(), getMaintenanceCost(), getFailureRate(), getBaseCost(), getLoanTerm(), getApr());
    }

}
