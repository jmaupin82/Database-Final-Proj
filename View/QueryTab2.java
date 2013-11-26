package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class QueryTab2 extends JPanel
{

    private static final long serialVersionUID = 1L;
    //JTextFields
    private JLabel jlblQ13DepId = new JLabel("Dep. ID:");
    private JLabel jlblQ13Date = new JLabel("Date(DD-MM-YY):");
    private JLabel jlblQ14 = new JLabel("Painting Method:");
    private JLabel jlblQ15JobIdStart = new JLabel("Job id start:");
    private JLabel jlblQ15JobIdEnd = new JLabel("Job id end:");
    private JLabel jlblQ16JobId = new JLabel("Job id:");
    private JLabel jlblQ16Color = new JLabel("Color:");
    private JLabel jlblQ17Average = new JLabel("Average:");
    
    //TextFields
    private JTextField jtfQ13DepId = new JTextField();
    private JTextField jtfQ13Date = new JTextField();
    private JTextField jtfQ14 = new JTextField();
    private JTextField jtfQ15JobIdStart = new JTextField();
    private JTextField jtfQ15JobIdEnd = new JTextField();
    private JTextField jtfQ16JobId = new JTextField();
    private JTextField jtfQ16Color = new JTextField();
    private JTextField jtfQ17Result = new JTextField();

    //JButtons
    private JButton jbtnQ13 = new JButton("Retrieve");
    private JButton jbtnQ14 = new JButton("Retrieve");
    private JButton jbtnQ15 = new JButton("Detele");
    private JButton jbtnQ16 = new JButton("Change");
    private JButton jbtnQ17 = new JButton("Retrieve");
    
    //JTables
    private JTable jtblQ13;
    private JTable jtblQ14;
    
    //Table Models
    private JobTableModel jobTableModel = new JobTableModel();
    private CustomerTableModel customerTableModel = new CustomerTableModel();
    
    public QueryTab2()
    {
	//Query 13
	JPanel query13 = new JPanel(new GridLayout(2,1));
	query13.setBorder(new TitledBorder("Retrieve jobs based on date and department:"));
	//JTable Panel
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	JPanel jobsTablePanel = new JPanel(new BorderLayout());
	jtblQ13 = new JTable(jobTableModel);
	jtblQ13.setFillsViewportHeight(true);
	jtblQ13.setGridColor(Color.BLACK);
	jtblQ13.setDefaultRenderer(String.class, centerRenderer);
	JScrollPane jobTableScrollPane = new JScrollPane(jtblQ13);
	jobsTablePanel.add(jtblQ13.getTableHeader(), BorderLayout.PAGE_START);
	jobsTablePanel.add(jobTableScrollPane, BorderLayout.CENTER);

	//fields panel
	JPanel query13Fields = new JPanel(new GridLayout(0,2));
	query13Fields.add(jlblQ13DepId);
	query13Fields.add(jtfQ13DepId);
	query13Fields.add(jlblQ13Date);
	query13Fields.add(jtfQ13Date);
	query13Fields.add(new JPanel());
	query13Fields.add(jbtnQ13);
	query13.add(query13Fields);
	query13.add(jobsTablePanel);
	
	//Query 14
	JPanel query14 = new JPanel(new GridLayout(1,2));
	query14.setBorder(new TitledBorder("Retrieve customers based on RED Assemblies and painting method:"));
	//JTable Panel
	JPanel customerTablePanel = new JPanel(new BorderLayout());
	jtblQ14 = new JTable(customerTableModel);
	jtblQ14.setFillsViewportHeight(true);
	jtblQ14.setGridColor(Color.BLACK);
	jtblQ14.setDefaultRenderer(String.class, centerRenderer);
	JScrollPane customerTableScrollPane = new JScrollPane(jtblQ14);
	customerTablePanel.add(jtblQ14.getTableHeader(), BorderLayout.PAGE_START);
	customerTablePanel.add(customerTableScrollPane, BorderLayout.CENTER);

	//fields panel
	JPanel query14Fields = new JPanel(new GridLayout(3,1));
	query14Fields.add(jlblQ14);
	query14Fields.add(jtfQ14);
	query14Fields.add(jbtnQ14);
	query14.add(query14Fields);
	query14.add(customerTablePanel);
	
	//Query 15 Panel
	JPanel query15 = new JPanel(new GridLayout(0,2));
	query15.setBorder(new TitledBorder("Delete cut jobs ina Range:"));
	query15.add(jlblQ15JobIdStart);
	query15.add(jtfQ15JobIdStart);
	query15.add(jlblQ15JobIdEnd);
	query15.add(jtfQ15JobIdEnd);
	query15.add(new JPanel());
	query15.add(jbtnQ15);
	
	//Query 16 Panel
	JPanel query16 = new JPanel(new GridLayout(0,2));
	query16.setBorder(new TitledBorder("Change the color of a job:"));
	query16.add(jlblQ16JobId);
	query16.add(jtfQ16JobId);
	query16.add(jlblQ16Color);
	query16.add(jtfQ16Color);
	query16.add(new JPanel());
	query16.add(jbtnQ16);
	
	//Query 17 Panel
	JPanel query17 = new JPanel(new GridLayout(0,2));
	query17.setBorder(new TitledBorder("Retrieve the average for all accounts:"));
	query17.add(jlblQ17Average);
	jtfQ17Result.setEditable(false);
	query17.add(jtfQ17Result);
	query17.add(new JPanel());
	query17.add(jbtnQ17);
	
	//adding components to panel
	this.setLayout(new GridLayout(0,1));
	this.add(query13);
	this.add(query14);
	this.add(query15);
	this.add(query16);
	this.add(query17);
    }
    
    public void setCustomerData(ArrayList<Object[]> list)
    {
	Object [][] dat1 = new Object[list.size()][2];
	for(int i=0; i < list.size(); i++)
	{
	    dat1[i] = list.get(i);
	}
	
	this.customerTableModel.data = dat1;
	this.customerTableModel.fireTableDataChanged();
    }
    
    class JobTableModel extends AbstractTableModel {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    public String[] columnNames ={"Job_id", "init_dat" ,"end_date", "labor" , "proc_id", "ass_id"};
	    public Object[][] data ={};

	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }

	    public boolean isCellEditable(int row, int col) {
	        if (col < 2) {
	            return false;
	        } else {
	            return true;
	        }
	    }

	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	}

    public void setJobData(ArrayList<Object[]> list)
    {
	Object [][] dat1 = new Object[list.size()][3];
	for(int i=0; i < list.size(); i++)
	{
	    dat1[i] = list.get(i);
	}
	
	this.jobTableModel.data = dat1;
	this.jobTableModel.fireTableDataChanged();
    }
    
    class CustomerTableModel extends AbstractTableModel {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    public String[] columnNames ={"Name", "Address"};
	    public Object[][] data ={};

	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

	    public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }

	    public boolean isCellEditable(int row, int col) {
	        if (col < 2) {
	            return false;
	        } else {
	            return true;
	        }
	    }

	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	}

    public JTextField getJtfQ17Result() {
        return jtfQ17Result;
    }
    public JTextField getJtfQ13DepId() {
        return jtfQ13DepId;
    }
    public JTextField getJtfQ13Date() {
        return jtfQ13Date;
    }
    public JTextField getJtfQ14() {
        return jtfQ14;
    }
    public JTextField getJtfQ15JobIdStart() {
        return jtfQ15JobIdStart;
    }
    public JTextField getJtfQ15JobIdEnd() {
        return jtfQ15JobIdEnd;
    }
    public JTextField getJtfQ16JobId() {
        return jtfQ16JobId;
    }
    public JTextField getJtfQ16Color() {
        return jtfQ16Color;
    }
    public JTable getJtblQ13() {
        return jtblQ13;
    }
    public JTable getJtblQ14() {
        return jtblQ14;
    }
    /**
     * @return the jbtnQ13
     */
    public JButton getJbtnQ13() {
        return jbtnQ13;
    }
    /**
     * @return the jbtnQ14
     */
    public JButton getJbtnQ14() {
        return jbtnQ14;
    }
    /**
     * @return the jbtnQ15
     */
    public JButton getJbtnQ15() {
        return jbtnQ15;
    }
    /**
     * @return the jbtnQ16
     */
    public JButton getJbtnQ16() {
        return jbtnQ16;
    }
    
    public JButton getJbtnQ17() {
        return jbtnQ17;
    }

}
