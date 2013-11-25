package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Model.DBModel;
import View.View;

public class DBController 
{
    private DBModel model;
    private View view;
    private ActionListener buttonListerner = new ButtonListener();
    
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
	if (this.view != null)
	{
	    addActionListeners();
	}
    }
    
    public void addActionListeners()
    {
	this.view.getJbtnExit().addActionListener(buttonListerner);
	this.view.getInsertionPanel().getJbtnInsertCustomer().addActionListener(buttonListerner);
	this.view.getInsertionPanel().getJbtnInsertDepartment().addActionListener(buttonListerner);
	this.view.getInsertionPanel().getJbtnInsertAssembly().addActionListener(buttonListerner);
	this.view.getInsertionPanel().getJbtnInsertProcess().addActionListener(buttonListerner);
	this.view.getInsertionPanel2().getJbtnInsertAccount().addActionListener(buttonListerner);
	this.view.getInsertionPanel2().getJbtnStartJob().addActionListener(buttonListerner);
	this.view.getInsertionPanel2().getJbtnEndJob().addActionListener(buttonListerner);
	this.view.getInsertionPanel2().getJbtnInsertTransaction().addActionListener(buttonListerner);
	
    }
    
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == view.getInsertionPanel().getJbtnInsertCustomer())
            {
        	try {
		    model.addCustomer( view.getInsertionPanel().getJtfcusName().getText().trim(), view.getInsertionPanel().getJtfcusAddr().getText().trim());
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
        	System.out.println("cus");
            }
            else if(e.getSource() == view.getInsertionPanel().getJbtnInsertDepartment())
            {
        	try {
		    model.addDapartment(Integer.parseInt(view.getInsertionPanel().getJtfdepID().getText().trim())
		    	, view.getInsertionPanel().getJtfdepData().getText().trim());
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
        	System.out.println("dep");
            }
            else if(e.getSource() == view.getInsertionPanel().getJbtnInsertAssembly())
            {
        	try {
		    model.addAssembly(Integer.parseInt(view.getInsertionPanel().getJtfAssid().getText().trim()),
		    	view.getInsertionPanel().getJtfAsscusName().getText().trim(),
		    	view.getInsertionPanel().getJtfAssDate().getText().trim(),
		    	view.getInsertionPanel().getJtfAssDetails().getText().trim());
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
        	System.out.println("ass");
            }
            else if(e.getSource() == view.getInsertionPanel().getJbtnInsertProcess())
            {
        	try 
        	{
        	    int proc_id = Integer.parseInt(view.getInsertionPanel().getJtfProcId().getText().trim());
        	    String proc_data = view.getInsertionPanel().getJtfProcData().getText().trim();
        	    int dep_id =  Integer.parseInt(view.getInsertionPanel().getJtfProcDep().getText().trim());
        	    String details_1 = view.getInsertionPanel().getJtfProcDetail1().getText().trim();
        	    String proc_type = "";
        	    String details_2 = "";
        	    if (view.getInsertionPanel().getJrbtnCutProc().isSelected())
        	    {
        		proc_type = DBModel.CUT_PROC;
        		details_2 = view.getInsertionPanel().getJtfProcDetail2().getText().trim();
        	    }
        	    else if (view.getInsertionPanel().getJrbtnPaintProc().isSelected())
        	    {
        		proc_type = DBModel.PAINT_PROC;
        		details_2 = view.getInsertionPanel().getJtfProcDetail2().getText().trim();
        	    }
        	    else if (view.getInsertionPanel().getJrbtnFitProc().isSelected())
        	    {
        		proc_type = DBModel.FIT_PROC;
        	    }

		    model.addProcess(proc_id, dep_id, proc_data, proc_type, details_1, details_2);
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
        	System.out.println("proc");
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnInsertAccount())
            {
        	try 
        	{
        	    int acc_id = Integer.parseInt(view.getInsertionPanel2().getJtfAccNum().getText().trim());
        	    int other_id = Integer.parseInt(view.getInsertionPanel2().getJtfAccNum().getText().trim());
        	    if(view.getInsertionPanel2().getJrbtnAssAcc().isSelected())
        	    {
        		model.addAccount(acc_id, other_id, DBModel.ASS_ACC);
        	    }
        	    else if (view.getInsertionPanel2().getJrbtnProcAcc().isSelected())
        	    {
        		model.addAccount(acc_id, other_id, DBModel.PROC_ACC);
        	    }
        	    else if (view.getInsertionPanel2().getJrbtnDepAcc().isSelected())
        	    {
        		model.addAccount(acc_id, other_id, DBModel.DEP_ACC);
        	    }
        	
        	} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnStartJob())
            {
        	try {
        	    	model.StartJob(Integer.parseInt(view.getInsertionPanel2().getJtfJobId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfJobAssId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfJobProcId().getText().trim()),
		    	view.getInsertionPanel2().getJtfJobInitDate().getText().trim());
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnEndJob())
            {
        	try 
        	{
        	    int jobId = Integer.parseInt(view.getInsertionPanel2().getJtfJobIdEnd().getText().trim());
        	    String dateStr = view.getInsertionPanel2().getJtfJobEndDate().getText().trim();
        	    int laborTime = Integer.parseInt(view.getInsertionPanel2().getJtfLaborTime().getText().trim());

        	    if (view.getInsertionPanel2().getJrbtnCutJob().isSelected())
        	    {

        		model.endCutJob(jobId, dateStr, view.getInsertionPanel2().getJtfJobDetail1().getText().trim(),
        			Integer.parseInt(view.getInsertionPanel2().getJtfJobDetail2().getText().trim()), 
        			view.getInsertionPanel2().getJtfJobDetail3().getText().trim(), laborTime);
        	    }
        	    else if (view.getInsertionPanel2().getJrbtnFitJob().isSelected())
        	    {
        		model.endFitJob(jobId, dateStr, laborTime);
        	    }
        	    else if (view.getInsertionPanel2().getJrbtnPaintJob().isSelected())
        	    {
        		model.endPaintJob(jobId, dateStr, view.getInsertionPanel2().getJtfJobDetail1().getText().trim(),
        			Integer.parseInt(view.getInsertionPanel2().getJtfJobDetail2().getText().trim()), laborTime);
        	    }
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnInsertTransaction())
            {
        	try {
		    model.addTransaction(Integer.parseInt(view.getInsertionPanel2().getJtfTransId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfTransJobId().getText().trim()),
		    	Float.parseFloat(view.getInsertionPanel2().getJtfSubCost().getText().trim()));
		} catch (NumberFormatException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		} catch (SQLException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
            }
            else if (e.getSource() == view.getJbtnExit())
            {
        	System.exit(0);
            }
        }
    }
}
