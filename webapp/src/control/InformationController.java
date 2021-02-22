package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.InformationDao;
import dto2.Information;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/information.do")
public class InformationController implements Controller, DataBinding{
	private InformationDao informationDao;
	
	public InformationController setInfomationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"kind", Integer.class, "page", Integer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		Integer kind = (Integer)model.get("kind");
		
		//페이징
   	    int page = (Integer)model.get("page");
		Paging paging = new Paging();
		//보여주는 글 수 
		paging.setDisplayRow(4);
		int cnt = paging.getDisplayRow();
		//DB 총 갯수
		int count = informationDao.getAllCount(kind);
		//url 주소
	//	paging.setUrl("");
		
		paging.setTotalCount(count);
		paging.setPage(page);
	
		
    	ArrayList<Information> infoList = informationDao.list(kind, page, cnt);
		
		
		model.put("infoList", infoList);
		model.put("paging", paging);
		model.put("page", page);
		
		
		
		if(kind == 1) {
			model.put("menu", "소식");
			model.put("menu2", "소식지");
			model.put("kind", kind);
		}
		else { 
			model.put("menu", "신장질환 정보");
			model.put("menu3", "질병정보");
		
			
			
			model.put("menu4", "운동정보");
		
			
			model.put("menu5", "식단정보");
			model.put("kind", kind);
			
		}
		
		
		return "/kidney/Information.jsp";
	}

}
