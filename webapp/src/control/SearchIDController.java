package control;

import java.util.Map;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/searchid.do")
public class SearchIDController implements Controller, DataBinding{
	
	private CustomerDao customerDao;
	public SearchIDController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"customer", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		
		Customer customer = (Customer)model.get("customer");
		
		if(customer.getName() == null) {
			return "/kidney/SearchID.jsp";
		}else {
			
			String tel1 = customer.getTel1();
			String tel2 = customer.getTel2();
			String tel3 = customer.getTel3();
			customer.setTel(tel1 + "-" + tel2 + "-" + tel3);
			Customer search = customerDao.searchID(customer);
			
			if(search != null) {
				
				model.put("search", search);
				model.put("subject", "아이디");
				return "/kidney/SearchSuccess.jsp"; // 찾기 완료 jsp
			}else {
				model.put("subject", "아이디");
				return "/kidney/SearchFail.jsp";  //실패
			}
		}
	}

}
