package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Information;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admininfodetail.do")
public class AdminInfoDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminInfoDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"kind", Integer.class, "iseq", Integer.class, "page", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int iseq = (Integer)model.get("iseq");
		int page = (Integer)model.get("page");
		int kind = (Integer) model.get("kind");
		
		
			Information info = adminDao.detailInfo(iseq);
			model.put("info", info);
			model.put("page", page);
			
			if(kind == 1) {
				
			return "/kidney/AdminInfoDetail.jsp";
			}
			else if(kind ==2) { 
			}
			else if(kind == 3) {
			}
			else {
			}

			return "/kidney/AdminInfoDetail2.jsp";
		}

	}
