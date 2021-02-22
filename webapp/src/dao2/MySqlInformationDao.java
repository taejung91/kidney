package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Hospital;
import dto2.Information;
import webapp.DBAction;

public class MySqlInformationDao implements InformationDao {
	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Information> list(int kind, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Information> infoList = new ArrayList<Information>();
		int page2 = (page - 1) * cnt;
	//	int page = 0;
	//	int page = (pageNum - 1) * cnt;
		
		String sql = "SELECT * FROM INFORMATION WHERE KIND=? ORDER BY ISEQ DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, kind);
			stmt.setInt(2, page2);
     		stmt.setInt(3, cnt);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Information info = new Information();

				info.setIseq(rs.getInt("iseq"));
				info.setTitle(rs.getString("title"));
				info.setContent(rs.getString("content"));
				info.setKind(rs.getString("kind"));
				info.setImage(rs.getString("image"));
				info.setIndate(rs.getDate("indate"));

				infoList.add(info);

			}

		} catch (Exception e) {

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
		return infoList;
	}

	public Information detail(int iseq, int kind) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Information information = null;
		String sql = "SELECT * FROM INFORMATION WHERE ISEQ=? AND KIND=? ";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, iseq);
			stmt.setInt(2, kind);
			rs = stmt.executeQuery();
			if (rs.next()) {
				information = new Information();
				information.setIseq(rs.getInt("iseq")).setKind(rs.getString("kind")).setTitle(rs.getString("title"))
						.setContent(rs.getString("content")).setImage(rs.getString("image"))
						.setIndate(rs.getDate("indate"));
			}

		} catch (SQLException e) {
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
		return information;

	}

	public ArrayList<Hospital> listHospital(String search, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM HOSPITAL WHERE NAME LIKE '%" + search + "%' OR ADDRESS LIKE '%" + search + "%' LIMIT ?, ?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Hospital hospital = new Hospital();

				hospital.setNo(rs.getInt("No"));
				hospital.setName(rs.getString("name"));
				hospital.setAddress(rs.getString("address"));
				hospital.setTel(rs.getString("tel"));
				hospital.setConfirm(rs.getString("confirm"));
				hospital.setDoctor(rs.getString("doctor"));
				hospital.setDoctor_yn(rs.getString("doctor_yn"));

				hospitalList.add(hospital);

			}

		} catch (Exception e) {

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
		return hospitalList;
	}
	
	public Hospital detailHospital(String no)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM HOSPITAL WHERE No=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Hospital hospital = new Hospital();
				
				return hospital.setNo(rs.getInt("No")).setName(rs.getString("name")).setAddress(rs.getString("address"))
				.setTel(rs.getString("tel")).setConfirm(rs.getString("confirm")).setDoctor(rs.getString("doctor"))
				.setDoctor_yn(rs.getString("doctor_yn"));
			}else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw e;

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
		
	}
	//정보 총 페이징
	public int getAllCount(int kind) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from INFORMATION WHERE kind=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, kind);
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
	//병원 총 페이징
	public int getAllCount(String search) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from HOSPITAL WHERE NAME LIKE '%" + search + "%' OR ADDRESS LIKE '%" + search + "%'";
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
