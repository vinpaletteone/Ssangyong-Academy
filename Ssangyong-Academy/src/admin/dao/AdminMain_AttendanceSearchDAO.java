package admin.dao;
/***
 * @author 송재원
 * 학생 근태 조회 DAO
 */
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import admin.dto.AdminMain_AttendanceSearchDTO;
import main.DBUtil;

public class AdminMain_AttendanceSearchDAO {

	private Connection conn;
	private Statement stat;
	private ResultSet rs;
	private Scanner scan;
	private PreparedStatement pstat;
	

	public AdminMain_AttendanceSearchDAO() {
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<AdminMain_AttendanceSearchDTO> VwAttendancrSearchList() {

		ArrayList<AdminMain_AttendanceSearchDTO> list = new ArrayList<AdminMain_AttendanceSearchDTO>();

		String sql = "select * from vwAdmin_StudentAttendance ORDER BY Att_arrivetime ASC";
		try {

			// 학생 번호, 학생 이름, 입.퇴실 시간, 근태상태
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AdminMain_AttendanceSearchDTO dto = new AdminMain_AttendanceSearchDTO();

				dto.setSt_seq(rs.getString("St_seq"));
				dto.setSt_name(rs.getString("St_name"));
				dto.setAtt_arrivetime(rs.getString("Att_arrivetime"));
				dto.setAtt_leavetime(rs.getString("Att_leavetime"));
				dto.setAtt_state(rs.getString("Att_state"));

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public ArrayList<AdminMain_AttendanceSearchDTO> SearchStudentAtt(String name) {

		ArrayList<AdminMain_AttendanceSearchDTO> list = new ArrayList<AdminMain_AttendanceSearchDTO>();
		String sql = String.format("select*from vwAdmin_StudentAttendance where st_name = '%s'", name);

		try {

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AdminMain_AttendanceSearchDTO dto = new AdminMain_AttendanceSearchDTO();

				dto.setSt_seq(rs.getString("St_seq"));
				dto.setSt_name(rs.getString("St_name"));
				dto.setAtt_arrivetime(rs.getString("Att_arrivetime"));
				dto.setAtt_leavetime(rs.getString("Att_leavetime"));
				dto.setAtt_state(rs.getString("Att_state"));

				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
