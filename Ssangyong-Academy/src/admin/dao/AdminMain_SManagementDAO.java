package admin.dao;
/***
 * @author 송재원
 * 학생관리 DAO
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import admin.dto.AdminMain_SManagementDTO;
import admin.dto.Admin_VwSelStudentDTO;
import main.DBUtil;

public class AdminMain_SManagementDAO {
	private Connection conn;
	private Statement stat;
	private ResultSet rs;

	public AdminMain_SManagementDAO() {

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<AdminMain_SManagementDTO> VwMain_studentinfo() {

		ArrayList<AdminMain_SManagementDTO> list = new ArrayList<AdminMain_SManagementDTO>();

		String sql = "select*from tblstudent";

		try {

			// 교육생 정보 : 교육생 이름, 주민번호 뒷자리, 전화번호, 등록일, 수강중인 과정
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AdminMain_SManagementDTO dto = new AdminMain_SManagementDTO();

				dto.setSeq(rs.getString("Seq"));
				dto.setName(rs.getString("Name"));
				dto.setSsn(rs.getString("Ssn"));
				dto.setTel(rs.getString("Tel"));
				dto.setRgstrdate(rs.getString("Rgstrdate"));

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public int AddStudent(String name, String ssn, String tel) {
		try {

			String sql = String.format(
					"insert into tblstudent (seq, name, ssn, tel, rgstrdate) values (seqstudent.nextVal,'%s','%s','%s', '2019-01-01')",
					name, ssn, tel);

			int result = stat.executeUpdate(sql);
			return result;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return 0;
	}

	// 학생 수정
	public int UpdateStudent(String name, String ssn, String tel, String updateSeq) {
		try {
			String sql = String.format(
					"update tblstudent set name = '%s', ssn = '%s' ,tel = '%s' , rgstrdate = TO_DATE('2019-11-01','yyyy-mm-dd')  where seq = %s",
					name, ssn, tel, updateSeq);
			int result = stat.executeUpdate(sql);
			return result;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		}
	}

	public int DeleteStudent(String DeleteSeq) {
		try {

			String sql = String.format("delete from tblstudent where seq = %s", DeleteSeq);

			int result = stat.executeUpdate(sql);

			return result;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return 0;
	}

	public Admin_VwSelStudentDTO SearchStudent(String studentNum) {
		
		Admin_VwSelStudentDTO dto = new Admin_VwSelStudentDTO();
		
		try {
					 
			String sql = ("select*from vwselstudent where Studentnum = "+ studentNum);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			//특정 교육생 선택시 출력할 내용 : 과정명, 과정기간, 강의실, 수료여부, 날짜
			if (rs.next()) {
				dto.setStudentName(rs.getString("StudentName"));
				dto.setProcessName(rs.getString("ProcessName"));
				dto.setPeriod(rs.getString("Period"));
				dto.setClassName(rs.getString("ClassName"));
				dto.setState(rs.getString("State"));
				dto.setFinaldate(rs.getString("Finaldate"));		
				
			}
			
			rs.close();
			return dto;		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}