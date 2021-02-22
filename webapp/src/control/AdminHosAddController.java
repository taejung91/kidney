package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Hospital;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminhosadd.do")
public class AdminHosAddController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminHosAddController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "hospital", dto2.Hospital.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Hospital hospital = (Hospital) model.get("hospital");
		int page = (Integer)model.get("page");
		if (hospital.getName() == null) {
			model.put("page", page);
			return "/kidney/AdminHospital.jsp";
		} else {
			adminDao.addHospital(hospital);
			return "redirect:adminhoslist.do?page="+page;
		}

	}
}