package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Address;
import dto2.Customer;
import dto2.CustomerData;

public class MySqlCustomerDao implements CustomerDao {
	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public int insert(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO CUSTOMER(ID, PW, NAME, BIRTH, GENDER, TEL, EMAIL, ADD1, ADD2, INDATE, RECEIVE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			stmt.setString(2, customer.getPw());
			stmt.setString(3, customer.getName());
			stmt.setString(4, customer.getBirth());
			stmt.setString(5, customer.getGender());
			stmt.setString(6, customer.getTel());
			stmt.setString(7, customer.getEmail());
			stmt.setString(8, customer.getAdd1());
			stmt.setString(9, customer.getAdd2());
			stmt.setString(10, customer.getReceive());

			stmt.executeUpdate();
			stmt.close();

			String sql2 = "INSERT INTO CUSTOMER_DATA(ID) VALUES(?)";
			stmt = conn.prepareStatement(sql2);
			stmt.setString(1, customer.getId());

			stmt.executeUpdate();
			stmt.close();

			String sql3 = "INSERT INTO CALCULATOR(ID) VALUES(?)";
			stmt = conn.prepareStatement(sql3);
			stmt.setString(1, customer.getId());

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

	public Customer login(String id, String pw) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE ID=? AND PW=? AND DELETEYN=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, "사용중");

			rs = stmt.executeQuery();

			if (rs.next()) {
				Customer customer = new Customer();
				return customer.setId(rs.getString("id")).setName(rs.getString("name"))
						.setDeleteyn(rs.getString("deleteyn"));
			} else {
				return null;
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

	public Customer searchID(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE NAME=? AND tel=? AND DELETEYN=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getTel());
			stmt.setString(3, "사용중");
			rs = stmt.executeQuery();

			if (rs.next()) {
					return customer.setName(rs.getString("name")).setId(rs.getString("id"))
							.setIndate(rs.getDate("indate"));
			
			} else {
				return null;
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
	
	public Customer searchPW(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE NAME=? AND tel=? AND ID=? AND DELETEYN=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getTel());
			stmt.setString(3, customer.getId());
			stmt.setString(4, "사용중");
			rs = stmt.executeQuery();

			if (rs.next()) {
					return customer.setName(rs.getString("name")).setId(rs.getString("id"))
							.setIndate(rs.getDate("indate")).setPw(rs.getString("pw"));
				
			} else {
				return null;
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

	public ArrayList<Address> address(String dong) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Address> addresslist = new ArrayList<Address>();
		String sql = "SELECT * FROM ZIPCODE WHERE DONG LIKE '%" + dong + "%'";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Address address = new Address();
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setZipCode(rs.getString("zipcode"));
				address.setBunji(rs.getString("bunji"));

				addresslist.add(address);
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
		return addresslist;
	}

	public Customer select(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return customer.setId(rs.getString("id")).setName(rs.getString("name")).setBirth(rs.getString("birth"))
						.setGender(rs.getString("gender")).setTel(rs.getString("tel")).setEmail(rs.getString("email"))
						.setAdd1(rs.getString("add1")).setAdd2(rs.getString("add2"))
						.setReceive(rs.getString("receive")).setPw(rs.getString("pw"));

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

	public int update(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE CUSTOMER SET BIRTH=?, GENDER=?, TEL=?, EMAIL=?, ADD1=?, ADD2=?, RECEIVE=? WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getBirth());
			stmt.setString(2, customer.getGender());
			stmt.setString(3, customer.getTel());
			stmt.setString(4, customer.getEmail());
			stmt.setString(5, customer.getAdd1());
			stmt.setString(6, customer.getAdd2());
			stmt.setString(7, customer.getReceive());
			stmt.setString(8, customer.getId());
			stmt.executeUpdate();

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

	public int delete(Customer customer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE CUSTOMER SET DELETEYN=? WHERE ID=? ";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "회원탈퇴");
			stmt.setString(2, customer.getId());

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

	public Customer checkID(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Customer customer = new Customer();
		String sql = "SELECT ID FROM CUSTOMER WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {

				customer.setId(rs.getString("id"));
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
		return customer;
	}

	public CustomerData selectData(Customer check) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER_DATA WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, check.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				CustomerData customerData = new CustomerData();
				return customerData.setWeight(rs.getDouble("weight")).setHeight(rs.getDouble("height"))
						.setS_weight(rs.getDouble("s_weight")).setKcal(rs.getInt("Kcal")).setNa(rs.getInt("Na"))
						.setProtein(rs.getInt("protein")).setK(rs.getInt("K")).setP(rs.getInt("P"))
						.setCa(rs.getInt("Ca")).setId(rs.getString("id"));

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

	// 추가정보 입력 및 수정 & 계산기 값 초기화 & 카트 초기화
	public int updateData(CustomerData customerData) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE CUSTOMER_DATA SET WEIGHT=?, HEIGHT=?, S_WEIGHT=?, KCAL=?, NA=?, PROTEIN=?, K=?, P=?, CA=?, INDATE=NOW() WHERE ID=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, customerData.getWeight());
			stmt.setDouble(2, customerData.getHeight());
			stmt.setDouble(3, customerData.getS_weight());
			stmt.setDouble(4, customerData.getKcal());
			stmt.setDouble(5, 2000);
			stmt.setDouble(6, customerData.getProtein());
			stmt.setDouble(7, 2000);
			stmt.setDouble(8, customerData.getP());
			stmt.setDouble(9, 1500);
			stmt.setString(10, customerData.getId());
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "UPDATE CALCULATOR SET KCAL=?, NA=?, PROTEIN=?, K=?, P=?, CA=?, INDATE=NOW() WHERE ID=?";
			stmt = conn.prepareStatement(sql2);
			stmt.setInt(1, 0);
			stmt.setInt(2, 0);
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.setInt(5, 0);
			stmt.setInt(6, 0);
			stmt.setString(7, customerData.getId());
			stmt.executeUpdate();
			stmt.close();
			
			String sql3 = "DELETE FROM CALCULATOR_CART WHERE id=?";
			stmt = conn.prepareStatement(sql3);
			stmt.setString(1, customerData.getId());
			stmt.executeUpdate();
			stmt.close();

			String sql4 = "set @count=0";
			stmt = conn.prepareStatement(sql4);
			stmt.executeUpdate();
			stmt.close();

			String sql5 = "update CALCULATOR_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql5);
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

}
