package admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admin.dto.Admin_vwAdminStudentScoreDTO;
import commonDTO.StudentDTO;
import main.DBUtil;

/**
 * 
 * @author 유승현
 * Admin_ScoreSearch DAO
 */
public class Admin_ScoreSearchDAO {
	private Connection conn;
	private Statement stat;
	
	public Admin_ScoreSearchDAO() {
		try {
			this.conn = DBUtil.open();
			this.stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 학생 목록 
	 * @return ArrayList<StudentDTO>
	 */
	public ArrayList<StudentDTO> studentList() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		String sql = "SELECT seq, name, ssn, tel, TO_CHAR(rgstrDate,'yyyy-mm-dd') AS rgstrDate FROM tblStudent";
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setSsn(rs.getString("ssn"));
				dto.setTel(rs.getString("tel"));
				dto.setRgstrDate(rs.getString("rgstrDate"));
				
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
	 * 학생의 과목 모든 성적
	 * @param studentSel 선택한 학생 기본키
	 * @return ArrayList<Admin_vwAdminStudentScoreDTO>
	 */
	public ArrayList<Admin_vwAdminStudentScoreDTO> selectStudentScore(String studentSel) {
		ArrayList<Admin_vwAdminStudentScoreDTO> list = new ArrayList<Admin_vwAdminStudentScoreDTO>();
		
		String sql = "SELECT subjectName, attendanceScore, practicalScore, taskScore, writeScore FROM vwAdminStudentScore WHERE seq = " + studentSel;
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwAdminStudentScoreDTO dto = new Admin_vwAdminStudentScoreDTO();
				
				dto.setSubjectName(rs.getString("subjectName"));
				dto.setAttendanceScore(rs.getString("attendanceScore"));
				dto.setPracticalScore(rs.getString("practicalScore"));
				dto.setTaskScore(rs.getString("taskScore"));
				dto.setWriteScore(rs.getString("writeScore"));
				
				list.add(dto);
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Admin_vwAdminStudentScoreDTO> selectSubjectScoreList(String ossel) {
		
		ArrayList<Admin_vwAdminStudentScoreDTO> list = new ArrayList<Admin_vwAdminStudentScoreDTO>();
		
		String sql = "SELECT seq, studentName, subjectName, attendanceScore, practicalScore, taskScore, writeScore FROM vwAdminStudentScore WHERE openSubject_seq = " + ossel;
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwAdminStudentScoreDTO dto = new Admin_vwAdminStudentScoreDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setSubjectName(rs.getString("subjectName"));
				dto.setAttendanceScore(rs.getString("attendanceScore"));
				dto.setPracticalScore(rs.getString("practicalScore"));
				dto.setTaskScore(rs.getString("taskScore"));
				dto.setWriteScore(rs.getString("writeScore"));
				
				list.add(dto);
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
