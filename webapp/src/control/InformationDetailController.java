package control;

import java.util.Map;

import dao2.InformationDao;
import dto2.Information;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/informationD.do")
public class InformationDetailController implements Controller, DataBinding {

	private InformationDao informationDao;

	public InformationDetailController setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}

	public Object[] getDataBinders() {
		return new Object[] { "iseq", Integer.class, "kind", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Integer iseq = (Integer) model.get("iseq");
		Integer kind = (Integer) model.get("kind");
		Integer page = (Integer) model.get("page");
/*
		ArrayList<Information> infoList = informationDao.list(kind);

		model.put("infoList", infoList);
*/
		Information information = informationDao.detail(iseq, kind);
		model.put("info", information);
		model.put("page", page);
		
		if(kind == 1) {
			model.put("menu", "소식지");
			
			return "/kidney/InformationDetail.jsp";
		}
		else if(kind ==2) { 
			model.put("menu", "질병정보");
		}
		else if(kind == 3) {
			model.put("menu", "운동정보");
		}
		else {
			model.put("menu", "식단정보");
		}

		return "/kidney/InformationDetail2.jsp";
	}

}
