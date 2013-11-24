package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class InsertTab extends Tab 
{
    private JLabel jlblcusName = new JLabel("Name:");
    private JLabel jlblcusAddr = new JLabel("Address:");
    
    private JTextField jtfcusName = new JTextField();
    private JTextField jtfcusAddr = new JTextField();
    
    private JButton jbtnInsertCustomer = new JButton("Insert Customer");
    
    public InsertTab()
    {
//	(int gridx,int gridy,int gridwidth,int gridheight,double weightx,double weighty,int anchor, int fill,Insets insets,int ipadx,int ipady);
	JPanel query1 = new JPanel();
	query1.setBorder(new TitledBorder("Insert Customer:"));
	query1.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints(0,0,1,1,0.0,1,
		GridBagConstraints.FIRST_LINE_START,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
	query1.add(jlblcusName, c);
	GridBagConstraints c1 = new GridBagConstraints(1,0,GridBagConstraints.REMAINDER,1,1,1,
			GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL ,new Insets(0,0,0,0),0,0);
	query1.add(jtfcusName, c1);
	GridBagConstraints c2 = new GridBagConstraints(0,1,1,1,1,1,
			GridBagConstraints.LINE_START,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
	query1.add(jlblcusAddr, c2);
	GridBagConstraints c3 = new GridBagConstraints(1,1,1,1,1,1,
			GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0);
	query1.add(jtfcusAddr, c3);
	
	c3 = new GridBagConstraints(3,2,1,1,1,1,
		GridBagConstraints.LAST_LINE_END,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
	query1.add(jbtnInsertCustomer, c3);
	
	
	JPanel query2 = new JPanel();
	query2.setBorder(new TitledBorder("Insert Department:"));
	JPanel query3 = new JPanel();
	query3.setBorder(new TitledBorder("Insert Assembly:"));
	JPanel query4 = new JPanel();
	query4.setBorder(new TitledBorder("Insert Process:"));
	JPanel query5 = new JPanel();
	query5.setBorder(new TitledBorder("Insert Account:"));
	JPanel query6 = new JPanel();
	query6.setBorder(new TitledBorder("Insert Job:"));
	JPanel query7 = new JPanel();
	query7.setBorder(new TitledBorder("End Job:"));
	JPanel query8 = new JPanel();
	query8.setBorder(new TitledBorder("Insert Transaction:"));
	
	
	this.setLayout(new GridLayout(4,1));
	this.add(query1);
	this.add(query2);
	this.add(query3);
	this.add(query4);
//	this.add(query5);
//	this.add(query6);
//	this.add(query7);
//	this.add(query8);
	
    }

}
