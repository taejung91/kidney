package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Information;
import dto2.Product;
import webapp.DBAction;

public class MySqlProductDao implements ProductDao {

	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Product> list(int kind, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM T_PRODUCT WHERE KIND=? ORDER BY PSEQ DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, kind);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setKind(rs.getString("kind"))
						.setPrice1(rs.getInt("price1")).setImage(rs.getString("image")).setContent(rs.getString("content"));

				productList.add(product);

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
		return productList;
	}
	
	public Product detail(int pseq)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		String sql = "SELECT * FROM t_product WHERE PSEQ=?";

		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pseq);
		//	stmt.setInt(2, kind);
			rs = stmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setKind(rs.getString("kind"))
				.setPrice1(rs.getInt("price1")).setPrice2(rs.getInt("price2")).setQuantity(rs.getInt("quantity"))
				.setSchedule(rs.getString("schedule")).setS_schedule(rs.getString("s_schedule")).setE_schedule(rs.getString("e_schedule"))
				.setRoute(rs.getString("route")).setContent(rs.getString("content")).setImage(rs.getString("image")).setUseyn(rs.getString("useyn"))
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
		return product;
		
	}
	
	public void updateQuantity(int pseq, int quantity)throws Exception{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE T_PRODUCT SET QUANTITY=? WHERE PSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quantity);
			stmt.setInt(2, pseq);
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
	//상품 총 페이징
	public int getAllCount(int kind) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from T_PRODUCT WHERE kind=?";
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

}
