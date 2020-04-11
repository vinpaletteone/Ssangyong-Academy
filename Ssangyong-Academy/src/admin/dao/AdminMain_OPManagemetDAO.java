package admin.dao;
/**
 * @author 송재원
 * 개설 과정 관리 DAO
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import admin.dto.Admin_VwOpenProcessDTO;
import admin.dto.Admin_procOpenSubjectDTO;
import admin.dto.Admin_procStudentInfoDTO;
import main.DBUtil;
import oracle.jdbc.OracleTypes;

public class AdminMain_OPManagemetDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private Scanner scan;

	public AdminMain_OPManagemetDAO() {

		try {
			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Admin_VwOpenProcessDTO> VwopenprocessList() {

		ArrayList<Admin_VwOpenProcessDTO> list = new ArrayList<Admin_VwOpenProcessDTO>();

		String sql = "select seq, processName, startDate, endDate, className from vwopenprocess ORDER BY seq ASC";

		try {

			
			// : 개설과정명, 개설과정기간(시작 년월일 ~ 종료 년월일), 강의실 정보
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				Admin_VwOpenProcessDTO dto = new Admin_VwOpenProcessDTO();

				dto.setSeq(rs.getString("Seq"));
				dto.setProcessName(rs.getString("ProcessName"));
				dto.setStartDate(rs.getString("StartDate"));
				dto.setEndDate(rs.getString("EndDate"));
				dto.setClassName(rs.getString("ClassName"));

				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;

	}
	// 특정 개설 과정 선택 후 > 개설 과목 정보 + 교육생 정보 확인 가능

	public ArrayList<Admin_procStudentInfoDTO> procStudentInfo(String seq) {

		CallableStatement cstat = null;

		String sql = "{ call procAdminStudentInfo( ?, ?) }";

		try {

			cstat = conn.prepareCall(sql);
			scan = new Scanner(System.in);

			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);

			cstat.executeQuery();

			rs = (ResultSet) cstat.getObject(2);

			ArrayList<Admin_procStudentInfoDTO> list2 = new ArrayList<Admin_procStudentInfoDTO>();

			while (rs.next()) {
				Admin_procStudentInfoDTO dto = new Admin_procStudentInfoDTO();

				dto.setSeq(rs.getString("Seq"));
				dto.setStudentName(rs.getString("StudentName"));
				dto.setSsn(rs.getString("Ssn"));
				dto.setTel(rs.getString("Tel"));
				dto.setRgstrdate(rs.getString("Rgstrdate"));
				dto.setState(rs.getString("State"));

				list2.add(dto);

			}

			return list2;

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Admin_procOpenSubjectDTO> procOpenSubject(String seq) {

		CallableStatement cstat = null;

		String sql = "{ call procOpenSubject( ?,? ) }";

		try {

			cstat = conn.prepareCall(sql);
			scan = new Scanner(System.in);

			cstat.setString(1, seq);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);

			cstat.executeQuery();

			rs = (ResultSet) cstat.getObject(2);

			ArrayList<Admin_procOpenSubjectDTO> list3 = new ArrayList<Admin_procOpenSubjectDTO>();

			while (rs.next()) {
				Admin_procOpenSubjectDTO dto = new Admin_procOpenSubjectDTO();

				dto.setName(rs.getString("Name"));
				dto.setPeriod(rs.getString("Period"));
				dto.setSeq(rs.getString("Seq"));

				list3.add(dto);

			}

			return list3;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// - 개설 과정 정보에 대한 등록 및 관리(입력, 수정, 삭제) 기능 사용 가능
	// 과정 수정
	public int updateOpenProcess(String updatename, String updateperiod, String sel3) {
		try {

			conn.setAutoCommit(false);

			String sql = String.format("update tblprocess SET name = '%s',  period = '%s' where seq = '%s'", updatename,
					updateperiod, sel3);

			stat = conn.createStatement();

			int result = stat.executeUpdate(sql);

			conn.commit();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	// 과목 추가
	public int AddProcess(String name, String period) {
		try {


			// 과목 추가
			String sql = String.format(
					"insert into tblprocess (seq, name, period) VALUES (SEQPROCESS.nextval,'%s','%s')", name, period);


			int result = stat.executeUpdate(sql);
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}
	
	//과목 삭제
	
	public int DeleteProcess(String seqDelete) {
		try {
			
			String sql = String.format("delete from tblprocess where seq = %s", seqDelete);
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
