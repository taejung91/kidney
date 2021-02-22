package dao2;

import java.util.ArrayList;

import dto2.Calculator;
import dto2.CalculatorCart;
import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;

public interface CalculatorDao {

	ArrayList<Food> list(String search, int page, int cnt) throws Exception;
	ArrayList<Food> list(int kind, int page, int cnt) throws Exception;
	Food selectFood(int fseq) throws Exception;
	CustomerData selectData(String id)throws Exception;
	void updateCal(Calculator cal) throws Exception;
	int insertCart(Food food_D, Customer id)throws Exception;
	Calculator selectCal(String id)throws Exception;
	ArrayList<CalculatorCart> selectCart(String id, int page, int cnt2)throws Exception;
	CalculatorCart selectCart(int cseq)throws Exception;
	void deleteCart(int cseq)throws Exception;
	int getAllCount(String search)throws Exception;
//	int getAllCount()throws Exception;
	int getAllCount2(String id)throws Exception;
	int getAllCount()throws Exception;
	ArrayList<Food> list(int page, int cnt) throws Exception;
	int getAllCount(int kind)throws Exception;
	
}
