package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminhosdelete.do")
public class AdminHosDeleteController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminHosDeleteController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "no", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int no = (Integer)model.get("no");
		int page = (Integer)model.get("page");
		
		
			adminDao.hosDelete(no);
			
			return "redirect:adminhoslist.do?page=" +page;
		}
}
