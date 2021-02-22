package control;

import java.util.Map;

import dao2.ProductDao;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/tourdetail.do")
public class TourDetailController implements Controller, DataBinding {

	private ProductDao productDao;

	public TourDetailController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "pseq", Integer.class, "page", Integer.class, "kind", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Integer pseq = (Integer) model.get("pseq");
		Integer kind = (Integer) model.get("kind");
		Integer page = (Integer) model.get("page");

		Product product = productDao.detail(pseq);
		

		int price1 = product.getPrice1();

		model.put("tour", product);
		model.put("total", price1);
		model.put("page", page);
		model.put("kind", kind);
		if(kind == 1) {
			model.put("name", "국내 투어");
		} else if (kind == 2) {
			model.put("name", "해외 투어");
		}
		return "/kidney/TourDetail.jsp";


	}
}
