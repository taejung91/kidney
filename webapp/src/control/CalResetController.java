package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/calreset.do")
public class CalResetController implements Controller, DataBinding {

	private AdminDao adminDao;

	public CalResetController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"page", Integer.class, "page2", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int page = (Integer)model.get("page");
		int page2 = (Integer)model.get("page2");
		

		
			adminDao.calReset();
			
			return "redirect:cal_form.do?page=" + page + "&page2=" + page2;
		}
}