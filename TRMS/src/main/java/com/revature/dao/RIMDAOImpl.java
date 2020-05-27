package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.EventType;
import com.revature.beans.GradeFormat;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.beans.VideoGame;
import com.revature.beans.ViewRim;
import com.revature.util.ConnFactory;

public class RIMDAOImpl {
	
public static ConnFactory banana = ConnFactory.getInstance();
	
	//get specific
	public VideoGame getVGByID(int id) throws SQLException {
		VideoGame vg=null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM VIDEOGAME WHERE VGID= "+id);
		while(rs.next()) {
			vg=new VideoGame(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		return vg;
	}
	
	//insert row
	public void insertVG(VideoGame vg) throws SQLException {
		Connection conn = banana.getConnection();
		String sql ="INSERT INTO VIDEOGAME VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, vg.getVgID());
		ps.setString(2, vg.getVgName());
		ps.setInt(3, vg.getVgMetaScore());
		
		ps.executeUpdate();
	}
	
	//get all Event Type
	public  List<EventType> getET() throws SQLException {
		EventType et = null;
		List<EventType> etList = new ArrayList<EventType>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM EVENT_TYPE");
		while(rs.next()) {
			et=new EventType(rs.getInt(1),rs.getString(2),rs.getInt(3));
			etList.add(et);
		}
		return etList;
	}
	
	//get all Event Type
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
		return gfList;
	}

	public List<ViewRim> getViewAllRim() throws SQLException{
		ViewRim vr = null;
		
//		long eID,empID;
//		String empName="",eType="",eLoc="",eDesc="",eGrade="";
//		Date eDate=null;
		
		List<ViewRim> vrList = new ArrayList<ViewRim>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY FROM REIMBURSEMENT " + 
				"JOIN EMPLOYEE " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
				"JOIN EVENT " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
				"JOIN EVENT_TYPE " + 
				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " + 
				"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
		while(rs.next()) {
			System.out.println(rs.getDate(4));			
			vr=new ViewRim(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
			vrList.add(vr);
			System.out.println(vr);
		}
		
		return vrList;
		
	}
	
	public List<ViewRim> getMyRims(long empID) throws SQLException{
		ViewRim vr = null;
		
//		long eID,empID;
//		String empName="",eType="",eLoc="",eDesc="",eGrade="";
//		Date eDate=null;
		
		List<ViewRim> vrList = new ArrayList<ViewRim>();
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY FROM REIMBURSEMENT " + 
				"JOIN EMPLOYEE " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
				"JOIN EVENT " + 
				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
				"JOIN EVENT_TYPE " + 
				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " +
				"WHERE REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID= "+empID +
				"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
		while(rs.next()) {
			System.out.println(rs.getDate(4));			
			vr=new ViewRim(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
			vrList.add(vr);
			System.out.println(vr);
		}
		
		return vrList;
		
	}
	
	public List<User> getLogInUser() throws SQLException {
		List<User> uList=new ArrayList<User>();
		User user=null;
		Connection conn = banana.getConnection();
		Statement stmt=conn.createStatement();
		String sql = ("SELECT EMPLOYEE.EMPLOYEE_ID,EMPLOYEE.EMPLOYEE_FIRSTNAME,EMPLOYEE.EMPLOYEE_LASTNAME,EMPLOYEE.EMPLOYEE_EMAIL,EMPLOYEE.EMPLOYEE_USERNAME,EMPLOYEE.EMPLOYEE_PASSWORD," + 
				"EMPLOYEE_TITLE.EMPLOYEE_TITLE_NAME,DEPARTMENT.DEPARTMENT_NAME FROM EMPLOYEE " + 
				"JOIN EMPLOYEE_TITLE " + 
				"ON EMPLOYEE.EMPLOYEE_TITLE = EMPLOYEE_TITLE.EMPLOYEE_TITLE_ID " + 
				"JOIN DEPARTMENT " + 
				"ON EMPLOYEE.EMPLOYEE_DEPARTMENT=DEPARTMENT.DEPARTMENT_ID");
		
		System.out.println(sql);
		
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println(rs);
		
		while(rs.next()) {
			
			user=new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			uList.add(user);
		}
		
		System.out.println(user);
		
		return uList;
	}
	
}
