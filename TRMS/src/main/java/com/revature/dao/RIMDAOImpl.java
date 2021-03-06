package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Department;
import com.revature.beans.EmpTitle;
import com.revature.beans.EventType;
import com.revature.beans.GradeFormat;
import com.revature.beans.Reimbursement;
import com.revature.beans.ViewRim;
import com.revature.util.ConnFactory;

public class RIMDAOImpl {
	
public static ConnFactory banana = ConnFactory.getInstance();
		
	//insert reimbursement
	public void insertRIM(Reimbursement rim) throws SQLException {
		Connection conn = banana.getConnection();
		
		String sql = "{ call APPLY_RIM(?,?,?,?,?,?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setLong(1, rim.geteID());
		call.setDouble(2, rim.gettFees());
		call.setInt(3,rim.geteType());
		call.setDate(4,rim.geteDate());
		call.setString(5, rim.getLocation());
		call.setString(6, rim.getDesc());
		call.setInt(7,rim.getgFormat());
		call.setString(8,rim.getJustifi());
		call.setInt(9, rim.getMDays());
		
		double prim=0;
		switch (rim.geteType()) {
		case 1:
			prim=((rim.gettFees()*80)/100);
			break;
		case 2:
			prim=((rim.gettFees()*60)/100);
			break;
		case 3:
			prim=((rim.gettFees()*75)/100);
			break;
		case 4:
			prim=((rim.gettFees()*100)/100);
			break;
		case 5:
			prim=((rim.gettFees()*90)/100);
			break;
		case 6:
			prim=((rim.gettFees()*30)/100);
			break;
		}
		
		call.setDouble(10, prim);
		
		call.execute();
		conn.close();
	}
	
	//Update Grades by employee
	public void updateGrade(String id,String eGrade) throws SQLException {
		Connection conn = banana.getConnection();
		
		String sql = "{ call UPDATE_GRADE(?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		
		call.setLong(1, Long.parseLong(id));
		call.setString(2,eGrade);
	
		call.execute();
	}
	
	//Update Status of Reimbursement
		public void updateStatus(String id,String status,String statusby,String notes) throws SQLException {
			Connection conn = banana.getConnection();
			
			String sql = "{ call UPDATE_STATUS(?,?,?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setLong(1, Long.parseLong(id));
			call.setString(2,status);
			call.setString(3,statusby);
			call.setString(4,notes);
		
			call.execute();
			conn.close();
		}
	
	//get all Employee Title
	public  List<EmpTitle> getEmpTitle() throws SQLException {
		EmpTitle et = null;
		List<EmpTitle> etList = new ArrayList<EmpTitle>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EMPLOYEE_TITLE");
		while(rs.next()) {
			et=new EmpTitle(rs.getInt(1),rs.getString(2));
			etList.add(et);
		}
		conn.close();
		return etList;
	}
	
	//get all Departments
	public  List<Department> getDEPT() throws SQLException {
		Department d = null;
		List<Department> dList = new ArrayList<Department>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM DEPARTMENT");
		while(rs.next()) {
			d=new Department(rs.getInt(1),rs.getString(2));
			dList.add(d);
		}
		conn.close();
		return dList;
	}
	
	//get all Event Type
	public  List<EventType> getEType() throws SQLException {
		EventType et = null;
		List<EventType> etList = new ArrayList<EventType>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EVENT_TYPE");
		while(rs.next()) {
			et=new EventType(rs.getInt(1),rs.getString(2),rs.getInt(3));
			etList.add(et);
		}
		conn.close();
		return etList;
	}
	
	//get all Grade Format
	public  List<GradeFormat> getGF() throws SQLException {
		GradeFormat gf = null;
		List<GradeFormat> gfList = new ArrayList<GradeFormat>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM GRADING_FORMAT");
		while(rs.next()) {
			gf=new GradeFormat(rs.getInt(1),rs.getString(2),rs.getString(3));
			gfList.add(gf);
		}
		conn.close();
		return gfList;
	}
	
	//get all Reimbursement to view
	public List<ViewRim> getViewAllRim(long eID,String eTitle,String eDept) throws SQLException{
		ViewRim vr = null;
	
		
		List<ViewRim> vrList = new ArrayList<ViewRim>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		String sql;
		String dh="Department Head";
		String ds="Direct Supervisor";
		String bc="Benifits Coordinator";
		String emp="Associate";
		String s="Sales";
		String hr="Human Resources";
		String pr="Production";
		
//		if(eDept.equalsIgnoreCase(hr) && eTitle.equalsIgnoreCase(dh)) {
//			
//			sql="SELECT REIMBURSEMENT.REIMBURSEMENT_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
//					"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
//					"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
//					"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY,REIMBURSEMENT.REIMBURSEMENT_NOTES FROM REIMBURSEMENT " + 
//					"JOIN EMPLOYEE " + 
//					"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
//					"JOIN EVENT " + 
//					"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
//					"JOIN EVENT_TYPE " + 
//					"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " + 
//					"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID";
//			
//		} else if(eDept.equalsIgnoreCase(hr) && eTitle.equalsIgnoreCase(ds)) {
//			
//			sql="SELECT REIMBURSEMENT.REIMBURSEMENT_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
//					"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
//					"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
//					"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY,REIMBURSEMENT.REIMBURSEMENT_NOTES FROM REIMBURSEMENT " + 
//					"JOIN EMPLOYEE " + 
//					"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
//					"JOIN EVENT " + 
//					"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
//					"JOIN EVENT_TYPE " + 
//					"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " + 
//					"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID";
//			
//		}
			
		
		
		ResultSet rs=stmt.executeQuery("SELECT REIMBURSEMENT.REIMBURSEMENT_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY,REIMBURSEMENT.REIMBURSEMENT_NOTES FROM REIMBURSEMENT " + 
				"JOIN EMPLOYEE " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
				"JOIN EVENT " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
				"JOIN EVENT_TYPE " + 
				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " + 
				"WHERE REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID!="+eID+
				" ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
		while(rs.next()) {		
			vr=new ViewRim(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13));
			vrList.add(vr);
			System.out.println(vr);
		}
		
		conn.close();
		return vrList;
		
	}
	
	//get all Reimbursements of specific employee to view
	public List<ViewRim> getMyRims(long empID) throws SQLException{
		ViewRim vr = null;

		
		List<ViewRim> vrList = new ArrayList<ViewRim>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT REIMBURSEMENT.REIMBURSEMENT_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY,REIMBURSEMENT.REIMBURSEMENT_NOTES FROM REIMBURSEMENT " + 
				"JOIN EMPLOYEE " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
				"JOIN EVENT " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
				"JOIN EVENT_TYPE " + 
				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " +
				"WHERE REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID= "+empID +
				"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
		while(rs.next()) {		
			vr=new ViewRim(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13));
			vrList.add(vr);
			System.out.println(vr);
		}
		
		conn.close();
		return vrList;
		
	}
	
	//get a specific Reimbursement info
	public ViewRim getRim(long rID) throws SQLException{
		ViewRim vr = null;

		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT REIMBURSEMENT.REIMBURSEMENT_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY,REIMBURSEMENT.REIMBURSEMENT_NOTES FROM REIMBURSEMENT " + 
				"JOIN EMPLOYEE " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
				"JOIN EVENT " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
				"JOIN EVENT_TYPE " + 
				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " +
				"WHERE REIMBURSEMENT.REIMBURSEMENT_ID= "+rID);
		
		while(rs.next()) {		
			vr=new ViewRim(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13));
			System.out.println(vr);
		}
		
		conn.close();
		return vr;
		
	}	
	
	
	
}
