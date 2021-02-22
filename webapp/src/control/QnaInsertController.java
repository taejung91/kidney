package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.QnaDao;
import dto2.Customer;
import dto2.Qna;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/qnainsert.do")
public class QnaInsertController implements Controller, DataBinding {

	private QnaDao qnaDao;

	public QnaInsertController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	public Object[] getDataBinders() {
		return new Object[] {"qna", dto2.Qna.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		Qna qna = (Qna)model.get("qna");
		int page = (Integer)model.get("page");
		qna.setId(login.getId());
		if(login == null) {
			return "redirect:login.do";
		}else if(qna.getSubject() == null) {
			
			model.put("page", page);
			return "/kidney/QnaInsert.jsp";
		}else {
			qnaDao.qnaInsert(qna);
			return "redirect:qnalist.do?page=" + page;
		}
		
	}

}
