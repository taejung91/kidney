package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Calculator;
import dto2.CalculatorCart;
import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;

public class MySqlCalculatorDao implements CalculatorDao {

	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Food> list(String search, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Food> foodList = new ArrayList<Food>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM FOOD WHERE FNAME LIKE '%" + search + "%' ORDER BY FNAME LIMIT ?, ?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Food food = new Food();

				food.setFseq(rs.getInt("fseq")).setFname(rs.getString("fname")).setKind(rs.getString("kind"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"))
						.setCapacity(rs.getInt("capacity")).setImage(rs.getString("image"))
						.setIndate(rs.getDate("indate"));

				foodList.add(food);

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
		return foodList;
	}

	public ArrayList<Food> list(int kind, int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Food> foodList = new ArrayList<Food>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM FOOD WHERE KIND=? ORDER BY FNAME LIMIT ?, ?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, kind);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Food food = new Food();

				food.setFseq(rs.getInt("fseq")).setFname(rs.getString("fname")).setKind(rs.getString("kind"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"))
						.setCapacity(rs.getInt("capacity")).setImage(rs.getString("image"))
						.setIndate(rs.getDate("indate"));

				foodList.add(food);

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
		return foodList;
	}

	public CustomerData selectData(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER_DATA WHERE ID=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				CustomerData data = new CustomerData();

				return data.setNum(rs.getInt("num")).setId(rs.getString("id")).setWeight(rs.getDouble("weight"))
						.setHeight(rs.getDouble("height")).setS_weight(rs.getDouble("S_weight"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"))
						.setIndate(rs.getTimestamp("indate"));
			} else {
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

	public int insertCart(Food food_D, Customer id) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO CALCULATOR_CART(id, fname, Kcal, Na, protein, K, P, Ca, indate) values(?, ?, ?, ?, ?, ?, ?, ?, NOW())";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id.getId());
			stmt.setString(2, food_D.getFname());
			stmt.setInt(3, food_D.getKcal());
			stmt.setInt(4, food_D.getNa());
			stmt.setInt(5, food_D.getProtein());
			stmt.setInt(6, food_D.getK());
			stmt.setInt(7, food_D.getP());
			stmt.setInt(8, food_D.getCa());

			stmt.executeUpdate();
			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update CALCULATOR_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			return stmt.executeUpdate();

		} catch (Exception e) {
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

	}

	public void updateCal(Calculator cal) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE CALCULATOR SET KCAL=?, NA=?, PROTEIN=?, K=?, P=?, CA=?, INDATE=NOW() WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cal.getKcal());
			stmt.setInt(2, cal.getNa());
			stmt.setInt(3, cal.getProtein());
			stmt.setInt(4, cal.getK());
			stmt.setInt(5, cal.getP());
			stmt.setInt(6, cal.getCa());
			stmt.setString(7, cal.getId());

			stmt.executeUpdate();

		} catch (Exception e) {
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

	}

	public Food selectFood(int fseq) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM FOOD WHERE fseq=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, fseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Food food = new Food();

				return food.setFseq(rs.getInt("fseq")).setFname(rs.getString("fname")).setKind(rs.getString("kind"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"))
						.setCapacity(rs.getInt("capacity")).setImage(rs.getString("image"))
						.setIndate(rs.getDate("indate"));

			} else {
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

	public Calculator selectCal(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CALCULATOR WHERE ID=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Calculator cal = new Calculator();
				return cal.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"));

			} else {
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

	public ArrayList<CalculatorCart> selectCart(String id, int page, int cnt2) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<CalculatorCart> calCarts = new ArrayList<CalculatorCart>();
		int page2 = (page - 1) * cnt2;
		String sql = "SELECT * FROM CALCULATOR_CART WHERE ID=? LIMIT ?,?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, page2);
			stmt.setInt(3, cnt2);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				CalculatorCart calCart = new CalculatorCart();
				calCart.setCseq(rs.getInt("cseq")).setFname(rs.getString("fname")).setKcal(rs.getInt("Kcal"))
						.setNa(rs.getInt("Na")).setProtein(rs.getInt("protein")).setK(rs.getInt("K"))
						.setP(rs.getInt("P")).setCa(rs.getInt("Ca"));

				calCarts.add(calCart);
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
		return calCarts;
	}

	public CalculatorCart selectCart(int cseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM CALCULATOR_CART WHERE cseq=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cseq);
			rs = stmt.executeQuery();

			if (rs.next()) {
				CalculatorCart calCart = new CalculatorCart();
				return calCart.setCseq(rs.getInt("cseq")).setId(rs.getString("id")).setFname(rs.getString("fname"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"));

			} else {
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

	public void deleteCart(int cseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;

		String sql = "DELETE FROM CALCULATOR_CART WHERE cseq=?";

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

			String sql3 = "update CALCULATOR_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();

		} catch (Exception e) {
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

	}

	// 푸드 총 페이징
/*	public int getAllCount(int kind) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from FOOD WHERE KIND=?";
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
*/
	// 푸드 총 페이징
	public int getAllCount(String search) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from FOOD WHERE FNAME LIKE '%" + search + "%' ORDER BY FNAME";
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
	
	//계산기카트 총 페이징
	public int getAllCount2(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from CALCULATOR_CART WHERE ID=? ORDER BY CSEQ";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
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
	
	// 푸드 총 페이징
	public int getAllCount() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from FOOD ORDER BY FNAME";
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
	
	public ArrayList<Food> list(int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Food> foodList = new ArrayList<Food>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM FOOD ORDER BY FNAME LIMIT ?, ?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Food food = new Food();

				food.setFseq(rs.getInt("fseq")).setFname(rs.getString("fname")).setKind(rs.getString("kind"))
						.setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("K")).setP(rs.getInt("P")).setCa(rs.getInt("Ca"))
						.setCapacity(rs.getInt("capacity")).setImage(rs.getString("image"))
						.setIndate(rs.getDate("indate"));

				foodList.add(food);

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
		return foodList;
	}
	
	// 푸드 총 페이징
		public int getAllCount(int kind) throws Exception {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			int count = 0;
			String sql = "select count(*) as count from FOOD WHERE kind=? ORDER BY FNAME";
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
