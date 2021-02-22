package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Food;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincaldetail.do")
public class AdminCalDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCalDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "fseq", Integer.class, "food", dto2.Food.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Food food = (Food) model.get("food");
		int page = (Integer)model.get("page");

		if (food.getFname() == null) {
			int fseq = (Integer) model.get("fseq");
			Food fooddetail = adminDao.detailFood(fseq);
			model.put("food", fooddetail);
			model.put("page", page);
			
			return "/kidney/AdminFoodDetail.jsp";
		} else {
			adminDao.updateFood(food);
			return "redirect:admincallist.do?page=" +page;

		}

	}

}
