package Driver;

import View.View;
import Controller.DBController;
import Model.DBModel;

/**
 * Class Driver
 * Runs the gui application
 */
public class Driver 
{
    private DBModel jobShopModel;
    private View jobShopView;
    private DBController jobShopController;
    
    public Driver()
    {
	this.jobShopModel = new DBModel();
	this.jobShopController = new DBController();
	this.jobShopView = new View();
	
	this.jobShopController.setDBModel(this.jobShopModel);
	this.jobShopController.setView(this.jobShopView);
	this.jobShopView.setDBModel(this.jobShopModel);
    }
    
    /**
     * Main function
     * @param args
     */
    public static void main (String [] args)
    {
	new Driver();
    }

}
