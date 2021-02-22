package control;

import java.util.Map;

import dao2.AdminDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincaldelete.do")
public class AdminCalDeleteController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCalDeleteController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "fseq", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int fseq = (Integer)model.get("fseq");
		int page = (Integer)model.get("page");
		
		
			adminDao.calDelete(fseq);
			
			return "redirect:admincallist.do?page="+page;
		}
}
