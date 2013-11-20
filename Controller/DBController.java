package Controller;

import Model.DBModel;
import View.View;

public class DBController 
{
    private DBModel model;
    private View view;
    
    public DBController()
    {
	
    }
    
    /**
     * A method for setting the model.
     * @param SurveyModel
     */
    public void setDBModel(DBModel m)
    {
	this.model = m;
    }

    /**
     * A method for setting the View
     * @param SurveyView
     */
    public void setView(View v)
    {
	this.view = v;
    }
}
