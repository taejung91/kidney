package dao2;

import java.util.ArrayList;

import dto2.Cart;

public interface CartDao {

	void cartInsert(String id, int pseq, int quantity1, int quantity2)throws Exception;

	ArrayList<Cart> cartList(String id, int page, int cnt)throws Exception;

	void delete(int cseq)throws Exception;

	Cart cartList(int cseq)throws Exception;

	int select(String id, int pseq)throws Exception;

	int getAllCount(String id)throws Exception;

}
