package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.InformationDao;
import dao2.ProductDao;
import dto2.Information;
import dto2.Product;
import webapp.Component;
import webapp.Controller;

@Component("/kidney/index.do")
public class IndexController implements Controller{

	private InformationDao informationDao;
	private ProductDao productDao;

	public IndexController setInfomationDao(InformationDao informationDao) {
		this.informationDao = informationDao;
		return this;
	}
	
	public IndexController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}
/*
	@Override
	public Object[] getDataBinders() {
		return new Object[] { "kind", Integer.class };
	}
*/
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int kind = 1;
		int page = 1;
		int cnt = 4;

		ArrayList<Information> infoList = informationDao.list(kind, page, cnt);

		model.put("infoList", infoList);
		
		ArrayList<Product> productList = productDao.list(kind, page, cnt);
		model.put("productList", productList);

		return "/kidney/Index.jsp";
	}

}
