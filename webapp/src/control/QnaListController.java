package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.QnaDao;
import dto2.Customer;
import dto2.Paging;
import dto2.Qna;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/qnalist.do")
public class QnaListController implements Controller, DataBinding {

	private QnaDao qnaDao;

	public QnaListController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	public Object[] getDataBinders() {
		return new Object[] {"page", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		
		if(login == null) {
			return "redirect:login.do";
		}else {
			
			//페이징
	   	    int page = (Integer)model.get("page");
			Paging paging = new Paging();
			//보여주는 글 수 
			paging.setDisplayRow(8);
			int cnt = paging.getDisplayRow();
			//DB 총 갯수
			int count = qnaDao.getAllCount();
			//url 주소
		//	paging.setUrl("");
			
			paging.setTotalCount(count);
			paging.setPage(page);
		
						
			ArrayList<Qna> qnaList = qnaDao.qnaList(login.getId(), page, cnt);
			
			model.put("qnaList", qnaList);
			model.put("paging", paging);
			model.put("page", page);
			
			return "/kidney/QnaList.jsp";
		}
		
	}

}
