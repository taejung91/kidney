package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincustomerdelete.do")
public class AdminCustomerDeleteController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCustomerDeleteController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "id", String.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		String id = (String)model.get("id");
		int page = (Integer)model.get("page");
		
			adminDao.customerDelete(id);
			
			return "redirect:admincustomerlist.do?page="+page;
		}
}
