package View;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Model.DBModel;

public class View extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;
    //Database model
    private DBModel model;
    //Tabbed pane 
    private JTabbedPane jtabbedPane = new JTabbedPane();
    
    //Different tabs for queries
    private InsertTab insertionPanel = new InsertTab();
    private InsertTab2 insertionPanel2 = new InsertTab2();
    private QueryTab queryPanel1 = new QueryTab();
    private QueryTab2 queryPanel2 = new QueryTab2();
    private QueryTab3 queryPanel3 = new QueryTab3();
   
    //Buttons
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnRefresh = new JButton("Refresh");
    
    public View()
    {
	//Filling the panels
	this.jtabbedPane.addTab("Insertion",insertionPanel);
	this.jtabbedPane.addTab("Insertion Cont'", insertionPanel2 );
	this.jtabbedPane.addTab("Query", queryPanel1);
	this.jtabbedPane.addTab("Query Cont'",queryPanel2);
	this.jtabbedPane.addTab("Query Cont'", queryPanel3);
	
	//Making button panel
	JPanel buttonPanel = new JPanel(new GridLayout(1,2));
	buttonPanel.add(jbtnRefresh);
	buttonPanel.add(jbtnExit);
	
	//Adding everything to the container
	this.setLayout(new BorderLayout());
	this.add(this.jtabbedPane, BorderLayout.CENTER);	
	this.add(buttonPanel, BorderLayout.SOUTH);
	
	//setting the screen size
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Toolkit tk = Toolkit.getDefaultToolkit();  
	int ySize = ((int) tk.getScreenSize().getHeight()-50);  
	this.setSize(650, ySize);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
    }

    /**
     * @return the insertionPanel
     */
    public InsertTab getInsertionPanel() {
        return insertionPanel;
    }

    /**
     * @return the insertionPanel2
     */
    public InsertTab2 getInsertionPanel2() {
        return insertionPanel2;
    }

    /**
     * @return the queryPanel1
     */
    public QueryTab getQueryPanel1() {
        return queryPanel1;
    }

    /**
     * @return the queryPanel2
     */
    public QueryTab2 getQueryPanel2() {
        return queryPanel2;
    }

    /**
     * @return the queryPanel3
     */
    public QueryTab3 getQueryPanel3() {
        return queryPanel3;
    }

    /**
     * @return the jbtnExit
     */
    public JButton getJbtnExit() {
        return jbtnExit;
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
