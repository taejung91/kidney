package control;

import java.util.Map;

import dao2.InformationDao;
import dto2.Hospital;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/hospitaldetail.do")
public class HospitalDetailController implements Controller, DataBinding{
	
	private InformationDao informationDao;
	public HospitalDetailController setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"no", String.class};
	}
	
	@Override
	public String execute(Map<String, Object> model)throws Exception{
		
		String no = (String)model.get("no");
		
		Hospital detail = informationDao.detailHospital(no);
		
		model.put("hospital", detail);
		
		return "/kidney/HospitalDetail.jsp";
		
	}
		

}
