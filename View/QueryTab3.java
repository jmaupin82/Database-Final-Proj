package View;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class QueryTab3 extends JPanel 
{

    private JLabel jlblPath = new JLabel("Import Users from a text file:");
    private JLabel jlblQ19 = new JLabel("Painting Method:");
    private JTextField jtfQ19 = new JTextField();
    
    private JButton jbtnQ18 = new JButton("Choose File.");
    private JButton jbtnQ19 = new JButton("Export Results to a file.");
    
    
    public QueryTab3()
    {
	JPanel query18 = new JPanel(new GridLayout(1,1));
	query18.setBorder(new TitledBorder("Import Users using a text file:"));
	query18.add(jlblPath);
	query18.add(jbtnQ18);
	
	JPanel query19 = new JPanel(new GridLayout(0,2));
	query19.setBorder(new TitledBorder("Retrieve customers based on RED Assemblies and painting method:"));
	query19.add(jlblQ19);
	query19.add(jtfQ19);
	query19.add(new JPanel());
	query19.add(jbtnQ19);
	
	
	this.setLayout(new GridLayout(0,1));
	this.add(query18);
	this.add(query19);
	this.add(new JPanel());
	this.add(new JPanel());
	this.add(new JPanel());
	this.add(new JPanel());
	this.add(new JPanel());
    }

    public JTextField getJtfQ19() {
        return jtfQ19;
    }

    /**
     * @return the jbtnQ18
     */
    public JButton getJbtnQ18() {
        return jbtnQ18;
    }
    /**
     * @return the jbtnQ19
     */
    public JButton getJbtnQ19() {
        return jbtnQ19;
    }

    public File getSelectedFile()
    {
	JFileChooser jfileChooser = new JFileChooser();
	int returnVal = jfileChooser.showOpenDialog(this);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    return jfileChooser.getSelectedFile();
	} else {
	    return null;
	}
    }

    public File getSaveFile()
    {
	JFileChooser jfileChooser = new JFileChooser();
	int returnVal = jfileChooser.showSaveDialog(this);
	jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    return new File (jfileChooser.getSelectedFile()+".txt");
	} else {
	    return null;
	}
    }
}


