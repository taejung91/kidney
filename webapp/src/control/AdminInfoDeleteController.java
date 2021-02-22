package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/amdininfodelete.do")
public class AdminInfoDeleteController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminInfoDeleteController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "iseq", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int iseq = (Integer)model.get("iseq");
		
			adminDao.infoDelete(iseq);
			
			return "redirect:admininfolist.do?page=1";
		}
}
