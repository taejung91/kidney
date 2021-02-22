package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Hospital;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminhosdetail.do")
public class AdminHosDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminHosDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "no", Integer.class, "hospital", dto2.Hospital.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Hospital hos = (Hospital)model.get("hospital");
		int page = (Integer)model.get("page");

		if (hos.getName() == null) {
			int no = (Integer) model.get("no");
			Hospital hosDetail = adminDao.detailHospital(no);
			model.put("hosDetail", hosDetail);
			model.put("page", page);
			
			return "/kidney/AdminHosDetail.jsp";
	
		} else {
			adminDao.updateHospital(hos);
			return "redirect:adminhoslist.do?page="+page;

		}

	}

}