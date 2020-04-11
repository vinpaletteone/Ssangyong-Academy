package admin.dao;
/***
 * @author 송재원
 * 과제 조회 관리 DAO
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admin.dto.AdminMain_TaskSearchDTO;
import admin.dto.ProcTeacherTaskCheckDTO;
import admin.dto.ProcTeacherTaskDTO;
import commonDTO.TeacherDTO;
import main.DBUtil;
import oracle.jdbc.OracleTypes;

public class AdminMain_TaskSearchDAO {

	private Connection conn;
	private Statement stat;
	private ResultSet rs;

	public AdminMain_TaskSearchDAO() {
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<AdminMain_TaskSearchDTO> vwAdmin_scoreList() {

		ArrayList<AdminMain_TaskSearchDTO> list = new ArrayList<AdminMain_TaskSearchDTO>();
		String sql = "select * from vwAdmin_score";

		try {

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AdminMain_TaskSearchDTO dto = new AdminMain_TaskSearchDTO();

				dto.setTeacher_seq(rs.getString("Teacher_seq"));
				dto.setTeacher_name(rs.getString("Teacher_name"));
				dto.setProcess_name(rs.getString("process_name"));
				dto.setSubject_name(rs.getString("subject_name"));
				dto.setStudent_name(rs.getString("Student_name"));
				dto.setTask_contents(rs.getString("Task_contents"));
				dto.setTask_score(rs.getString("Task_score"));

				list.add(dto);

			}

			return list;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<AdminMain_TaskSearchDTO> vwAdmin_scoreList(String name, String process) {
		ArrayList<AdminMain_TaskSearchDTO> list = new ArrayList<AdminMain_TaskSearchDTO>();
		String sql = String.format("select * from vwAdmin_score where teacher_name = '%s'", name);

		try {

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AdminMain_TaskSearchDTO dto = new AdminMain_TaskSearchDTO();

				dto.setTeacher_seq(rs.getString("Teacher_seq"));
				dto.setTeacher_name(rs.getString("Teacher_name"));
				dto.setProcess_name(rs.getString("process_name"));
				dto.setSubject_name(rs.getString("subject_name"));
				dto.setStudent_name(rs.getString("Student_name"));
				dto.setTask_contents(rs.getString("Task_contents"));
				dto.setTask_score(rs.getString("Task_score"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<TeacherDTO> teacherList() {

		ArrayList<TeacherDTO> list = new ArrayList<TeacherDTO>();

		String sql = "SELECT seq, name, ssn, tel FROM tblTeacher";

		try {
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				TeacherDTO dto = new TeacherDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setSsn(rs.getString("ssn"));
				dto.setTel(rs.getString("tel"));

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

	public ArrayList<ProcTeacherTaskDTO> teacherTask(String seq) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.open();

			String sql = "{call procTeacherTask(?, ?)}";
			stat = conn.prepareCall(sql);

			stat.setString(1, seq);
			stat.registerOutParameter(2, OracleTypes.CURSOR);

			stat.executeQuery();

			rs = (ResultSet) stat.getObject(2);

			ArrayList<ProcTeacherTaskDTO> list = new ArrayList<ProcTeacherTaskDTO>();
			while (rs.next()) {
				ProcTeacherTaskDTO proc = new ProcTeacherTaskDTO();
				proc.setProcessName(rs.getString("process_name"));
				proc.setSubjectName(rs.getString("subject_name"));
				proc.setTaskContents(rs.getString("task_contents"));
				proc.setOpenSubjectSeq(rs.getString("opensubject_seq"));

				list.add(proc);
			}

			rs.close();
			stat.close();
			conn.close();

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ProcTeacherTaskCheckDTO> teacherTaskCheck(String seq, String select) {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		try {

			conn = DBUtil.open();

			String sql = "{call procTeacherTaskCheck(?,?,?)}";
			stat = conn.prepareCall(sql);

			stat.setString(1, seq);
			stat.setString(2, select);
			stat.registerOutParameter(3, OracleTypes.CURSOR);

			stat.executeQuery();

			rs = (ResultSet) stat.getObject(3);

			ArrayList<ProcTeacherTaskCheckDTO> list = new ArrayList<ProcTeacherTaskCheckDTO>();
			while (rs.next()) {
				ProcTeacherTaskCheckDTO proc = new ProcTeacherTaskCheckDTO();
				proc.setStudentSeq(rs.getString("student_seq"));
				proc.setStudentName(rs.getString("student_name"));
				proc.setTaskState(rs.getString("state"));

				list.add(proc);
			}

			rs.close();
			stat.close();
			conn.close();

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
