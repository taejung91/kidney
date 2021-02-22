package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.CustomerData;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincustomerdetail.do")
public class AdminCustomerDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCustomerDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", String.class, "page", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String customer = (String) model.get("id");
		int page = (Integer)model.get("page");
		
			CustomerData customerData = adminDao.detailCustomer(customer);
			model.put("customerData", customerData);
			model.put("page", page);
			
			return "/kidney/AdminCustomerDetail.jsp";

		}

	}


