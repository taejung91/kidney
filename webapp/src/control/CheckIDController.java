package control;

import java.util.Map;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/checkid.do")
public class CheckIDController implements Controller, DataBinding {
	
	private CustomerDao customerDao;
	public CheckIDController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"customer", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Customer customer = (Customer)model.get("customer");
		
		Customer check = customerDao.checkID(customer.getId());
		
		model.put("check", check);
		return "/kidney/CheckID.jsp";
	}
	

}
