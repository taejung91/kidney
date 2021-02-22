package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminproductdelete.do")
public class AdminProductDeleteController  implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminProductDeleteController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "pseq", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int pseq = (Integer)model.get("pseq");
		int page = (Integer)model.get("page");
		
		
			adminDao.productDelete(pseq);
			
			return "redirect:adminproductlist.do?page="+page;
		}
}
