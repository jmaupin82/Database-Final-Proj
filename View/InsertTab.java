package View;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class InsertTab extends JPanel 
{
    private static final long serialVersionUID = 1L;
    //JLabes
    private JLabel jlblcusName = new JLabel("Name:");
    private JLabel jlblcusAddr = new JLabel("Address:");
    private JLabel jlblAsscusName = new JLabel("Customer Name:");
    private JLabel jlblAssid = new JLabel("Ass. ID:");
    private JLabel jlblAssDate = new JLabel("Date(MM/DD/YYYY):");
    private JLabel jlblAssDetails = new JLabel("Details:");
    private JLabel jlbldepId = new JLabel("Dep ID:");
    private JLabel jlbldepData = new JLabel("Data:");
    private JLabel jlblProcId = new JLabel("Proc. ID:");
    private JLabel jlblProcDep = new JLabel("Dep ID:");
    private JLabel jlblProcData = new JLabel("Data:");
    private JLabel jlblProcDetail1 = new JLabel("Fit Type:");
    private JLabel jlblProcDetail2 = new JLabel("");

    //JTextFields
    private JTextField jtfcusName = new JTextField();
    private JTextField jtfcusAddr = new JTextField();
    private JTextField jtfdepID = new JTextField();
    private JTextField jtfdepData = new JTextField();
    private JTextField jtfAsscusName = new JTextField();
    private JTextField jtfAssid = new JTextField();
    private JTextField jtfAssDate = new JTextField();
    private JTextField jtfAssDetails = new JTextField();
    private JTextField jtfProcId = new JTextField();
    private JTextField jtfProcDep = new JTextField();
    private JTextField jtfProcData = new JTextField();
    private JTextField jtfProcDetail1 = new JTextField();
    private JTextField jtfProcDetail2 = new JTextField();
    
    //JButtons
    private JButton jbtnInsertCustomer = new JButton("Insert Customer");
    private JButton jbtnInsertDepartment = new JButton("Insert Department");
    private JButton jbtnInsertAssembly = new JButton("Insert Assembly");
    private JButton jbtnInsertProcess = new JButton("Insert Process");
    
    //JRadio Buttons
    private JRadioButton jrbtnFitProc = new JRadioButton("Fit Proc.");
    private JRadioButton jrbtnCutProc = new JRadioButton("Cut Proc.");
    private JRadioButton jrbtnPaintProc = new JRadioButton("Paint Proc.");
   
    //Button Groups
    private ButtonGroup btngProcType = new  ButtonGroup();
    
    
    
    public InsertTab()
    {
	//Query 1 Panel
	JPanel query1 = new JPanel(new GridLayout(0,2));
	query1.setBorder(new TitledBorder("Insert Customer:"));
	query1.add(jlblcusName);
	query1.add(jtfcusName);
	query1.add(jlblcusAddr);
	query1.add(jtfcusAddr);
	query1.add(new JPanel());
	query1.add(jbtnInsertCustomer);
	
	//Query 2 Panel
	JPanel query2 = new JPanel(new GridLayout(0,2));
	query2.setBorder(new TitledBorder("Insert Department:"));
	query2.add(jlbldepId);
	query2.add(jtfdepID);
	query2.add(jlbldepData);
	query2.add(jtfdepData);
	query2.add(new JPanel());
	query2.add(jbtnInsertDepartment);
	
	//Query 3 Panel
	JPanel query3 = new JPanel(new GridLayout(0,2));
	query3.setBorder(new TitledBorder("Insert Assembly:"));
	query3.add(jlblAsscusName);
	query3.add(jtfAsscusName);
	query3.add(jlblAssid);
	query3.add(jtfAssid);
	query3.add(jlblAssDate);
	query3.add(jtfAssDate);
	query3.add(jlblAssDetails);
	query3.add(jtfAssDetails);
	query3.add(new JPanel());
	query3.add(jbtnInsertAssembly);
	
	
	//Radio Panel
	JPanel radioPanel = new JPanel(new GridLayout(1,3));
	btngProcType.add(jrbtnFitProc);
	jrbtnFitProc.setSelected(true);
	btngProcType.add(jrbtnCutProc);
	btngProcType.add(jrbtnPaintProc);
	radioPanel.add(jrbtnFitProc);
	radioPanel.add(jrbtnCutProc);
	radioPanel.add(jrbtnPaintProc);
	
	//Query 4 Panel
	JPanel query4 = new JPanel(new GridLayout(0,2));
	query4.setBorder(new TitledBorder("Insert Process:"));
	query4.add(jlblProcId);
	query4.add(jtfProcId);
	query4.add(jlblProcDep);
	query4.add(jtfProcDep);
	query4.add(jlblProcData);
	query4.add(jtfProcData);
	query4.add(jlblProcDetail1);
	query4.add(jtfProcDetail1);
	query4.add(jlblProcDetail2);
	jtfProcDetail2.setEnabled(false);
	query4.add(jtfProcDetail2);
	query4.add(radioPanel);
	query4.add(jbtnInsertProcess);
	
	//Adding panels to JFrame
	this.setLayout(new GridLayout(0,1));
	this.add(query1);
	this.add(query2);
	this.add(query3);
	this.add(query4);
	
    }
    
    public JLabel getjlblProcDetail1(){
	return jlblProcDetail1;
    }
    
    public JLabel getjlblProcDetail2(){
 	return jlblProcDetail2;
     }

    /**
     * @return the jtfcusName
     */
    public JTextField getJtfcusName() {
        return jtfcusName;
    }

    /**
     * @return the jtfcusAddr
     */
    public JTextField getJtfcusAddr() {
        return jtfcusAddr;
    }

    /**
     * @return the jtfdepID
     */
    public JTextField getJtfdepID() {
        return jtfdepID;
    }

    /**
     * @return the jtfdepData
     */
    public JTextField getJtfdepData() {
        return jtfdepData;
    }

    /**
     * @return the jtfAsscusName
     */
    public JTextField getJtfAsscusName() {
        return jtfAsscusName;
    }

    /**
     * @return the jtfAssid
     */
    public JTextField getJtfAssid() {
        return jtfAssid;
    }

    /**
     * @return the jtfAssDate
     */
    public JTextField getJtfAssDate() {
        return jtfAssDate;
    }

    /**
     * @return the jtfAssDetails
     */
    public JTextField getJtfAssDetails() {
        return jtfAssDetails;
    }

    /**
     * @return the jtfProcId
     */
    public JTextField getJtfProcId() {
        return jtfProcId;
    }

    /**
     * @return the jtfProcDep
     */
    public JTextField getJtfProcDep() {
        return jtfProcDep;
    }

    /**
     * @return the jtfProcDate
     */
    public JTextField getJtfProcData() {
        return jtfProcData;
    }

    /**
     * @return the jtfProcDetail1
     */
    public JTextField getJtfProcDetail1() {
        return jtfProcDetail1;
    }

    /**
     * @return the jtfProcDetail2
     */
    public JTextField getJtfProcDetail2() {
        return jtfProcDetail2;
    }

    /**
     * @return the jbtnInsertCustomer
     */
    public JButton getJbtnInsertCustomer() {
        return jbtnInsertCustomer;
    }

    /**
     * @return the jbtnInsertDepartment
     */
    public JButton getJbtnInsertDepartment() {
        return jbtnInsertDepartment;
    }

    /**
     * @return the jbtnInsertAssembly
     */
    public JButton getJbtnInsertAssembly() {
        return jbtnInsertAssembly;
    }

    /**
     * @return the jbtnInsertProcess
     */
    public JButton getJbtnInsertProcess() {
        return jbtnInsertProcess;
    }

    /**
     * @return the jrbtnFitProc
     */
    public JRadioButton getJrbtnFitProc() {
        return jrbtnFitProc;
    }

    /**
     * @return the jrbtnCutProc
     */
    public JRadioButton getJrbtnCutProc() {
        return jrbtnCutProc;
    }

    /**
     * @return the jrbtnPaintProc
     */
    public JRadioButton getJrbtnPaintProc() {
        return jrbtnPaintProc;
    }

    /**
     * @return the btngProcType
     */
    public ButtonGroup getBtngProcType() {
        return btngProcType;
    }
}
