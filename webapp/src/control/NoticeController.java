package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.InformationDao;
import dto2.Information;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/notice.do")
public class NoticeController implements Controller, DataBinding{
	private InformationDao informationDao;
	
	public NoticeController setInfomationDao(InformationDao informationDao) {
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
		paging.setDisplayRow(8);
		int cnt = paging.getDisplayRow();
		//DB 총 갯수
		int count = informationDao.getAllCount(kind);
		//url 주소
	//	paging.setUrl("");
		
		paging.setTotalCount(count);
		paging.setPage(page);
	
		
		ArrayList<Information> infoList = informationDao.list(kind, page, cnt);
		
		model.put("infoList", infoList);
		model.put("menu", "공지사항");
		model.put("paging", paging);
		model.put("kind", kind);
		model.put("page", page);
		

		
		return "/kidney/Notice.jsp";
	}

}
