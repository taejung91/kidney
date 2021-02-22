package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminproductdetail.do")
public class AdminProductDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminProductDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "pseq", Integer.class, "product", dto2.Product.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Product tour = (Product)model.get("product");
		int page = (Integer)model.get("page");

		if (tour.getName() == null) {
			int pseq = (Integer) model.get("pseq");
			
			Product tourDetail = adminDao.detailProduct(pseq);
			
			model.put("tour", tourDetail);
			model.put("page", page);
			
			
			return "/kidney/AdminProductDetail.jsp";
	
		} else {
			adminDao.updateProduct(tour);
			return "redirect:adminproductlist.do?page="+page;

		}

	}

}