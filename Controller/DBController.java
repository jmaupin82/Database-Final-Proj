package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.DBModel;
import View.View;

public class DBController 
{
    private DBModel model;
    private View view;
    private ActionListener buttonListerner = new ButtonListener();
    private ItemListener groupButtonListener = new RadioButtonListener();
    
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
	this.view.getQueryPanel1().getJbtnQ9().addActionListener(buttonListerner);
	this.view.getQueryPanel1().getJbtnQ10().addActionListener(buttonListerner);
	this.view.getQueryPanel1().getJbtnQ11().addActionListener(buttonListerner);
	this.view.getQueryPanel1().getJbtnQ12().addActionListener(buttonListerner);
	this.view.getQueryPanel2().getJbtnQ13().addActionListener(buttonListerner);
	this.view.getQueryPanel2().getJbtnQ14().addActionListener(buttonListerner);
	this.view.getQueryPanel2().getJbtnQ15().addActionListener(buttonListerner);
	this.view.getQueryPanel2().getJbtnQ16().addActionListener(buttonListerner);
	this.view.getQueryPanel2().getJbtnQ17().addActionListener(buttonListerner);
	this.view.getQueryPanel3().getJbtnQ18().addActionListener(buttonListerner);
	this.view.getQueryPanel3().getJbtnQ19().addActionListener(buttonListerner);
	this.view.getInsertionPanel().getJrbtnCutProc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel().getJrbtnPaintProc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel().getJrbtnFitProc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnAssAcc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnProcAcc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnDepAcc().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnCutJob().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnFitJob().addItemListener(groupButtonListener);
	this.view.getInsertionPanel2().getJrbtnPaintJob().addItemListener(groupButtonListener);
	
    }
    
    private class RadioButtonListener implements ItemListener
    {

	@Override
	public void itemStateChanged(ItemEvent arg0) {
	    if (view.getInsertionPanel().getJrbtnCutProc().isSelected())
	    {
		view.getInsertionPanel().getjlblProcDetail1().setText("Cutting Type:");
		view.getInsertionPanel().getjlblProcDetail2().setText("Machine Type:");
	    }
	    if (view.getInsertionPanel().getJrbtnPaintProc().isSelected())
	    {
		view.getInsertionPanel().getjlblProcDetail1().setText("Paint Type:");
		view.getInsertionPanel().getjlblProcDetail2().setText("Paint Method:");
	    }
	    if (view.getInsertionPanel().getJrbtnFitProc().isSelected())
	    {
		view.getInsertionPanel().getjlblProcDetail1().setText("Fit Type:");
		view.getInsertionPanel().getjlblProcDetail2().setText("");
		view.getInsertionPanel().getJtfProcDetail2().setEnabled(false);
	    }
	    else 
	    {
		view.getInsertionPanel().getJtfProcDetail2().setEnabled(true);
	    }
	    if(view.getInsertionPanel2().getJrbtnAssAcc().isSelected())
	    {
		view.getInsertionPanel2().getJlblRelID().setText("Assembly ID:");
	    }
	    if (view.getInsertionPanel2().getJrbtnProcAcc().isSelected())
	    {
		view.getInsertionPanel2().getJlblRelID().setText("Process ID:");
	    }
	    if (view.getInsertionPanel2().getJrbtnDepAcc().isSelected())
	    {
		view.getInsertionPanel2().getJlblRelID().setText("Department ID:");
	    }
	    
       	    if (view.getInsertionPanel2().getJrbtnCutJob().isSelected())
	    {
       		view.getInsertionPanel2().getJlblJobDetail1().setText("Machine Type:");
       		view.getInsertionPanel2().getJlblJobDetail2().setText("Usage time:");
       		view.getInsertionPanel2().getJlblJobDetail3().setText("Used Material:");
	    }
	    if (view.getInsertionPanel2().getJrbtnFitJob().isSelected())
	    {
       		view.getInsertionPanel2().getJlblJobDetail1().setText("");
       		view.getInsertionPanel2().getJlblJobDetail2().setText("");
       		view.getInsertionPanel2().getJlblJobDetail3().setText("");
       		view.getInsertionPanel2().getJtfJobDetail1().setEditable(false);
       		view.getInsertionPanel2().getJtfJobDetail2().setEditable(false);
       		view.getInsertionPanel2().getJtfJobDetail3().setEditable(false);
	    }
	    else {
		view.getInsertionPanel2().getJtfJobDetail1().setEditable(true);
       		view.getInsertionPanel2().getJtfJobDetail2().setEditable(true);
       		view.getInsertionPanel2().getJtfJobDetail3().setEditable(true);
	    }
	    
	    if (view.getInsertionPanel2().getJrbtnPaintJob().isSelected())
	    {
       		view.getInsertionPanel2().getJlblJobDetail1().setText("Color");
       		view.getInsertionPanel2().getJlblJobDetail2().setText("Volume");
       		view.getInsertionPanel2().getJlblJobDetail3().setText("");
       		view.getInsertionPanel2().getJtfJobDetail3().setEditable(false);
	    }
	    else
	    {
		view.getInsertionPanel2().getJtfJobDetail3().setEditable(true);
	    }
	    
	}
	
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
		    JOptionPane.showMessageDialog(null, "Customer was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add customer:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if(e.getSource() == view.getInsertionPanel().getJbtnInsertDepartment())
            {
        	try {
		    model.addDapartment(Integer.parseInt(view.getInsertionPanel().getJtfdepID().getText().trim())
		    	, view.getInsertionPanel().getJtfdepData().getText().trim());
		    JOptionPane.showMessageDialog(null, "Departmnet was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add deparment:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if(e.getSource() == view.getInsertionPanel().getJbtnInsertAssembly())
            {
        	try {
		    model.addAssembly(Integer.parseInt(view.getInsertionPanel().getJtfAssid().getText().trim()),
		    	view.getInsertionPanel().getJtfAsscusName().getText().trim(),
		    	view.getInsertionPanel().getJtfAssDate().getText().trim(),
		    	view.getInsertionPanel().getJtfAssDetails().getText().trim());
		    JOptionPane.showMessageDialog(null, "Assembly was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add Assembly:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
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
		    JOptionPane.showMessageDialog(null, "Process was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add prcess:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnInsertAccount())
            {
        	try 
        	{
        	    int acc_id = Integer.parseInt(view.getInsertionPanel2().getJtfAccNum().getText().trim());
        	    int other_id = Integer.parseInt(view.getInsertionPanel2().getJtfRelId().getText().trim());
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
        	    JOptionPane.showMessageDialog(null, "Account was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
            	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add account:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnStartJob())
            {
        	try 
        	{
        	    model.StartJob(Integer.parseInt(view.getInsertionPanel2().getJtfJobId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfJobAssId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfJobProcId().getText().trim()),
		    	view.getInsertionPanel2().getJtfJobInitDate().getText().trim());
        	    	JOptionPane.showMessageDialog(null, "Job was successfully started.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
            	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to start job:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
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
        	    JOptionPane.showMessageDialog(null, "Job was successfully ended.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to end job:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getInsertionPanel2().getJbtnInsertTransaction())
            {
        	try {
		    model.addTransaction(Integer.parseInt(view.getInsertionPanel2().getJtfTransId().getText().trim()),
		    	Integer.parseInt(view.getInsertionPanel2().getJtfTransJobId().getText().trim()),
		    	Float.parseFloat(view.getInsertionPanel2().getJtfSubCost().getText().trim()));
		    JOptionPane.showMessageDialog(null, "Transaction was successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to add Transaction:\n" + e1.getMessage(), "Insertion Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel1().getJbtnQ9())
            {
        	try {
		    float res = model.retrieveCostOnAssembly(Integer.parseInt(view.getQueryPanel1().getJtfQ9Ass_id().getText().trim()));
		    view.getQueryPanel1().getJtfQ9Result().setText(String.valueOf(res));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 9:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
        	
            }
            else if (e.getSource() == view.getQueryPanel1().getJbtnQ10())
            {
        	try {
		    int res = model.retrieveLaborTimeOnAssembly(Integer.parseInt(view.getQueryPanel1().getJtfQ10Ass_id().getText().trim()));
		    view.getQueryPanel1().getJtfQ10Result().setText(String.valueOf(res));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 10:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel1().getJbtnQ11())
            {
        	try {
		    int res = model.retrieveLaborTimeOnDepartment(Integer.parseInt(view.getQueryPanel1().getJtfQ11Dep_id().getText().trim()),
		    	view.getQueryPanel1().getJtfQ11Date().getText().trim());
		    view.getQueryPanel1().getJtfQ11Result().setText(String.valueOf(res));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 11:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel1().getJbtnQ12())
            {
        	try {
        	    view.getQueryPanel1().setData(model.retrieveProcess(Integer.parseInt(view.getQueryPanel1().getJtfQ12Ass_id().getText().trim())));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 12:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel2().getJbtnQ13())
            {
        	try {
        	    view.getQueryPanel2().setJobData( model.retrieveJobs(Integer.parseInt(view.getQueryPanel2().getJtfQ13DepId().getText().trim()),
		    	view.getQueryPanel2().getJtfQ13Date().getText().trim()));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 13:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel2().getJbtnQ14())
            {
        	try {
        	    view.getQueryPanel2().setCustomerData(model.retrieveCustomer(view.getQueryPanel2().getJtfQ14().getText().trim()));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 14:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel2().getJbtnQ15())
            {
        	try {
		    model.deleteJobRange(Integer.parseInt(view.getQueryPanel2().getJtfQ15JobIdStart().getText().trim()),
		    	Integer.parseInt(view.getQueryPanel2().getJtfQ15JobIdEnd().getText().trim()));
		    JOptionPane.showMessageDialog(null, "Jobs were successfully deleted.", "Delete Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 15:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel2().getJbtnQ16())
            {
        	try {
		    model.changeColor(Integer.parseInt(view.getQueryPanel2().getJtfQ16JobId().getText().trim()),
			    view.getQueryPanel2().getJtfQ16Color().getText().trim());
		    JOptionPane.showMessageDialog(null, "Job Color was changed.", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 16:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel2().getJbtnQ17())
            {
        	try {
		   float res =  model.retrieveAveCost();
		   view.getQueryPanel2().getJtfQ17Result().setText(String.valueOf(res));
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 17:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel3().getJbtnQ18())
            {
        	
		String lines;
    		
		try 
		{
		    FileInputStream fs = new FileInputStream(view.getQueryPanel3().getSelectedFile());
		    BufferedReader br = new BufferedReader(new InputStreamReader(fs));

		    while ((lines = br.readLine()) != null) 
		    {
			String [] customerInfo = lines.trim().split("\t");
			model.addCustomer(customerInfo[0].trim(), customerInfo[1].trim());
		    }
		    fs.close();
		    br.close();
		    JOptionPane.showMessageDialog(null, "Customers were successfully added.", "Insertion Complete", JOptionPane.INFORMATION_MESSAGE);
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 18:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
            }
            else if (e.getSource() == view.getQueryPanel3().getJbtnQ19())
            {
        	try 
        	{
        	    ArrayList<Object []> result = model.retrieveCustomer(view.getQueryPanel3().getJtfQ19().getText().trim());
        	    FileOutputStream fos = new FileOutputStream(view.getQueryPanel3().getSaveFile());
        	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        	    for (Object [] s: result)
        	    {
        		bw.write((String)s[0] +'\t'+(String)s[1]+ '\n');
        	    }
        	    bw.close();
        	    fos.close();
        	} catch (Exception e1) {
		    JOptionPane.showMessageDialog(null, "Unable to preform query 19:\n" + e1.getMessage(), "Query Fail", JOptionPane.ERROR_MESSAGE);
		}
	
            }
            else if (e.getSource() == view.getJbtnExit())
            {
        	System.exit(0);
            }
        }
    }
}
