package dao2;

import java.util.ArrayList;

import dto2.Order;

public interface OrderDao {

//	void select(int pseq);

	Order orderInsert(String id, int pseq, int quantity1, int quantity2, int cseq)throws Exception;

	ArrayList<Integer> selectOseqOrderIng(String id) throws Exception;

	ArrayList<Order> orderListById(String id, String result, int page, int cnt) throws Exception;

	Order list(int odseq)throws Exception;

	Order orderDetail(int oseq)throws Exception;

	void orderDelete(int oseq)throws Exception;

	int getAllCount(String id)throws Exception;
	
	

}
