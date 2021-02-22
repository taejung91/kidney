package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Qna;
import webapp.DBAction;

public class MySqlQnaDao implements QnaDao {

	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Qna> qnaList(String id, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Qna> qnaList = new ArrayList<Qna>();
		int page2 = (page - 1) * cnt;
		
		String sql = "SELECT * FROM T_QNA WHERE ID=? ORDER BY QSEQ DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				qna.setId(rs.getString("id"));
				qna.setRep(rs.getString("rep"));
				qna.setIndate(rs.getTimestamp("indate"));

				qnaList.add(qna);
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
				e.printStackTrace();
			}
		}

		return qnaList;
	}

	public void qnaInsert(Qna qna) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_QNA(ID, SUBJECT, CONTENT) VALUES(?, ?, ?)";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qna.getId());
			stmt.setString(2, qna.getSubject());
			stmt.setString(3, qna.getContent());
			stmt.executeUpdate();
			stmt.close();
			
			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_QNA SET QSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Qna qnaDetail(int qseq) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Qna qna = null;
		String sql = "SELECT * FROM T_QNA WHERE QSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, qseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				qna = new Qna();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				qna.setId(rs.getString("id"));
				qna.setRep(rs.getString("rep"));
				qna.setIndate(rs.getTimestamp("indate"));

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
				e.printStackTrace();
			}
		}
		return qna;
	}

	public void qnaDelete(int qseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM T_QNA WHERE QSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, qseq);
			stmt.executeUpdate();
			stmt.close();
			
			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_QNA SET QSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	//QNA 총 페이징
	public int getAllCount() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from T_QNA";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
