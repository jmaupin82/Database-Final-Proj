package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBModel 
{
    private final String DB_ADDRESS = "jdbc:oracle:thin:@stu-oracle.cs.ou.edu:1521:cs4513db";
    private final String USER_NAME = "haji7580";
    private final String PASSWORD = "CGge0Ag1";
    
    public static final String CUT_PROC = "CUT";
    public static final String PAINT_PROC = "PAINT";
    public static final String FIT_PROC = "FIT";
    
    public static final String DEP_ACC = "DEPARTMENT";
    public static final String ASS_ACC = "ASSEMBLY";
    public static final String PROC_ACC = "PROCESS";
    
    private Object [] [] customer = {};
    private Object [] [] process = {};
    private Object [] [] jobs = {};
    
    private Connection dbConnection;
    /** List of registered ActionListeners. */
    private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
    
    
    public DBModel()
    {
	try {
	   dbConnection = DriverManager.getConnection(DB_ADDRESS,USER_NAME, PASSWORD);
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }
    
    
    public void addCustomer(String cus_name, String cus_address) throws SQLException
    {
	
	//Calling the procedure ADD_Faculty_1 with the user's parameters.
	CallableStatement pstmt = dbConnection.prepareCall("{call ADD_CUSTOMER(?,?)}");
	pstmt.setString(1, cus_name);
	pstmt.setString(2, cus_address);
	//Execute the procedure.
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void addDapartment(int dep_id, String dep_data) throws SQLException
    {
	//Calling the procedure ADD_Faculty_1 with the user's parameters.
	CallableStatement pstmt = dbConnection.prepareCall("{call ADD_DEPARTMENT(?,?)}");
	pstmt.setInt(1, dep_id);
	pstmt.setString(2, dep_data);
	//Execute the procedure.
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void addAssembly(int ass_id, String cus_name, String dateStr , String ass_details) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call ADD_ASSEMBLY(?,?,?,?)}");
	String [] dateArr = dateStr.split("/");
	pstmt.setString(1, cus_name);
	pstmt.setInt(2, ass_id);
	pstmt.setDate(3, new Date( Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]) ));
	pstmt.setString(4, ass_details);
	pstmt.executeUpdate();
	pstmt.close();
    }

    public void addProcess(int proc_id, int dep_id, String proc_data, String proc_type, String details_1, String details_2) throws SQLException
    {
	    CallableStatement pstmt = dbConnection.prepareCall("{call ADD_PROCESS(?,?,?,?,?,?)}");
	    pstmt.setInt(1, dep_id);
	    pstmt.setInt(2, proc_id);
	    pstmt.setString(3, proc_data);
	    pstmt.setString(4, proc_type);
	    pstmt.setString(5, details_1);
	    pstmt.setString(6, details_2);
	    pstmt.executeUpdate();
	    pstmt.close();
    }
    
    public void addAccount(int acc_id, int other_id, String acc_type) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call ADD_ACCOUNT(?,?,?)}");
	pstmt.setInt(1, acc_id);
	pstmt.setInt(2, other_id);
	pstmt.setString(3, acc_type);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void StartJob(int job_id, int ass_id, int proc_id, String dateStr) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call START_JOB(?,?,?,?)}");
	String [] dateArr = dateStr.split("/");
	pstmt.setInt(1, job_id);
	pstmt.setInt(2, ass_id);
	pstmt.setInt(3, proc_id);
	pstmt.setDate(4, new Date( Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[0])-1, Integer.parseInt(dateArr[1]) ));
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void endPaintJob(int job_id, String dateStr, String color, int volume, int laborTime) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call END_PAINT_JOB(?,?,?,?,?)}");
	pstmt.setInt(1, job_id);
	String [] dateArr = dateStr.split("/");
	pstmt.setDate(2, new Date( Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[0])-1, Integer.parseInt(dateArr[1]) ));
	pstmt.setString(3, color.toUpperCase());
	pstmt.setInt(4, volume);
	pstmt.setInt(5, laborTime);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void endCutJob(int job_id, String dateStr, String machineType, int usageTime,String usedMaterial, int laborTime) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call END_CUT_JOB(?,?,?,?,?,?)}");
	pstmt.setInt(1, job_id);
	String [] dateArr = dateStr.split("/");
	pstmt.setDate(2, new Date( Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[0])-1, Integer.parseInt(dateArr[1]) ));
	pstmt.setString(3, machineType.toUpperCase());
	pstmt.setInt(4, usageTime);
	pstmt.setString(5, usedMaterial.toUpperCase());
	pstmt.setInt(6, laborTime);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void endFitJob(int job_id, String dateStr, int laborTime) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call END_FIT_JOB(?,?,?)}");
	pstmt.setInt(1, job_id);
	String [] dateArr = dateStr.split("/");
	pstmt.setDate(2, new Date( Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[0])-1, Integer.parseInt(dateArr[1]) ));
	pstmt.setInt(3, laborTime);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void addTransaction(int trans_id, int job_id, float sub_cost) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call ADD_TRANSACTION(?,?,?)}");
	pstmt.setInt(1, trans_id);
	pstmt.setInt(2, job_id);
	pstmt.setFloat(3, sub_cost);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public float retrieveCostOnAssembly(int ass_id)
    {
	
    }
    
    public int retrieveLaborTimeOnAssembly(int ass_id)
    {
	
    }
    
    public 
    
    /**
     * Adds a new ActionListener for notifying views
     * 
     * @param al
     */
    public void addActionListener( ActionListener al ) {
	if (actionListenerList == null)
	    actionListenerList = new ArrayList<ActionListener>();
	actionListenerList.add( al );
    }

    /**
     * Removes the <code>al</code> from the listener list
     * 
     * @param al
     */
    public void removeActionListener( ActionListener al ) {
	if (actionListenerList != null && actionListenerList.contains( al ))
	    actionListenerList.remove( al );
    }

    /**
     * ProcessEvent to notify the registered views 
     * @param e
     */
    @SuppressWarnings("unused")
    private void processEvent( ActionEvent e ) {
	ArrayList<ActionListener> list;

	synchronized (this) {
	    if (actionListenerList == null)
		return;
	    list = new ArrayList<ActionListener>();
	    list.addAll( actionListenerList );
	}

	for (int i = 0; i < list.size(); i++) {
	    ActionListener listener = list.get( i );
	    listener.actionPerformed( e );
	}
    }

}
