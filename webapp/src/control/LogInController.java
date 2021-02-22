package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/login.do")
public class LogInController implements Controller, DataBinding{
	
	private CustomerDao customerDao;
	public LogInController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"login", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model)throws Exception{
		
		Customer login = (Customer)model.get("login");

		if(login.getId() == null) {
			return "/kidney/LogInForm.jsp";
		}else {
			Customer customer = customerDao.login(login.getId(), login.getPw());
			//차트 값 세션 저장??
			if(customer != null) {
				if(customer.getId().equals("관리자")) {
					HttpSession session = (HttpSession) model.get("session");
					session.setAttribute("loginInfo", customer);
					return "redirect:adminindex.do";
				}else {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("loginInfo", customer);
				return "redirect:index.do";
				}
			}else { 
				return "/kidney/LogInFail.jsp";
			}
			
			
		}
	}
	
	

}
