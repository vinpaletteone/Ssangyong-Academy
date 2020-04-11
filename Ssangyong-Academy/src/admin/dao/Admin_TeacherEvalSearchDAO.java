package admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admin.dto.Admin_vwEndOpenProcessDTO;
import admin.dto.Admin_vwTeacherEvalDTO;
import main.DBUtil;

/**
 * 
 * @author 유승현
 * 관리자 - 교사평가조회 DAO
 */
public class Admin_TeacherEvalSearchDAO {
	private	Connection conn;
	private Statement stat;
	
	public Admin_TeacherEvalSearchDAO(){
		try {
			this.conn = DBUtil.open();
			this.stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 교사평가 목록
	 * @return ArrayList<Admin_vwEndOpenProcessDTO>
	 */
	public ArrayList<Admin_vwEndOpenProcessDTO> openProcessList() {
		
		ArrayList<Admin_vwEndOpenProcessDTO> list = new ArrayList<Admin_vwEndOpenProcessDTO>();
		
		String sql = "SELECT seq, processName, teacherName FROM vwEndOpenProcess ORDER BY seq ASC";
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Admin_vwEndOpenProcessDTO dto = new Admin_vwEndOpenProcessDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setProcessName(rs.getString("processName"));
				dto.setTeacherName(rs.getString("teacherName"));

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
	 * 교사평가의 내용을 리스트로 반환
	 * @param selOpenProcess 검색하기 위한 개설과정의 기본키
	 * @return ArrayList<Admin_vwTeacherEvalDTO>
	 */
	
	public ArrayList<Admin_vwTeacherEvalDTO> teacherEvalList(String selOpenProcess) {

		try{

			ArrayList<Admin_vwTeacherEvalDTO> list = new ArrayList<Admin_vwTeacherEvalDTO>();
			
			String sql = "SELECT teacherName, processName, studentName, contents, score FROM vwTeacherEval WHERE openProcess_seq = " + selOpenProcess;

			ResultSet rs = stat.executeQuery(sql);

			while(rs.next()){
				Admin_vwTeacherEvalDTO dto = new Admin_vwTeacherEvalDTO();

				dto.setTeacherName(rs.getString("teacherName"));
				dto.setProcessName(rs.getString("processName"));
				dto.setStudentName(rs.getString("studentName"));
				dto.setContents(rs.getString("contents"));
				dto.setScore(rs.getString("score"));

				list.add(dto);
			}

			rs.close();
			return  list;

		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}

		return null;
	}
}
