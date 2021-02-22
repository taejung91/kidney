package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.ProductDao;
import dto2.Paging;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/tour.do")
public class TourController implements Controller, DataBinding {
	private ProductDao productDao;

	public TourController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "kind", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Integer kind = (Integer) model.get("kind");
		
		//페이징
   	    int page = (Integer)model.get("page");
		Paging paging = new Paging();
		//보여주는 글 수 
		paging.setDisplayRow(8);
		int cnt = paging.getDisplayRow();
		//DB 총 갯수
		int count = productDao.getAllCount(kind);
		//url 주소
	//	paging.setUrl("");
		
		paging.setTotalCount(count);
		paging.setPage(page);
	
		
		ArrayList<Product> productList = productDao.list(kind, page, cnt);
		
		model.put("productList", productList);
		model.put("paging", paging);
		model.put("kind", kind);
		model.put("page", page);
		
	
		
		return "/kidney/Tour.jsp";


	}

}
