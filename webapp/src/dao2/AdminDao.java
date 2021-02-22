package dao2;

import java.util.ArrayList;

import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;
import dto2.Hospital;
import dto2.Information;
import dto2.Order;
import dto2.Product;
import dto2.Qna;

public interface AdminDao {

	void addinfo(Information info) throws Exception;

	ArrayList<Information> listInfo(int page, int cnt)throws Exception;

	Information detailInfo(int iseq)throws Exception;

	void infoDelete(int iseq)throws Exception;

	ArrayList<Food> listFood(int page, int cnt)throws Exception;

	void addFood(Food food) throws Exception;

	void calDelete(int fseq)throws Exception;

	Food detailFood(int fseq)throws Exception;

	int updateFood(Food food)throws Exception;

	ArrayList<Hospital> listHospital(int page, int cnt)throws Exception;

	void addHospital(Hospital hospital)throws Exception;

	void hosDelete(int no)throws Exception;

	Hospital detailHospital(int no)throws Exception;

	void updateHospital(Hospital hos)throws Exception;

	ArrayList<Product> listTour(int page, int cnt)throws Exception;

	void productDelete(int pseq)throws Exception;

	void addProduct(Product tour)throws Exception;

	Product detailProduct(int pseq)throws Exception;

	void updateProduct(Product tour)throws Exception;

	ArrayList<Customer> listCustomer(int page, int cnt)throws Exception;

	void customerDelete(String id)throws Exception;

	void calReset()throws Exception;

	CustomerData detailCustomer(String customer)throws Exception;

	ArrayList<Qna> listQna(int page, int cnt)throws Exception;

	Qna detailQna(int qseq)throws Exception;

	void updateQna(Qna qna)throws Exception;

	ArrayList<Order> listOrder(int page, int cnt)throws Exception;

	Order orderDetail(int oseq)throws Exception;

	void orderDelete(int oseq)throws Exception;

	void updateOrder(Order order)throws Exception;

	int getAllCount()throws Exception;

	int getAllCount2()throws Exception;

	int getAllCount3()throws Exception;

	int getAllCount4()throws Exception;

	int getAllCount5()throws Exception;

	int getAllCount6()throws Exception;

	int getAllCount7()throws Exception;

}
