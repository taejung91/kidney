package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.InformationDao;
import dto2.Hospital;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/hospital.do")
public class HospitalController implements Controller, DataBinding{
	
	private InformationDao informationDao;
	
	public HospitalController setInformationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"search", String.class, "page", Integer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		
		String search = (String)model.get("search");
		
		//페이징
   	    int page = (Integer)model.get("page");
		Paging paging = new Paging();
		//보여주는 글 수 
		paging.setDisplayRow(10);
		int cnt = paging.getDisplayRow();
		//DB 총 갯수
		int count = informationDao.getAllCount(search);
		//url 주소
	//	paging.setUrl("");
		
		paging.setTotalCount(count);
		paging.setPage(page);
	
		
		ArrayList<Hospital> hospitalList = informationDao.listHospital(search, page, cnt);
		
		
		model.put("hospitalList", hospitalList);
		model.put("paging", paging);
		model.put("page", page);
		model.put("search", search);
		
		
		return "/kidney/Hospital.jsp";
		
	}
		

}
