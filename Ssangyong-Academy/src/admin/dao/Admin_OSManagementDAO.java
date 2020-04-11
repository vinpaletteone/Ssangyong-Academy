package admin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admin.dto.Admin_vwOpenProcessSubjectDTO;
import admin.dto.Admin_vwOpenSubjectDTO;
import admin.dto.Admin_vwProcessSubjectDTO;
import main.DBUtil;

/**
 * 
 * @author 유승현
 * Admin_OSManagement DAO
 */
public class Admin_OSManagementDAO {
	private Connection conn;
	private Statement stat;
	
	public Admin_OSManagementDAO() {
		try {
			conn = DBUtil.open();
			stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 개설과정 목록
	 * @return ArrayList<Admin_vwOpenSubjectDTO>
	 */
	public ArrayList<Admin_vwOpenSubjectDTO> openSubjectList() {
		
		try {
			
			ArrayList<Admin_vwOpenSubjectDTO> list = new ArrayList<Admin_vwOpenSubjectDTO>();
			
			String sql = "SELECT openProcess_seq, teacherName, processName, roomName, cntSubject FROM vwOpenSubject ORDER BY 1 ASC";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwOpenSubjectDTO dto = new Admin_vwOpenSubjectDTO();
				
				dto.setTeacherName(rs.getString("teacherName"));
				dto.setOpenProcess_seq(rs.getString("openProcess_seq"));
				dto.setProcessName(rs.getString("processName"));
				dto.setRoomName(rs.getString("roomname"));
				dto.setCntSubject(rs.getString("cntSubject"));
				
				list.add(dto);
				
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 개설된 과정의 과정목록
	 * @param seq 개설과정 기본키
	 * @return ArrayList<Admin_vwOpenProcessSubjectDTO>
	 */
	public ArrayList<Admin_vwOpenProcessSubjectDTO> opSubjectList(String seq) {
		
		try {
			
			ArrayList<Admin_vwOpenProcessSubjectDTO> list = new ArrayList<Admin_vwOpenProcessSubjectDTO>();
			
			String sql = "SELECT opensubject_seq, openProcess_seq, subjectName, period, TO_CHAR(startDate,'yyyy-mm-dd') AS startDate, TO_CHAR(endDate,'yyyy-mm-dd') AS endDate FROM vwOpenProcessSubject WHERE openProcess_seq = " + seq;
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwOpenProcessSubjectDTO dto = new Admin_vwOpenProcessSubjectDTO();
				
				dto.setOpensubject_seq(rs.getString("opensubject_seq"));
				dto.setOpenProcess_seq(rs.getString("openProcess_seq"));
				dto.setSubjectName(rs.getString("subjectName"));
				dto.setPeriod(rs.getString("period"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				
				list.add(dto);
				
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * 
	 * @param seq 개설과정 기본키
	 * @return ArrayList<Admin_vwProcessSubjectDTO>
	 */
	public ArrayList<Admin_vwProcessSubjectDTO> psList(String seq) {
		ArrayList<Admin_vwProcessSubjectDTO> list = new ArrayList<Admin_vwProcessSubjectDTO>();
		
		try {
			
			String sql = "SELECT processSubject_seq, subjectName, openProcess_seq FROM vwProcessSubject WHERE openProcess_seq = " + seq;
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwProcessSubjectDTO dto = new Admin_vwProcessSubjectDTO();
				
				dto.setOpenProcess_seq(rs.getString("openProcess_seq"));
				dto.setProcessSubject_seq(rs.getString("processSubject_seq"));
				dto.setSubjectName(rs.getString("subjectName"));
				
				list.add(dto);
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

	/**
	 * 
	 * @param seq 개설된 과정의 기본키
	 * @param addsel 추가할 과목의 기본키
	 * @return int 실행여부 확인
	 */
	public int addOpenSubject(String seq, String addsel) {
		
		try {
			CallableStatement cstat;
			
			String sql = "{ call procInsertOpenSubject(?,?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, seq);
			cstat.setString(2, addsel);
			
			int result = cstat.executeUpdate(); 
			
			cstat.close();
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	/**
	 * 
	 * @param delsel 삭제할 개설과목의 기본키
	 * @return int 실행여부 확인
	 */
	public int delOpenSubject(String delsel) {
		
		try {
			
			String sql = "DELETE FROM tblOpenSubject WHERE seq = " + delsel;
			
			int result = stat.executeUpdate(sql);
			
			return result; 
			
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
}
