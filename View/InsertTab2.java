package View;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class InsertTab2 extends JPanel 
{
    private static final long serialVersionUID = 1L;
    //JLabels
    private JLabel jlblAccNum = new JLabel("ID:");
    private JLabel jlblRelID = new JLabel("Department ID:");
    private JLabel jlblJobId = new JLabel("Job ID:");
    private JLabel jlblJobAssId = new JLabel("Assembly ID:");
    private JLabel jlblJobInitDate = new JLabel("Date statred (MM/DD/YYYY):");
    private JLabel jlblJobProcId = new JLabel("Process ID:");
    private JLabel jlblTransId = new JLabel("Transaction ID:");
    private JLabel jlblSubCost = new JLabel("Sub-cost:");
    private JLabel jlblTransJobId = new JLabel("Job ID:");
    private JLabel jlblJobIdEnd = new JLabel("Job ID:");
    private JLabel jlblJobEndDate = new JLabel("End Date(MM/DD/YYYY):");
    private JLabel jlblLaborTime = new JLabel("Labor Time:");
    private JLabel jlblJobDetail1 = new JLabel("Machine Type:");
    private JLabel jlblJobDetail2 = new JLabel("Usage Time:");
    private JLabel jlblJobDetail3 = new JLabel("Used Material:");
    
    //JTextFields
    private JTextField jtfAccNum = new JTextField();
    private JTextField jtfRelId = new JTextField();
    private JTextField jtfTransId = new JTextField();
    private JTextField jtfSubCost = new JTextField();
    private JTextField jtfTransJobId = new JTextField();
    private JTextField jtfJobId = new JTextField();
    private JTextField jtfJobAssId = new JTextField();
    private JTextField jtfJobInitDate = new JTextField();
    private JTextField jtfJobProcId = new JTextField();
    private JTextField jtfJobIdEnd = new JTextField();
    private JTextField jtfJobEndDate = new JTextField();
    private JTextField jtfLaborTime = new JTextField();
    private JTextField jtfJobDetail1 = new JTextField();
    private JTextField jtfJobDetail2 = new JTextField();
    private JTextField jtfJobDetail3 = new JTextField();
    
    //JButtons
    private JButton jbtnInsertAccount = new JButton("Insert Account");
    private JButton jbtnStartJob = new JButton("Start Job");
    private JButton jbtnEndJob = new JButton("End Job");
    private JButton jbtnInsertTransaction = new JButton("Enter Transaction");
    
    //JRadio Buttons
    private JRadioButton jrbtnDepAcc = new JRadioButton("Department Account");
    private JRadioButton jrbtnAssAcc = new JRadioButton("Assembly Account");
    private JRadioButton jrbtnProcAcc = new JRadioButton("Process Account");
    private JRadioButton jrbtnPaintJob = new JRadioButton("Paint Job");
    private JRadioButton jrbtnCutJob = new JRadioButton("Cut Job");
    private JRadioButton jrbtnFitJob = new JRadioButton("Fit Job");
   
    //Button Gorups
    private ButtonGroup btngAccType = new ButtonGroup();
    private ButtonGroup btngJobType = new ButtonGroup();
    
    
    public InsertTab2()
    {
	//Account Button group
	btngAccType.add(jrbtnDepAcc);
	btngAccType.add(jrbtnAssAcc);
	btngAccType.add(jrbtnProcAcc);
	jrbtnDepAcc.setSelected(true);
	JPanel accButtongourp = new JPanel(new GridLayout(1,3));
	accButtongourp.add(jrbtnDepAcc);
	accButtongourp.add(jrbtnAssAcc);
	accButtongourp.add(jrbtnProcAcc);
	
	//Query 5 Panel
	JPanel query5 = new JPanel(new GridLayout(0,2));
	query5.setBorder(new TitledBorder("Insert Account:"));
	query5.add(jlblAccNum);
	query5.add(jtfAccNum);
	query5.add(jlblRelID);
	query5.add(jtfRelId);
	query5.add(accButtongourp);
	query5.add(jbtnInsertAccount);

	//Query 6
	JPanel query6 = new JPanel(new GridLayout(0,2));
	query6.setBorder(new TitledBorder("Start Job:"));
	query6.add(jlblJobId);
	query6.add(jtfJobId);
	query6.add(jlblJobAssId);
	query6.add(jtfJobAssId);
	query6.add(jlblJobInitDate);
	query6.add(jtfJobInitDate);
	query6.add(jlblJobProcId);
	query6.add(jtfJobProcId);
	query6.add(new JPanel());
	query6.add(jbtnStartJob);
	
	//Job Button group
	btngJobType.add(jrbtnPaintJob);
	btngJobType.add(jrbtnCutJob);
	btngJobType.add(jrbtnFitJob);
	jrbtnCutJob.setSelected(true);
	JPanel jobButtongourp = new JPanel(new GridLayout(1,3));
	jobButtongourp.add(jrbtnCutJob);
	jobButtongourp.add(jrbtnPaintJob);
	jobButtongourp.add(jrbtnFitJob);
	
	//Query 7
	JPanel query7 = new JPanel(new GridLayout(0,2));
	query7.setBorder(new TitledBorder("End Job:"));
	query7.add(jlblJobIdEnd);
	query7.add(jtfJobIdEnd);
	query7.add(jlblJobEndDate);
	query7.add(jtfJobEndDate);
	query7.add(jlblLaborTime);
	query7.add(jtfLaborTime);
	query7.add(jlblJobDetail1);
	query7.add(jtfJobDetail1);
	query7.add(jlblJobDetail2);
	query7.add(jtfJobDetail2);
	query7.add(jlblJobDetail3);
	query7.add(jtfJobDetail3);
	query7.add(jobButtongourp);
	query7.add(jbtnEndJob);
	
	//Query 8
	JPanel query8 = new JPanel(new GridLayout(0,2));
	query8.setBorder(new TitledBorder("Insert Transaction:"));
	query8.add(jlblTransId);
	query8.add(jtfTransId);
	query8.add(jlblSubCost);
	query8.add(jtfSubCost);
	query8.add(jlblTransJobId);
	query8.add(jtfTransJobId);
	query8.add(new JPanel());
	query8.add(jbtnInsertTransaction);
	
	//Adding panels to JFrame
	this.setLayout(new GridLayout(4,1));
	this.add(query5);
	this.add(query6);
	this.add(query7);
	this.add(query8);
    }

    public JLabel getJlblRelID() {
        return jlblRelID;
    }


    public void setJlblRelID(JLabel jlblRelID) {
        this.jlblRelID = jlblRelID;
    }


    public JLabel getJlblJobDetail1() {
        return jlblJobDetail1;
    }


    public void setJlblJobDetail1(JLabel jlblJobDetail1) {
        this.jlblJobDetail1 = jlblJobDetail1;
    }


    public JLabel getJlblJobDetail2() {
        return jlblJobDetail2;
    }


    public void setJlblJobDetail2(JLabel jlblJobDetail2) {
        this.jlblJobDetail2 = jlblJobDetail2;
    }


    public JLabel getJlblJobDetail3() {
        return jlblJobDetail3;
    }


    public void setJlblJobDetail3(JLabel jlblJobDetail3) {
        this.jlblJobDetail3 = jlblJobDetail3;
    }

    /**
     * @return the jtfAccNum
     */
    public JTextField getJtfAccNum() {
        return jtfAccNum;
    }
    
    /**
     * @return the jtfRelId
     */
    public JTextField getJtfRelId() {
        return jtfRelId;
    }

    /**
     * @return the jtfTransId
     */
    public JTextField getJtfTransId() {
        return jtfTransId;
    }

    /**
     * @return the jtfSubCost
     */
    public JTextField getJtfSubCost() {
        return jtfSubCost;
    }

    /**
     * @return the jtfTransJobId
     */
    public JTextField getJtfTransJobId() {
        return jtfTransJobId;
    }

    /**
     * @return the jtfJobId
     */
    public JTextField getJtfJobId() {
        return jtfJobId;
    }

    /**
     * @return the jtfJobAssId
     */
    public JTextField getJtfJobAssId() {
        return jtfJobAssId;
    }

    /**
     * @return the jtfJobInitDate
     */
    public JTextField getJtfJobInitDate() {
        return jtfJobInitDate;
    }

    /**
     * @return the jtfJobProcId
     */
    public JTextField getJtfJobProcId() {
        return jtfJobProcId;
    }

    /**
     * @return the jtfJobIdEnd
     */
    public JTextField getJtfJobIdEnd() {
        return jtfJobIdEnd;
    }

    /**
     * @return the jtfJobEndDate
     */
    public JTextField getJtfJobEndDate() {
        return jtfJobEndDate;
    }

    /**
     * @return the jtfLaborTime
     */
    public JTextField getJtfLaborTime() {
        return jtfLaborTime;
    }

    /**
     * @return the jtfJobDetail1
     */
    public JTextField getJtfJobDetail1() {
        return jtfJobDetail1;
    }

    /**
     * @return the jtfJobDetail2
     */
    public JTextField getJtfJobDetail2() {
        return jtfJobDetail2;
    }

    /**
     * @return the jtfJobDetail3
     */
    public JTextField getJtfJobDetail3() {
        return jtfJobDetail3;
    }

    /**
     * @return the jbtnInsertAccount
     */
    public JButton getJbtnInsertAccount() {
        return jbtnInsertAccount;
    }

    /**
     * @return the jbtnStartJob
     */
    public JButton getJbtnStartJob() {
        return jbtnStartJob;
    }

    /**
     * @return the jbtnEndJob
     */
    public JButton getJbtnEndJob() {
        return jbtnEndJob;
    }

    /**
     * @return the jbtnInsertTransaction
     */
    public JButton getJbtnInsertTransaction() {
        return jbtnInsertTransaction;
    }

    /**
     * @return the jrbtnDepAcc
     */
    public JRadioButton getJrbtnDepAcc() {
        return jrbtnDepAcc;
    }

    /**
     * @return the jrbtnAssAcc
     */
    public JRadioButton getJrbtnAssAcc() {
        return jrbtnAssAcc;
    }

    /**
     * @return the jrbtnProcAcc
     */
    public JRadioButton getJrbtnProcAcc() {
        return jrbtnProcAcc;
    }

    /**
     * @return the jrbtnPaintJob
     */
    public JRadioButton getJrbtnPaintJob() {
        return jrbtnPaintJob;
    }

    /**
     * @return the jrbtnCutJob
     */
    public JRadioButton getJrbtnCutJob() {
        return jrbtnCutJob;
    }

    /**
     * @return the jrbtnFitJob
     */
    public JRadioButton getJrbtnFitJob() {
        return jrbtnFitJob;
    }

    /**
     * @param jtfAccNum the jtfAccNum to set
     */
    public void setJtfAccNum(JTextField jtfAccNum) {
        this.jtfAccNum = jtfAccNum;
    }

    /**
     * @param jtfRelId the jtfRelId to set
     */
    public void setJtfRelId(JTextField jtfRelId) {
        this.jtfRelId = jtfRelId;
    }

    /**
     * @param jtfTransId the jtfTransId to set
     */
    public void setJtfTransId(JTextField jtfTransId) {
        this.jtfTransId = jtfTransId;
    }

    /**
     * @param jtfSubCost the jtfSubCost to set
     */
    public void setJtfSubCost(JTextField jtfSubCost) {
        this.jtfSubCost = jtfSubCost;
    }

    /**
     * @param jtfTransJobId the jtfTransJobId to set
     */
    public void setJtfTransJobId(JTextField jtfTransJobId) {
        this.jtfTransJobId = jtfTransJobId;
    }

    /**
     * @param jtfJobId the jtfJobId to set
     */
    public void setJtfJobId(JTextField jtfJobId) {
        this.jtfJobId = jtfJobId;
    }

    /**
     * @param jtfJobAssId the jtfJobAssId to set
     */
    public void setJtfJobAssId(JTextField jtfJobAssId) {
        this.jtfJobAssId = jtfJobAssId;
    }

    /**
     * @param jtfJobInitDate the jtfJobInitDate to set
     */
    public void setJtfJobInitDate(JTextField jtfJobInitDate) {
        this.jtfJobInitDate = jtfJobInitDate;
    }

    /**
     * @param jtfJobProcId the jtfJobProcId to set
     */
    public void setJtfJobProcId(JTextField jtfJobProcId) {
        this.jtfJobProcId = jtfJobProcId;
    }

    /**
     * @param jtfJobIdEnd the jtfJobIdEnd to set
     */
    public void setJtfJobIdEnd(JTextField jtfJobIdEnd) {
        this.jtfJobIdEnd = jtfJobIdEnd;
    }

    /**
     * @param jtfJobEndDate the jtfJobEndDate to set
     */
    public void setJtfJobEndDate(JTextField jtfJobEndDate) {
        this.jtfJobEndDate = jtfJobEndDate;
    }

    /**
     * @param jtfLaborTime the jtfLaborTime to set
     */
    public void setJtfLaborTime(JTextField jtfLaborTime) {
        this.jtfLaborTime = jtfLaborTime;
    }

    /**
     * @param jtfJobDetail1 the jtfJobDetail1 to set
     */
    public void setJtfJobDetail1(JTextField jtfJobDetail1) {
        this.jtfJobDetail1 = jtfJobDetail1;
    }

    /**
     * @param jtfJobDetail2 the jtfJobDetail2 to set
     */
    public void setJtfJobDetail2(JTextField jtfJobDetail2) {
        this.jtfJobDetail2 = jtfJobDetail2;
    }

    /**
     * @param jtfJobDetail3 the jtfJobDetail3 to set
     */
    public void setJtfJobDetail3(JTextField jtfJobDetail3) {
        this.jtfJobDetail3 = jtfJobDetail3;
    }

    /**
     * @param jbtnInsertAccount the jbtnInsertAccount to set
     */
    public void setJbtnInsertAccount(JButton jbtnInsertAccount) {
        this.jbtnInsertAccount = jbtnInsertAccount;
    }

    /**
     * @param jbtnStartJob the jbtnStartJob to set
     */
    public void setJbtnStartJob(JButton jbtnStartJob) {
        this.jbtnStartJob = jbtnStartJob;
    }

    /**
     * @param jbtnEndJob the jbtnEndJob to set
     */
    public void setJbtnEndJob(JButton jbtnEndJob) {
        this.jbtnEndJob = jbtnEndJob;
    }

    /**
     * @param jbtnInsertTransaction the jbtnInsertTransaction to set
     */
    public void setJbtnInsertTransaction(JButton jbtnInsertTransaction) {
        this.jbtnInsertTransaction = jbtnInsertTransaction;
    }

    /**
     * @param jrbtnDepAcc the jrbtnDepAcc to set
     */
    public void setJrbtnDepAcc(JRadioButton jrbtnDepAcc) {
        this.jrbtnDepAcc = jrbtnDepAcc;
    }

    /**
     * @param jrbtnAssAcc the jrbtnAssAcc to set
     */
    public void setJrbtnAssAcc(JRadioButton jrbtnAssAcc) {
        this.jrbtnAssAcc = jrbtnAssAcc;
    }

    /**
     * @param jrbtnProcAcc the jrbtnProcAcc to set
     */
    public void setJrbtnProcAcc(JRadioButton jrbtnProcAcc) {
        this.jrbtnProcAcc = jrbtnProcAcc;
    }

    /**
     * @param jrbtnPaintJob the jrbtnPaintJob to set
     */
    public void setJrbtnPaintJob(JRadioButton jrbtnPaintJob) {
        this.jrbtnPaintJob = jrbtnPaintJob;
    }

    /**
     * @param jrbtnCutJob the jrbtnCutJob to set
     */
    public void setJrbtnCutJob(JRadioButton jrbtnCutJob) {
        this.jrbtnCutJob = jrbtnCutJob;
    }

    /**
     * @param jrbtnFitJob the jrbtnFitJob to set
     */
    public void setJrbtnFitJob(JRadioButton jrbtnFitJob) {
        this.jrbtnFitJob = jrbtnFitJob;
    }
}
