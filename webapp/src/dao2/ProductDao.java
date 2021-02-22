package dao2;

import java.util.ArrayList;

import dto2.Product;

public interface ProductDao {

	ArrayList<Product> list(int kind, int page, int cnt)throws Exception;
	Product detail(int pseq)throws Exception;
	void updateQuantity(int pseq, int quantity)throws Exception;
	int getAllCount(int kind)throws Exception;

}
