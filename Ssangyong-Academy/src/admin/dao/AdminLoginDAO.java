package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.DBUtil;
/**
 * 
 * @author 유승현
 * 관리자 로그인시 계정을 확인할 DAO
 */
public class AdminLoginDAO {
	private Connection conn;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public AdminLoginDAO() {
		conn = DBUtil.open();
		pstat = null;
		rs = null;
	}

	/**
	 * 
	 * @param ID 관리자 ID 입력값
	 * @param PW 관리자 PW 입력값
	 * @return boolean 로그인 성공 여부 반환
	 */
	public boolean loginCheck(String ID, String PW) {
		try {
			String sql = "select * from tbladmin where id = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, ID);
			pstat.setString(2, PW);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				rs.close();
				pstat.close();
				conn.close();
				return true;
			}else {
				rs.close();
				pstat.close();
				conn.close();
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
}
