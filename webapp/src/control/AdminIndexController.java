package control;

import java.util.Map;

import dao2.InformationDao;
import webapp.Component;
import webapp.Controller;

@Component("/kidney/adminindex.do")
public class AdminIndexController implements Controller{

	private InformationDao informationDao;

	public AdminIndexController setInfomationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/kidney/AdminIndex.jsp";
	}

}
