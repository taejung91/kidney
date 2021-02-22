package dao2;

import java.util.ArrayList;

import dto2.Address;
import dto2.Customer;
import dto2.CustomerData;

public interface CustomerDao {

	int insert(Customer customer) throws Exception;

	Customer login(String id, String pw)throws Exception;

	Customer searchID(Customer customer)throws Exception;

	Customer searchPW(Customer customer)throws Exception;

	ArrayList<Address> address(String dong)throws Exception;

	Customer select(Customer customer)throws Exception;

	int update(Customer customer)throws Exception;

	int delete(Customer customer)throws Exception;

	Customer checkID(String id)throws Exception;

	CustomerData selectData(Customer check) throws Exception;

	int updateData(CustomerData customerData)throws Exception ;
	

}
