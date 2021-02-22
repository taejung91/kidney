package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.QnaDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/qnadelete.do")
public class QnaDeleteController implements Controller, DataBinding {

	private QnaDao qnaDao;

	public QnaDeleteController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	public Object[] getDataBinders() {
		return new Object[] {"qseq", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		int qseq = (Integer)model.get("qseq");
		int page = (Integer)model.get("page");
		
		
		if(login == null) {
			return "redirect:login.do";
		}else {
			
			qnaDao.qnaDelete(qseq);
		//	model.put("page", page);
			
			return "redirect:qnalist.do?page=" + page;
		}
		
	}

}
