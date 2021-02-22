package control;

import java.util.Map;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/create.do")
public class CreateController implements Controller, DataBinding {
	private CustomerDao customerDao;
	
	public CreateController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"customer", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		Customer customer = (Customer) model.get("customer");
		
		if(customer.getId() == null) {
			return "/kidney/Create.jsp";
		}else {
			
			String tel1 = customer.getTel1();
			String tel2 = customer.getTel2();
			String tel3 = customer.getTel3();
			
			customer.setTel(tel1 + "-" + tel2 + "-" + tel3);
			
			
			customerDao.insert(customer);
			
			return "redirect:index.do";
		
		}
		
	}

}
