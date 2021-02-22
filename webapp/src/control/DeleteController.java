package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/delete.do")
public class DeleteController implements Controller, DataBinding{
	
	private CustomerDao customerDao;
	public DeleteController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {"customer", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object>model) throws Exception{
		
		Customer customer = (Customer)model.get("customer");
		if(customer.getName() == null) {
			Customer cus = customerDao.select(customer);
			model.put("customer", cus);
			 return "/kidney/Delete.jsp";
		}else {
			 customerDao.delete(customer);
			 HttpSession session = (HttpSession) model.get("session");
			 session.invalidate();
			 return "redirect:index.do";
		}
	}

}
