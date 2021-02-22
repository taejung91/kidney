package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Order;



public class MySqlOrderDao implements OrderDao {

	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public Order orderInsert(String id, int pseq, int quantity1, int quantity2, int cseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int MaxOseq = 0;
		Order order = new Order();

		try {
			String sql = "INSERT INTO T_ORDERS(ID, PSEQ, QUANTITY1, QUANTITY2) VALUES(?, ?, ?, ?)";
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, pseq);
			stmt.setInt(3, quantity1);
			stmt.setInt(4, quantity2);

			stmt.executeUpdate();
			stmt.close();

			String sql2 = "SELECT MAX(OSEQ) FROM T_ORDERS";
			stmt = conn.prepareStatement(sql2);
			rs = stmt.executeQuery();
			if (rs.next()) {
				MaxOseq = rs.getInt(1);
			}
			rs.close();
			stmt.close();

			String sql3 = "INSERT INTO T_ORDER_DETAIL(OSEQ, PSEQ, QUANTITY1, QUANTITY2) VALUES(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql3);
			stmt.setInt(1, MaxOseq);
			stmt.setInt(2, pseq);
			stmt.setInt(3, quantity1);
			stmt.setInt(4, quantity2);
			stmt.executeUpdate();
			stmt.close();

			String sql4 = "UPDATE T_CART SET RESULT=2 WHERE CSEQ=?"; // cart_view 안보이기.
			stmt = conn.prepareStatement(sql4);
			stmt.setInt(1, cseq);
			stmt.executeUpdate();
       		stmt.close();
			
			String sql5 = "SELECT * FROM T_ORDER_VIEW WHERE OSEQ=?";
			stmt = conn.prepareStatement(sql5);
			stmt.setInt(1, MaxOseq);
			rs = stmt.executeQuery();
			if (rs.next()) {
				
				order.setOdseq(rs.getInt("odseq"));
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return order;
	
	}

	public ArrayList<Integer> selectOseqOrderIng(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "SELECT OSEQ FROM T_ORDER_VIEW WHERE ID=? AND RESULT='1' ORDER BY OSEQ DESC"; // order by로
																											// 내림차순 기준으로
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				oseqList.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return oseqList;
	}

	public ArrayList<Order> orderListById(String id, String result, int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM T_ORDER_VIEW WHERE ID=? AND RESULT LIKE '%" + result + "%' ORDER BY OSEQ DESC LIMIT ?, ?"; // order by로
																											// 내림차순 기준으로
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt);
			
		//	stmt.setInt(2, oseq);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOdseq(rs.getInt("odseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("id"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setPseq(rs.getInt("pseq"));
				order.setQuantity1(rs.getInt("quantity1"));
				order.setQuantity2(rs.getInt("quantity2"));
				order.setCname(rs.getString("cname"));
				order.setBirth(rs.getString("birth"));
				order.setEmail(rs.getString("email"));
				order.setTel(rs.getString("tel"));
				order.setPname(rs.getString("pname"));
				order.setS_schedule(rs.getString("s_schedule"));
				order.setE_schedule(rs.getString("e_schedule"));
				order.setPrice1(rs.getInt("price1"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
				order.setKind(rs.getString("kind"));
				
				orderList.add(order);
				
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		return orderList;

	}
	
	public Order list(int odseq)throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_ORDER_VIEW WHERE odseq=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, odseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Order order = new Order();
				order.setOdseq(rs.getInt("odseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("id"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setPseq(rs.getInt("pseq"));
				order.setQuantity1(rs.getInt("quantity1"));
				order.setQuantity2(rs.getInt("quantity2"));
				order.setCname(rs.getString("cname"));
				order.setBirth(rs.getString("birth"));
				order.setEmail(rs.getString("email"));
				order.setTel(rs.getString("tel"));
				order.setPname(rs.getString("pname"));
				order.setS_schedule(rs.getString("s_schedule"));
				order.setE_schedule(rs.getString("e_schedule"));
				order.setPrice1(rs.getInt("price1"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
				order.setKind(rs.getString("kind"));
				
				
				return order;
				
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
	
	public Order orderDetail(int oseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_ORDER_VIEW WHERE oseq=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, oseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Order order = new Order();
				order.setOdseq(rs.getInt("odseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("id"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setPseq(rs.getInt("pseq"));
				order.setQuantity1(rs.getInt("quantity1"));
				order.setQuantity2(rs.getInt("quantity2"));
				order.setCname(rs.getString("cname"));
				order.setBirth(rs.getString("birth"));
				order.setEmail(rs.getString("email"));
				order.setTel(rs.getString("tel"));
				order.setPname(rs.getString("pname"));
				order.setS_schedule(rs.getString("s_schedule"));
				order.setE_schedule(rs.getString("e_schedule"));
				order.setPrice1(rs.getInt("price1"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
				order.setKind(rs.getString("kind"));
				

				return order;

			} else {
				throw new Exception();
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (rs != null) {
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
	
public void orderDelete(int oseq)throws Exception{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM T_ORDERS WHERE OSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, oseq);
			stmt.executeUpdate();
			stmt.close();
/*
			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_ORDERS SET OSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();
			stmt.close();
	*/		
			String sql4 = "DELETE FROM T_ORDER_DETAIL WHERE OSEQ=?";
			stmt = conn.prepareStatement(sql4);
			stmt.setInt(1, oseq);
			stmt.executeUpdate();
		
/*
			String sql5 = "set @count=0";
			stmt = conn.prepareStatement(sql5);
			stmt.executeUpdate();
			stmt.close();

			String sql6 = "update T_ORDER_DETAIL SET ODSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql6);
			stmt.executeUpdate();
*/
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

//주문 총 페이징
		public int getAllCount(String id) throws Exception {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			int count = 0;
			String sql = "select count(*) as count from T_ORDER_VIEW WHERE ID=? AND RESULT=?";
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
