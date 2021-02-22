package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Cart;

public class MySqlCartDao implements CartDao {
	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public void cartInsert(String id, int pseq, int quantity1, int quantity2) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_CART(id, pseq, quantity1, quantity2) values(?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, pseq);
			stmt.setInt(3, quantity1);
			stmt.setInt(4, quantity2);
			
			stmt.executeUpdate();
			stmt.close();
			
			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();
			

		} catch (SQLException e) {
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

	public ArrayList<Cart> cartList(String id, int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM T_CART_VIEW WHERE ID=? ORDER BY CSEQ DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCseq(rs.getInt("cseq")).setId(rs.getString("id")).setPseq(rs.getInt("pseq"))
						.setCname(rs.getString("cname")).setPname(rs.getString("pname"))
						.setQuantity1(rs.getInt("quantity1")).setQuantity2(rs.getInt("quantity2")).setS_schedule(rs.getString("s_schedule"))
						.setPrice1(rs.getInt("price1")).setPrice2(rs.getInt("price2")).setKind(rs.getString("kind"));
				
				cartList.add(cart);

			}

		} catch (SQLException e) {
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
		return cartList;
	}
	
	public int select(String id, int pseq)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cseq = 0;
		String sql = "SELECT MAX(CSEQ) FROM T_CART";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
		//	stmt.setString(1, id);
		//	stmt.setInt(2, pseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return cseq = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cseq;
	
	}
	
	public Cart cartList(int cseq)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_CART_VIEW WHERE cseq=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Cart cart = new Cart();
				return cart.setCseq(rs.getInt("cseq")).setId(rs.getString("id")).setPseq(rs.getInt("pseq"))
						.setCname(rs.getString("cname")).setPname(rs.getString("pname"))
						.setQuantity1(rs.getInt("quantity1")).setQuantity2(rs.getInt("quantity2")).setS_schedule(rs.getString("s_schedule"))
						.setPrice1(rs.getInt("price1")).setPrice2(rs.getInt("price2")).setKind(rs.getString("kind"));
			}else {
				throw new Exception();
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

	
	public void delete(int cseq)throws Exception{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM T_CART WHERE CSEQ=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cseq);
			stmt.executeUpdate();
		stmt.close();
			
			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();


		} catch (SQLException e) {
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
	
	//장바구니 총 페이징
		public int getAllCount(String id) throws Exception {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			int count = 0;
			String sql = "select count(*) as count from T_CART WHERE ID=? AND RESULT=?";
			try {
				conn = ds.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setInt(2, 1);
				
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
