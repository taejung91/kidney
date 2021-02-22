package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincalreset.do")
public class AdminCalResetController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCalResetController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		
			adminDao.calReset();
			
			return "redirect:adminindex.do";
		}
}