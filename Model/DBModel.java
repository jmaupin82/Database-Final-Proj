package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	pstmt.setDate(3, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
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
	pstmt.setDate(4, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void endPaintJob(int job_id, String dateStr, String color, int volume, int laborTime) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call END_PAINT_JOB(?,?,?,?,?)}");
	pstmt.setInt(1, job_id);
	String [] dateArr = dateStr.split("/");
	pstmt.setDate(2, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
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
	pstmt.setDate(2, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
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
	pstmt.setDate(2, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
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
    
    public float retrieveCostOnAssembly(int ass_id) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{? = call GET_COST_ON_ASSEMBLY(?)}");
	pstmt.registerOutParameter(1, Types.FLOAT);
	pstmt.setInt(2, ass_id);
	pstmt.executeUpdate();
	return pstmt.getFloat(1);
    }
    
    public int retrieveLaborTimeOnAssembly(int ass_id) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{? = call GET_LABOR_ON_ASSEMBLY(?)}");
	pstmt.registerOutParameter(1, Types.INTEGER);
	pstmt.setInt(2, ass_id);
	pstmt.executeUpdate();
	return pstmt.getInt(1);
    }
    
    public int retrieveLaborTimeOnDepartment(int dep_id,String dateStr) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{? = call GET_LABOR_ON_DEPARTMENT(?,?)}");
	pstmt.registerOutParameter(1, Types.INTEGER);
	pstmt.setInt(2, dep_id);
	String [] dateArr = dateStr.split("/");
	pstmt.setDate(3, java.sql.Date.valueOf( dateArr[2]+"-"+dateArr[0]+"-"+dateArr[1]));
	pstmt.executeUpdate();
	return pstmt.getInt(1);
    }
    
    
    
    public ArrayList<Object [] > retrieveProcess(int ass_id) throws SQLException
    {
	Statement stmt = dbConnection.createStatement();
	ResultSet rset = stmt.executeQuery("SELECT process.proc_id, process.proc_data, process.dep_id FROM process, JOB WHERE "
    +"process.proc_id = job.proc_id  AND job.ass_id = "+ ass_id +" AND job.end_date < CURRENT_DATE ORDER BY job.init_date");
	ArrayList<Object [] > list = new ArrayList<Object[]>();
	while (rset.next()) 
	{
	    Object [] tmp = new Object[3];
	    tmp[0] = rset.getString(1);
	    tmp[1] = rset.getString(2);
	    tmp[2] = rset.getString(3);
	    list.add(tmp);
	}

	return list;
    }
    
    public ArrayList<Object [] > retrieveJobs(int dep_id, String dateStr) throws SQLException
    {
	Statement stmt = dbConnection.createStatement();
	ResultSet rset = stmt.executeQuery("(SELECT * FROM JOB WHERE JOB.end_date = '" + dateStr  +"' AND JOB.proc_id IN " +
	"(SELECT  proc_id FROM process, department WHERE process.dep_id = department.dep_id AND department.dep_id = " + String.valueOf(dep_id)+ " ))");
	ArrayList<Object [] > list = new ArrayList<Object[]>();
	while (rset.next()) 
	{
	    Object [] tmp = new Object[6];
	    tmp[0] = rset.getString(1);
	    tmp[1] = rset.getString(2);
	    tmp[2] = rset.getString(3);
	    tmp[3] = rset.getString(4);
	    tmp[4] = rset.getString(5);
	    tmp[5] = rset.getString(6);
	    list.add(tmp);
	}

	return list;
	
    }
    
    public ArrayList<Object [] > retrieveCustomer(String painting_method) throws SQLException
    {
	Statement stmt = dbConnection.createStatement();
	ResultSet rset = stmt.executeQuery(""
		+ "SELECT * FROM customer, assembly WHERE customer.cus_name = assembly.cus_name AND assembly.ass_id IN "
		+ "((SELECT ass_id FROM JOB, paint_job WHERE JOB.job_id = paint_job.job_id AND paint_job.color='RED')"
		+ " INTERSECT "
		+ "(SELECT ass_id FROM paint_proc, pass_through WHERE paint_proc.proc_id ="
		+ " pass_through.proc_id AND paint_proc.paint_method = '"+ painting_method  + "' )) ORDER BY customer.cus_name");
	ArrayList<Object [] > list = new ArrayList<Object[]>();
	while (rset.next()) 
	{
	    Object [] tmp = new Object[2];
	    tmp[0] = rset.getString(1);
	    tmp[1] = rset.getString(2);
	    list.add(tmp);
	}

	return list;
    }
    
    public void deleteJobRange(int job_id_start, int job_id_end) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call DELETE_CUT_JOBS(?,?)}");
	pstmt.setInt(1, job_id_start);
	pstmt.setInt(2, job_id_end);
	pstmt.executeUpdate();
	pstmt.close();
    }
    
    public void changeColor(int job_id, String color) throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{call CHANGE_COLOR(?,?)}");
	pstmt.setInt(1, job_id);
	pstmt.setString(2, color);
	pstmt.executeUpdate();
	pstmt.close();  
    }
    
    public float retrieveAveCost() throws SQLException
    {
	CallableStatement pstmt = dbConnection.prepareCall("{? = call AVE_COST}");
	pstmt.registerOutParameter(1, Types.FLOAT);
	pstmt.executeUpdate();
	return pstmt.getFloat(1);
    }
    


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
