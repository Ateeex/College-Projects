package Projects.Project5;

/**
 * Project5
 *
 * Manage data center objects
 *_____________________________________________________
 * @author Alex Thach
 * @version 1.8.0_422
 * 11/1/24
 * 255-001
 */

public class DataCenter {

    //Instance variables
    private String constructionFirm;
    private double constructionCost;
    private double ITLoad;
    private double operatingCost;

    /**
     * Default constructor
     */
    public DataCenter(){
        this.constructionFirm = "";
        this.constructionCost = 0;
        this.ITLoad = 0;
        this.operatingCost = 0;
    }

    /**
     * Parameter constructor
     * @param constructionFirm name of construction firm
     * @param constructionCost cost of construction of the data center
     * @param ITLoad it loads of the data center
     * @param operatingCost operating cost of the data center
     */
    public DataCenter(String constructionFirm , double constructionCost , double ITLoad , double operatingCost){
        this.constructionFirm = constructionFirm;
        this.constructionCost = constructionCost;
        this.ITLoad = ITLoad;
        this.operatingCost = operatingCost;
    }

    /**
     *
     * @return constructionFirm (The firm's name owning the data center)
     */
    public String getConstructionFirm() {
        return constructionFirm;
    }

    /**
     *
     * @param constructionFirm (Sets the firm name owning the data center)
     */
    public void setConstructionFirm(String constructionFirm) {
        this.constructionFirm = constructionFirm;
    }

    /**
     *
     * @return constructionCost (The cost to construct data center)
     */
    public double getConstructionCost() {
        return constructionCost;
    }

    /**
     *
     * @param constructionCost (Sets the construction cost of data center)
     */
    public void setConstructionCost(double constructionCost) {
        this.constructionCost = constructionCost;
    }

    /**
     *
     * @return ITLoad (IT load for data center)
     */
    public double getITLoad() {
        return ITLoad;
    }

    /**
     *
     * @param ITLoad (Sets the IT load for data center)
     */
    public void setITLoad(double ITLoad) {
        this.ITLoad = ITLoad;
    }

    /**
     *
     * @return operatingCost (Cost of operating data center)
     */
    public double getOperatingCost() {
        return operatingCost;
    }

    /**
     *
     * @param operatingCost (Sets the operating cost for data center)
     */
    public void setOperatingCost(double operatingCost) {
        this.operatingCost = operatingCost;
    }




    /**
     * Returns formatted metrics of the data center
     * @return String.format(constructionFirm, constructionCost, ITLoad, operatingCost);
     */
    public String toString(){
        return String.format("%s" + " " + "%.2f" + " " + "%.2f" + " " + "%.2f",
                constructionFirm , constructionCost , ITLoad , operatingCost);
    }
}
