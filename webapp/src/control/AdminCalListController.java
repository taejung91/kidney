package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.AdminDao;
import dto2.Food;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincallist.do")
public class AdminCalListController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCalListController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int page = (Integer) model.get("page");
		Paging paging = new Paging();
		paging.setDisplayRow(10);
		int cnt = paging.getDisplayRow();

		int count = adminDao.getAllCount2();
	//	paging.setUrl("admincallist.do");
		paging.setTotalCount(count);
		paging.setPage(page);

		ArrayList<Food> foodList = adminDao.listFood(page, cnt);
		model.put("foodList", foodList);
		model.put("paging", paging);
		model.put("page", page);

		return "/kidney/AdminFoodList.jsp";

	}

}
