package control;

import java.util.Map;

import dao2.InformationDao;
import dto2.Information;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/noticedetail.do")
public class NoticeDetailContoroller implements Controller, DataBinding {

	private InformationDao informationDao;

	public NoticeDetailContoroller setInformationDao(InformationDao informationDao) {
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
		

		Information information = informationDao.detail(iseq, kind);
		model.put("info", information);
		model.put("menu", "공지사항");
		model.put("page", page);
		
		
		return "/kidney/NoticeDetail.jsp";
	}

}
