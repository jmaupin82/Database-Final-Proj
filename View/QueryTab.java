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

public class QueryTab extends JPanel 
{
    private static final long serialVersionUID = 1L;
    
    //JLabels
    private JLabel jlblQ9Ass_id = new JLabel("Ass. ID:");
    private JLabel jlbQ9Result = new JLabel("Cost:");
    private JLabel jlblQ10Ass_id = new JLabel("Ass. ID:");
    private JLabel jlbQ10Result = new JLabel("Labor time:");
    private JLabel jlblQ11Dep_id = new JLabel("Dep. ID:");
    private JLabel jlblQ11Date = new JLabel("Date:");
    private JLabel jlblQ11Result = new JLabel("Total Labor time:");
    private JLabel jlblQ12Ass_id = new JLabel("Ass. ID:");

    //JTextFields
    private JTextField jtfQ9Ass_id = new JTextField();
    private JTextField jtfQ9Result = new JTextField();
    private JTextField jtfQ10Ass_id = new JTextField();
    private JTextField jtfQ10Result = new JTextField();
    private JTextField jtfQ11Dep_id = new JTextField();
    private JTextField jtfQ11Date = new JTextField();
    private JTextField jtfQ11Result = new JTextField();
    private JTextField jtfQ12Ass_id = new JTextField();
    
    //JButtons
    private JButton jbtnQ9 = new JButton("Retrieve");
    private JButton jbtnQ10 = new JButton("Retrieve");
    private JButton jbtnQ11 = new JButton("Retrieve");
    private JButton jbtnQ12 = new JButton("Retrieve");

    //JTables
    private JTable jtblQ12;

    private ProcTableModel tableModel = new ProcTableModel();
    public QueryTab()
    {
	//Query9
	JPanel query9 = new JPanel(new GridLayout(3,2));
	query9.setBorder(new TitledBorder("Retrieve cost on an assembly_id:"));
	query9.add(jlblQ9Ass_id);
	query9.add(jtfQ9Ass_id);
	query9.add(jlbQ9Result);
	jtfQ9Result.setEditable(false);
	query9.add(jtfQ9Result);
	query9.add(new JPanel());
	query9.add(jbtnQ9);

	//Query 10
	JPanel query10 = new JPanel(new GridLayout(3,2));
	query10.setBorder(new TitledBorder("Retrieve labor time on an assembly_id:"));
	query10.add(jlblQ10Ass_id);
	query10.add(jtfQ10Ass_id);
	query10.add(jlbQ10Result);
	jtfQ10Result.setEditable(false);
	query10.add(jtfQ10Result);
	query10.add(new JPanel());
	query10.add(jbtnQ10);
	
	//Query 11
	JPanel query11 = new JPanel(new GridLayout(0,2));
	query11.setBorder(new TitledBorder("Retrieve labor time on an department_id and date:"));
	query11.add(jlblQ11Dep_id);
	query11.add(jtfQ11Dep_id);
	query11.add(jlblQ11Date);
	query11.add(jtfQ11Date);
	query11.add(jlblQ11Result);
	jtfQ11Result.setEditable(false);
	query11.add(jtfQ11Result);
	query11.add(new JPanel());
	query11.add(jbtnQ11);
	
	//Query 12
	JPanel query12 = new JPanel(new GridLayout(0,2));
	query12.setBorder(new TitledBorder("Retrieve process based on an assembly id:"));
	//JTable Panel
	JPanel processTablePanel = new JPanel(new BorderLayout());
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	jtblQ12 = new JTable(tableModel);
	jtblQ12.setFillsViewportHeight(true);
	jtblQ12.setGridColor(Color.BLACK);
	jtblQ12.setDefaultRenderer(String.class, centerRenderer);
	JScrollPane processTableScrollPane = new JScrollPane(jtblQ12);
	processTablePanel.add(jtblQ12.getTableHeader(), BorderLayout.PAGE_START);
	processTablePanel.add(processTableScrollPane, BorderLayout.CENTER);
	
	//fields panel
	JPanel query12Fields = new JPanel(new GridLayout(3,1));
	query12Fields.add(jlblQ12Ass_id);
	query12Fields.add(jtfQ12Ass_id);
	query12Fields.add(jbtnQ12);
	query12.add(query12Fields);
	query12.add(processTablePanel);
	
	//Adding components to Panel
	this.setLayout(new GridLayout(0,1));
	this.add(query9);
	this.add(query10);
	this.add(query11);
	this.add(query12);

    }

    public void setData(ArrayList<Object[]> list)
    {
	Object [][] dat1 = new Object[list.size()][3];
	for(int i=0; i < list.size(); i++)
	{
	    dat1[i] = list.get(i);
	}
	
	this.tableModel.data = dat1;
	this.tableModel.fireTableDataChanged();
    }
    
    class ProcTableModel extends AbstractTableModel {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    public String[] columnNames ={"Proc_ID", "Proc_Data" ,"Depatment_ID"};
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

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the jtfQ9Ass_id
     */
    public JTextField getJtfQ9Ass_id() {
        return jtfQ9Ass_id;
    }

    /**
     * @return the jtfQ9Result
     */
    public JTextField getJtfQ9Result() {
        return jtfQ9Result;
    }

    /**
     * @return the jtfQ10Ass_id
     */
    public JTextField getJtfQ10Ass_id() {
        return jtfQ10Ass_id;
    }

    /**
     * @return the jtfQ10Result
     */
    public JTextField getJtfQ10Result() {
        return jtfQ10Result;
    }

    /**
     * @return the jtfQ11Dep_id
     */
    public JTextField getJtfQ11Dep_id() {
        return jtfQ11Dep_id;
    }

    /**
     * @return the jtfQ11Date
     */
    public JTextField getJtfQ11Date() {
        return jtfQ11Date;
    }

    /**
     * @return the jtfQ11Result
     */
    public JTextField getJtfQ11Result() {
        return jtfQ11Result;
    }

    /**
     * @return the jtfQ12Ass_id
     */
    public JTextField getJtfQ12Ass_id() {
        return jtfQ12Ass_id;
    }

    /**
     * @return the jbtnQ9
     */
    public JButton getJbtnQ9() {
        return jbtnQ9;
    }

    /**
     * @return the jbtnQ10
     */
    public JButton getJbtnQ10() {
        return jbtnQ10;
    }

    /**
     * @return the jbtnQ11
     */
    public JButton getJbtnQ11() {
        return jbtnQ11;
    }

    /**
     * @return the jbtnQ12
     */
    public JButton getJbtnQ12() {
        return jbtnQ12;
    }

    /**
     * @return the jtblQ12
     */
    public JTable getJtblQ12() {
        return jtblQ12;
    }

    /**
     * @param jtblQ12 the jtblQ12 to set
     */
    public void setJtblQ12(JTable jtblQ12) {
        this.jtblQ12 = jtblQ12;
    }
}
