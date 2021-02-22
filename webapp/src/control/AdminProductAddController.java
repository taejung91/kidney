package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminpadd.do")
public class AdminProductAddController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminProductAddController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "product", dto2.Product.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Product tour = (Product)model.get("product");
		int page = (Integer)model.get("page");
		
		if (tour.getS_schedule() == null) {
			model.put("page", page);
			return "/kidney/AdminProduct.jsp";
		} else {
			adminDao.addProduct(tour);
			return "redirect:adminproductlist.do?page="+page;
		}

	}
}
