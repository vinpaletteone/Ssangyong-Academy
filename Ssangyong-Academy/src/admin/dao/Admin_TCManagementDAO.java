package admin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.dto.Admin_procTeacherInfoDTO;
import admin.dto.Admin_procTeacherPosSubjectDTO;
import commonDTO.SubjectDTO;
import commonDTO.TeacherDTO;
import main.DBUtil;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author 유승현
 * 관리자 - 교사계정 관리 DAO -
 */
public class Admin_TCManagementDAO {
    private Connection conn;
    private Statement stat;

    public Admin_TCManagementDAO(){
        try {
            this.conn = DBUtil.open();
            this.stat = conn.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    /**
     * 교사목록 리스트 반환
     * @return ArrayList<TeacherDTO>
     */
    public ArrayList<TeacherDTO> teacherList() {

        ArrayList<TeacherDTO> list = new ArrayList<TeacherDTO>();

        String sql = "SELECT seq, name, ssn, tel FROM tblTeacher";

        try {
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()){
                TeacherDTO dto = new TeacherDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setSsn(rs.getString("ssn"));
                dto.setTel(rs.getString("tel"));

                list.add(dto);

            }
            
            rs.close();
            return list;

        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 교사의 세부정보 리스트 반환
     * @param String seq - 검색을 위한 교사의 기본키 
     * @return ArrayList<Admin_procTeacherInfoDTO> 
     */
    public ArrayList<Admin_procTeacherInfoDTO> teacherInfo(String seq) {

        String sql = "{ call procTeacherInfo(?,?)}";

        try {
            CallableStatement cstat = conn.prepareCall(sql);

            cstat.setString(1,seq);
            cstat.registerOutParameter(2, OracleTypes.CURSOR);

            cstat.executeQuery();
            ResultSet rs = (ResultSet)cstat.getObject(2);

            ArrayList<Admin_procTeacherInfoDTO> list = new ArrayList<Admin_procTeacherInfoDTO>();
            
            while(rs.next()){
                Admin_procTeacherInfoDTO dto = new Admin_procTeacherInfoDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setName(rs.getString("name"));
                dto.setProcessName(rs.getString("processName"));
                dto.setRoomName(rs.getString("roomName"));
                dto.setPeriod(rs.getString("period"));
                dto.setStartDate(rs.getString("startDate"));
                dto.setEndDate(rs.getString("endDate"));
                dto.setProcessState(rs.getString("processState"));

                list.add(dto);
            }
            
            cstat.close();
            return list;

        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * 교사의 가능과목 리스트 반환
     * @param sel - 검색을 위한 교사의 기본키 
     * @return ArrayList<Admin_procTeacherPosSubjectDTO> 
     */
    public ArrayList<Admin_procTeacherPosSubjectDTO> teacherSubject(String sel) {
    	
    	String sql = "{ call procTeacherPosSubject(?,?)}";
    	
    	try {
    		
    		CallableStatement cstat = conn.prepareCall(sql);
    		
    		cstat.setString(1, sel);
    		cstat.registerOutParameter(2, OracleTypes.CURSOR);
    		
    		cstat.executeQuery();
    		ResultSet rs = (ResultSet)cstat.getObject(2);
    		
    		ArrayList<Admin_procTeacherPosSubjectDTO> list = new ArrayList<Admin_procTeacherPosSubjectDTO>();
    		
    		while(rs.next()) {
    			Admin_procTeacherPosSubjectDTO dto = new Admin_procTeacherPosSubjectDTO();
    			
    			dto.setSeq(rs.getString("seq"));
    			dto.setName(rs.getString("name"));
    			
    			list.add(dto);
    			
    		}
    		
    		cstat.close();
    		return list;
			
		} catch (Exception e) {
            System.out.println(e);
            return null;

		}
    }

    /**
     * 교사 계정 추가 
     * @param ID 
     * @param PW
     * @param tel
     * @return int
     */
	public int addTeacher(String ID, String PW, String tel) {
		
		try {
			
			conn.setAutoCommit(false);
			
			//계정 추가
			String sql = String.format("INSERT INTO tblTeacher(seq, name, ssn, tel) VALUES(seqTeacher.nextVal, '%s', '%s', '%s')"
					, ID, PW, tel);
			
			stat = conn.createStatement();
			
			int result = stat.executeUpdate(sql);
			
			return result;
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 과목 목록 리스트 반환
	 * @return ArrayList<SubjectDTO>
	 */
    public ArrayList<SubjectDTO> subjectList() {
    	
		String sql = "SELECT * FROM tblSubject";
		
		try {
			
			ResultSet rs = stat.executeQuery(sql);
			
			ArrayList<SubjectDTO> list = new ArrayList<SubjectDTO>();
			
			while(rs.next()) {
				SubjectDTO dto = new SubjectDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setPeriod(rs.getString("period"));
				
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
     * 가능과목 추가 
     * @param sel 추가하고자 하는 교사기본키
     * @param subjectSelect 과목들의 번호
     * @return int
     */
	public int addSubject(String sel, String subjectSelect) {
		
		try {
			
			String[] stringArray = subjectSelect.split(",");
			int result = 0;
			
			for(String index : stringArray) {
				
				String sql = String.format("INSERT INTO tblPosSubject(seq, teacher_seq, subject_seq) VALUES(seqPosSubject.nextVal, seqTeacher.currVal, %s)"
						, index);
				
				stat = conn.createStatement();
				
				result = stat.executeUpdate(sql);
			}
			
			conn.commit();
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}


	/**
	 * 교사 한명 정보 가져오기
	 * @param teacherSelect 선택하고자 하는 교사 기본키
	 * @return dto
	 */
	public TeacherDTO getTeacher(String teacherSelect) {
		
		TeacherDTO dto = new TeacherDTO();
		
		try {
			
			String sql = "SELECT seq, name, ssn, tel FROM tblTeacher WHERE seq = " + teacherSelect;
			
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setSsn(rs.getString("ssn"));
				dto.setTel(rs.getString("tel"));
			}
			
			rs.close();
			return dto;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * 교사 수정
	 * @param teacherSelect 교사 기본키
	 * @param updateID 수정할 ID
	 * @param updatePW 수정할 PW
	 * @param updateTel 수정할 Tel
	 * @return int
	 */
	public int updateTeacher(String teacherSelect, String updateID, String updatePW, String updateTel) {
		
		try {
			
			conn.setAutoCommit(false);
			
			String sql = String.format("UPDATE tblTeacher SET name = '%s', ssn = '%s', tel = '%s' WHERE seq = %s"
							, updateID, updatePW, updateTel, teacherSelect);
			
			stat = conn.createStatement();
			
			int result = stat.executeUpdate(sql);
			
			conn.commit();
			
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		}
		
	}
}
