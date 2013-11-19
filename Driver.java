import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
	try
	{
	    // loading the driver class from sql library
	    Class.forName("oracle.jdbc.OracleDriver");
	}
	catch (Exception e) 
	{
	    System.out.println("Unable to load the driver class!");
	    System.exit(-1);
	}

	try 
	{
	    // Connection to the database
	    Connection dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@stu-oracle.cs.ou.edu:1521:cs4513db","haji7580", "CGge0Ag1");
	    //Reading user input
	    Scanner inputReader = new Scanner(System.in);
	    
	    //Taking action on user input by calling the right method.
	    while (true) 
	    {
		System.out.println("Enter 1 for inserting a faculty (1).\nEnter 2 for inserting a faculty (2)."
			    	+ "\nEnter 3 for display faculty info.\nEnter 4 to exit.");
		int userOption;
		try
		{
		    userOption = inputReader.nextInt();
		}
		catch (InputMismatchException e)
		{
		    System.out.println("Please enter a number from 1 to 4");
		    inputReader.next();
		    continue;
		}
		// insert faculty with procedure 1
		if (userOption == 1) 
		{
		    insertFaculty1(dbConnection, inputReader);
		}
		// insert faculty with procedure 2
		else if (userOption == 2) 
		{
		    insertFaculty2(dbConnection, inputReader);
		} 
		//showing all the faculty's info
		else if (userOption == 3) 
		{
		    fetchTable(dbConnection);
		} 
		//terminating the program
		else if (userOption == 4) 
		{
		    System.out.println("Terminating ...");
		    dbConnection.close();
		    System.exit(0);
		} 
		// wrong input
		else 
		{
		    System.out.println("Please enter a number from 1 to 4.");
		}

	    }

	} 
	catch (SQLException e) 
	{
	    System.err.println(e.getMessage());
	    System.exit(-1);
	}
    }

    /**
     * This method insert a faculty using the first procedure for calculating the salary.
     * @param Connection, Scanner
     * @return void
     */
    public static void insertFaculty1(Connection db, Scanner inputReader) 
    {
	int fid;
	String fname;
	int depid;
	//Reading the user's input.
	try
	{
	    System.out.println("Please enter the faculty id ...");
	    fid = inputReader.nextInt();
	    System.out.println("Please enter the faculty name ...");
	    fname = inputReader.next();
	    System.out.println("Please enter the faculty department id ...");
	    depid = inputReader.nextInt();
	}
	catch (InputMismatchException e)
	{
	    System.out.println("Wrong inpur, Please try again.");
	    inputReader.next();
	    return;
	}
	
	try 
	{
	    //Calling the procedure ADD_Faculty_1 with the user's parameters.
	    CallableStatement pstmt = db.prepareCall("{call ADD_FACULTY_1(?,?,?)}");
	    pstmt.setInt(1, fid);
	    pstmt.setString(2, fname);
	    pstmt.setInt(3, depid);
	    //Execute the procedure.
	    pstmt.executeUpdate();
	    pstmt.close();
	} 
	catch (SQLException e) 
	{
	    System.err.println("Insertion failed\n" + e.getMessage());
	}

    }

    /**
     * This method insert a faculty using the second procedure for calculating the salary.
     * @param Connection, Scanner
     * @return void
     */
    public static void insertFaculty2(Connection db, Scanner inputReader) 
    {
	int fid;
	String fname;
	int depid;
	int excludeDep;
	//Reading the user's input.
	try
	{
	    System.out.println("Please enter the faculty id ...");
	    fid = inputReader.nextInt();
	    System.out.println("Please enter the faculty name ...");
	    fname = inputReader.next();
	    System.out.println("Please enter the faculty department id ...");
	    depid = inputReader.nextInt();
	    System.out.println("Please enter the department id that you want to exclude for salary calculation ...");
	    excludeDep = inputReader.nextInt();
	}
	catch (InputMismatchException e)
	{
	    System.out.println("Wrong inpur, Please try again.");
	    inputReader.next();
	    return;
	}
	
	try 
	{
	    //Calling the procedure ADD_Faculty_2 with the user's parameters.
	    CallableStatement pstmt = db.prepareCall("{call ADD_FACULTY_2(?,?,?,?)}");
	    pstmt.setInt(1, fid);
	    pstmt.setString(2, fname);
	    pstmt.setInt(3, depid);
	    pstmt.setInt(4, excludeDep);
	    //Execute the procedure.
	    pstmt.executeUpdate();
	    pstmt.close();
	} 
	catch (SQLException e) 
	{
	    System.err.println("Insertion failed\n" + e.getMessage());
	}
    }

   /**
    * This method query all the faculty and print them to the console.
    * @param Connection
    * @return void
    */
    public static void fetchTable(Connection db) 
    {
	try 
	{
	    Statement stmt = db.createStatement();
	    //SQL statement for query.
	    ResultSet rset = stmt.executeQuery("select * from faculty");
	    System.out.println("fid\tfname\tdeptid\tslary");
	    //printing the results.
	    while (rset.next()) 
	    {
		System.out.println(rset.getString(1) + "\t" + rset.getString(2) + "\t" + rset.getString(3) + "\t" + rset.getString(4));
	    }
	} 
	catch (SQLException e) 
	{
	    System.err.println("Query failed\n" + e.getMessage());
	}
    }

}
