package dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;
import dto2.Hospital;
import dto2.Information;
import dto2.Order;
import dto2.Product;
import dto2.Qna;
import webapp.DBAction;

public class MySqlAdminDao implements AdminDao {

	private DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public void addinfo(Information info) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO INFORMATION(KIND, TITLE, CONTENT, IMAGE, INDATE) VALUES(?, ?, ?, ?, NOW())";
		int result = -1;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, info.getKind());
			stmt.setString(2, info.getTitle());
			stmt.setString(3, info.getContent());
			stmt.setString(4, info.getImage());

			result = stmt.executeUpdate();

			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update INFORMATION SET ISEQ=@count:=@count+1";
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
			}

		}

	}

	public ArrayList<Information> listInfo(int page, int cnt) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// int cnt = 10;
		int page2 = (page - 1) * cnt;

		ArrayList<Information> infoList = new ArrayList<Information>();
		String sql = "SELECT * FROM INFORMATION ORDER BY KIND DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);

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

	public Information detailInfo(int iseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Information information = null;
		String sql = "SELECT * FROM INFORMATION WHERE ISEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, iseq);
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

	public void infoDelete(int iseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM INFORMATION WHERE ISEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, iseq);
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update INFORMATION SET ISEQ=@count:=@count+1";
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

	public ArrayList<Food> listFood(int page, int cnt) throws Exception {
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

	public void addFood(Food food) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO FOOD(FNAME, KIND, KCAL, NA, PROTEIN, K, P, CA, CAPACITY, INDATE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food.getFname());
			stmt.setString(2, food.getKind());
			stmt.setInt(3, food.getKcal());
			stmt.setInt(4, food.getNa());
			stmt.setInt(5, food.getProtein());
			stmt.setInt(6, food.getK());
			stmt.setInt(7, food.getP());
			stmt.setInt(8, food.getCa());
			stmt.setInt(9, food.getCapacity());

			stmt.executeUpdate();

			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update FOOD SET FSEQ=@count:=@count+1";
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
			}

		}

	}

	public void calDelete(int fseq) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM FOOD WHERE FSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, fseq);
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update FOOD SET FSEQ=@count:=@count+1";
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

	public Food detailFood(int fseq) throws Exception {

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

	public int updateFood(Food food) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE FOOD SET FNAME=?, KIND=?, KCAL=?, NA=?, PROTEIN=?, K=?, P=?, CA=?, CAPACITY=? WHERE FSEQ=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, food.getFname());
			stmt.setString(2, food.getKind());
			stmt.setInt(3, food.getKcal());
			stmt.setInt(4, food.getNa());
			stmt.setInt(5, food.getProtein());
			stmt.setInt(6, food.getK());
			stmt.setInt(7, food.getP());
			stmt.setInt(8, food.getCa());
			stmt.setInt(9, food.getCapacity());
			stmt.setInt(10, food.getFseq());

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

	public ArrayList<Hospital> listHospital(int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Hospital> hosList = new ArrayList<Hospital>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM HOSPITAL LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Hospital hospital = new Hospital();

				hospital.setNo(rs.getInt("No")).setName(rs.getString("name")).setAddress(rs.getString("address"))
						.setTel(rs.getString("tel")).setConfirm(rs.getString("confirm"))
						.setDoctor(rs.getString("doctor")).setDoctor_yn(rs.getString("doctor_yn"));

				hosList.add(hospital);

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
		return hosList;

	}

	public void addHospital(Hospital hospital) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO HOSPITAL(NAME, ADDRESS, TEL, CONFIRM, DOCTOR, DOCTOR_YN) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hospital.getName());
			stmt.setString(2, hospital.getAddress());
			stmt.setString(3, hospital.getTel());
			stmt.setString(4, hospital.getConfirm());
			stmt.setString(5, hospital.getDoctor());
			stmt.setString(6, hospital.getDoctor_yn());

			stmt.executeUpdate();

			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update HOSPITAL SET NO=@count:=@count+1";
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
			}

		}
	}

	public void hosDelete(int no) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM HOSPITAL WHERE NO=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update HOSPITAL SET NO=@count:=@count+1";
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

	public Hospital detailHospital(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM HOSPITAL WHERE No=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Hospital hospital = new Hospital();

				return hospital.setNo(rs.getInt("No")).setName(rs.getString("name")).setAddress(rs.getString("address"))
						.setTel(rs.getString("tel")).setConfirm(rs.getString("confirm"))
						.setDoctor(rs.getString("doctor")).setDoctor_yn(rs.getString("doctor_yn"));
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

	public void updateHospital(Hospital hos) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE HOSPITAL SET NAME=?, ADDRESS=?, TEL=?, CONFIRM=?, DOCTOR=?, DOCTOR_YN=? WHERE NO=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, hos.getName());
			stmt.setString(2, hos.getAddress());
			stmt.setString(3, hos.getTel());
			stmt.setString(4, hos.getConfirm());
			stmt.setString(5, hos.getDoctor());
			stmt.setString(6, hos.getDoctor_yn());
			stmt.setInt(7, hos.getNo());
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

	public ArrayList<Product> listTour(int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM T_PRODUCT ORDER BY KIND DESC LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setKind(rs.getString("kind"))
						.setPrice1(rs.getInt("price1")).setPrice2(rs.getInt("price2"))
						.setQuantity(rs.getInt("quantity")).setSchedule(rs.getString("schedule"))
						.setS_schedule(rs.getString("s_schedule")).setE_schedule(rs.getString("e_schedule"))
						.setRoute(rs.getString("route")).setIndate(rs.getDate("indate")).setImage(rs.getString("image"))
						.setContent(rs.getString("content"));

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

	public void productDelete(int pseq) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM T_PRODUCT WHERE PSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pseq);
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_PRODUCT SET PSEQ=@count:=@count+1";
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

	public void addProduct(Product tour) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO T_PRODUCT(NAME, KIND, PRICE1, PRICE2, QUANTITY, SCHEDULE, S_SCHEDULE, E_SCHEDULE, ROUTE, CONTENT, IMAGE, INDATE) VALUES(?, ?, ?, ?, ?, ?,?,?,?,?,?,now())";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tour.getName());
			stmt.setString(2, tour.getKind());
			stmt.setInt(3, tour.getPrice1());
			stmt.setInt(4, tour.getPrice2());
			stmt.setInt(5, tour.getQuantity());
			stmt.setString(6, tour.getSchedule());
			stmt.setString(7, tour.getS_schedule());
			stmt.setString(8, tour.getE_schedule());
			stmt.setString(9, tour.getRoute());
			stmt.setString(10, tour.getContent());
			stmt.setString(11, tour.getImage());

			stmt.executeUpdate();

			stmt.close();

			String sql2 = "set @count=0";
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "update T_PRODUCT SET PSEQ=@count:=@count+1";
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
			}

		}

	}

	public Product detailProduct(int pseq) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		String sql = "SELECT * FROM t_product WHERE PSEQ=?";

		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pseq);
			rs = stmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setPseq(rs.getInt("pseq")).setName(rs.getString("name")).setKind(rs.getString("kind"))
						.setPrice1(rs.getInt("price1")).setPrice2(rs.getInt("price2"))
						.setQuantity(rs.getInt("quantity")).setSchedule(rs.getString("schedule"))
						.setS_schedule(rs.getString("s_schedule")).setE_schedule(rs.getString("e_schedule"))
						.setRoute(rs.getString("route")).setContent(rs.getString("content"))
						.setImage(rs.getString("image")).setUseyn(rs.getString("useyn"))
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

	public void updateProduct(Product tour) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE T_PRODUCT SET NAME=?, PRICE1=?, PRICE2=?, QUANTITY=?, SCHEDULE=?, S_SCHEDULE=?, E_SCHEDULE=?, ROUTE=?, CONTENT=? WHERE PSEQ=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tour.getName());
			stmt.setInt(2, tour.getPrice1());
			stmt.setInt(3, tour.getPrice2());
			stmt.setInt(4, tour.getQuantity());
			stmt.setString(5, tour.getSchedule());
			stmt.setString(6, tour.getS_schedule());
			stmt.setString(7, tour.getE_schedule());
			stmt.setString(8, tour.getRoute());
			stmt.setString(9, tour.getContent());
			stmt.setInt(10, tour.getPseq());

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

	public ArrayList<Customer> listCustomer(int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int page2 = (page - 1) * cnt;
		String sql = "SELECT * FROM CUSTOMER ORDER BY NAME LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id")).setName(rs.getString("name")).setBirth(rs.getString("birth"))
						.setGender(rs.getString("gender")).setTel(rs.getString("tel")).setEmail(rs.getString("email"))
						.setAdd1(rs.getString("add1")).setAdd2(rs.getString("add2")).setReceive(rs.getString("receive"))
						.setIndate(rs.getDate("indate")).setDeleteyn(rs.getString("deleteyn"));

				customerList.add(customer);

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
		return customerList;
	}

	public void customerDelete(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE ID=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "DELETE FROM T_ORDERS WHERE ID=?";
			stmt = conn.prepareStatement(sql2);
			stmt.setString(1, id);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "DELETE FROM T_QNA WHERE ID=?";
			stmt = conn.prepareStatement(sql3);
			stmt.setString(1, id);
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

	public void calReset() throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE CALCULATOR SET KCAL=?, NA=?, PROTEIN=?, K=?, P=?, CA=?, INDATE=NOW()";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setInt(2, 0);
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.setInt(5, 0);
			stmt.setInt(6, 0);
			stmt.executeUpdate();
			stmt.close();

			String sql3 = "DELETE FROM CALCULATOR_CART";
			stmt = conn.prepareStatement(sql3);
			stmt.executeUpdate();
			stmt.close();

			String sql4 = "set @count=0";
			stmt = conn.prepareStatement(sql4);
			stmt.executeUpdate();
			stmt.close();

			String sql5 = "update CALCULATOR_CART SET CSEQ=@count:=@count+1";
			stmt = conn.prepareStatement(sql5);
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

	public CustomerData detailCustomer(String customer) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;

		String sql = "SELECT * FROM CUSTOMER_DATA WHERE ID=?";

		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer);
			rs = stmt.executeQuery();
			if (rs.next()) {
				CustomerData customerData = new CustomerData();
				return customerData.setId(rs.getString("id")).setWeight(rs.getDouble("weight"))
						.setHeight(rs.getDouble("height")).setS_weight(rs.getDouble("s_weight"))
						.setKcal(rs.getInt("kcal")).setNa(rs.getInt("na")).setProtein(rs.getInt("protein"))
						.setK(rs.getInt("k")).setP(rs.getInt("p")).setCa(rs.getInt("ca"));
			} else {
				throw new Exception();
			}

		} catch (SQLException e) {
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

	public ArrayList<Qna> listQna(int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Qna> qnaList = new ArrayList<Qna>();
		int page2 = (page - 1) * cnt;

		String sql = "SELECT * FROM T_QNA ORDER BY QSEQ LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQseq(rs.getInt("qseq")).setSubject(rs.getString("subject")).setContent(rs.getString("content"))
						.setReply(rs.getString("reply")).setId(rs.getString("id")).setRep(rs.getString("rep"))
						.setIndate(rs.getTimestamp("indate"));

				qnaList.add(qna);

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
		return qnaList;
	}

	public Qna detailQna(int qseq) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_QNA WHERE QSEQ=?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, qseq);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Qna qna = new Qna();
				return qna.setQseq(rs.getInt("qseq")).setSubject(rs.getString("subject"))
						.setContent(rs.getString("content")).setReply(rs.getString("reply")).setId(rs.getString("id"))
						.setRep(rs.getString("rep")).setIndate(rs.getTimestamp("indate"));
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

	public void updateQna(Qna qna) throws Exception {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE T_QNA SET REPLY=?, REP=? WHERE QSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qna.getReply());
			stmt.setInt(2, 2);
			stmt.setInt(3, qna.getQseq());
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

	public ArrayList<Order> listOrder(int page, int cnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = new ArrayList<Order>();
		int page2 = (page - 1) * cnt;

		String sql = "SELECT * FROM T_ORDER_VIEW LIMIT ?, ?";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, page2);
			stmt.setInt(2, cnt);

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

				orderList.add(order);
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
		return orderList;
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

	public void orderDelete(int oseq) throws Exception {

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
			 * String sql2 = "set @count=0"; stmt = conn.prepareStatement(sql2);
			 * stmt.executeUpdate(); stmt.close();
			 * 
			 * String sql3 = "update T_ORDERS SET OSEQ=@count:=@count+1"; stmt =
			 * conn.prepareStatement(sql3); stmt.executeUpdate(); stmt.close();
			 */
			String sql4 = "DELETE FROM T_ORDER_DETAIL WHERE OSEQ=?";
			stmt = conn.prepareStatement(sql4);
			stmt.setInt(1, oseq);
			stmt.executeUpdate();
			/*
			 * stmt.close();
			 * 
			 * String sql5 = "set @count=0"; stmt = conn.prepareStatement(sql5);
			 * stmt.executeUpdate(); stmt.close();
			 * 
			 * String sql6 = "update T_ORDER_DETAIL SET ODSEQ=@count:=@count+1"; stmt =
			 * conn.prepareStatement(sql6); stmt.executeUpdate();
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

	public void updateOrder(Order order) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE T_ORDERS SET RESULT=? WHERE OSEQ=?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			stmt.setInt(2, order.getOseq());
			stmt.executeUpdate();
			stmt.close();

			String sql2 = "UPDATE T_ORDER_DETAIL SET RESULT=? WHERE OSEQ=?";
			stmt = conn.prepareStatement(sql2);
			stmt.setInt(1, 2);
			stmt.setInt(2, order.getOseq());
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

	// 정보 총 페이징
	public int getAllCount() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from information";
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

	// 음식 총 페이징
	public int getAllCount2() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from FOOD";
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

	// 병원 총 페이징
	public int getAllCount3() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from HOSPITAL";
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

	// 상품 총 페이징
	public int getAllCount4() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from T_PRODUCT";
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

	// 주문 총 페이징
	public int getAllCount5() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from T_ORDER_VIEW";
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

	// 고객 총 페이징
	public int getAllCount6() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) as count from CUSTOMER";
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
	//QNA 총 페이징
	public int getAllCount7() throws Exception {
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
