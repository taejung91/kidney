package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Qna;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminqnadetail.do")
public class AdminQnaDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminQnaDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "qseq", Integer.class, "qna", dto2.Qna.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Qna qna = (Qna) model.get("qna");
		int page = (Integer) model.get("page");
		
		if (qna.getReply() == null) {
			int qseq = (Integer) model.get("qseq");
			Qna qnaDetail = adminDao.detailQna(qseq);
			model.put("qna", qnaDetail);
			model.put("page", page);
			return "/kidney/AdminQnaDetail.jsp";
		} else {
			adminDao.updateQna(qna);
			return "redirect:adminqnalist.do?page="+page;

		}

	}

}
