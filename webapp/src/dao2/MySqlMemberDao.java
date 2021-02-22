package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import dto2.MemberVO;

public class MySqlMemberDao implements MemberDao{


	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	public int insertMember(MemberVO memberVO) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			String sql = "insert into users(user_id, user_pw) values(?, ?)";
			stmt = conn.prepareStatement(sql);
		
			stmt.setString(1, memberVO.getId());
			stmt.setString(2, memberVO.getPw());
			
			return stmt.executeUpdate();
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			try {
				if(stmt!= null) {stmt.close();}
				if(conn!=null) {conn.close();}
				
			}catch(Exception e) {}
			
		}
	}
	
	public MemberVO checkId(String id) throws Exception{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USERS WHERE USER_ID=?";
		MemberVO memberVO = new MemberVO();
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				
				memberVO.setId(rs.getString("user_id"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return memberVO;
	}
}
