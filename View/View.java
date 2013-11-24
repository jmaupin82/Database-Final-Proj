package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Model.DBModel;

public class View extends JFrame implements ActionListener
{
    private DBModel model;
    
    private JTabbedPane jtabbedPane = new JTabbedPane();
    private JTable jtableResults = new JTable();
    private JButton jbtnExit = new JButton("Exit");
    
    public View()
    {
	this.jtabbedPane.addTab("Insertion",new InsertTab());
	this.jtabbedPane.addTab("Page 1",null);
	this.jtabbedPane.addTab("Page 2",null);
	this.jtabbedPane.addTab("Page 3",null);
	
	this.setLayout(new GridBagLayout());


//	(int gridx,int gridy,int gridwidth,int gridheight,double weightx,double weighty,int anchor, int fill,Insets insets,int ipadx,int ipady);
	GridBagConstraints c = new GridBagConstraints(0,0, GridBagConstraints.REMAINDER, 2 ,1 , 1,
		GridBagConstraints.FIRST_LINE_START,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
	this.add(this.jtabbedPane, c);
	
//	GridBagConstraints c1 = new GridBagConstraints(0,1, GridBagConstraints.REMAINDER,1,1,1,
//		GridBagConstraints.LINE_START,GridBagConstraints.BOTH,new Insets(0,10,0,0),0,0);
//	
//	jtableResults.setBorder(new TitledBorder("Results"));
//	this.add(this.jtableResults, c1);
	
	
	GridBagConstraints c2 = new GridBagConstraints(0,2,1,1,1,0.1,GridBagConstraints.LAST_LINE_END,GridBagConstraints.NONE,new Insets(0,0,0,0),0,0);
	this.add(this.jbtnExit, c2);
	
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int xSize = ((int) tk.getScreenSize().getWidth()-50);  
	int ySize = ((int) tk.getScreenSize().getHeight()-100);  
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(xSize, ySize);
//	this.pack();
	this.setLocationRelativeTo(null);
	this.setVisible(true);
    }

    /**
     * Mutator for surveyModel
     * @param SurveyModel
     */
    public void setDBModel(DBModel m)
    {
	this.model = m;
	if (model != null) {
	    this.model.addActionListener( this );
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }
}
