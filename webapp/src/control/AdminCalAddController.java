package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Food;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincaladd.do")

public class AdminCalAddController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCalAddController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "food", dto2.Food.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Food food = (Food)model.get("food");
		
		int page = (Integer)model.get("page");

		if (food.getKind() == null) {
			model.put("page", page);
			return "/kidney/AdminFood.jsp";
		} else {
			adminDao.addFood(food);
			return "redirect:admincallist.do?page=" + page;
		}

	}
}
