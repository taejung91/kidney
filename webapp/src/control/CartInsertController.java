package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CartDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cartinsert.do")
public class CartInsertController implements Controller, DataBinding {

	private CartDao cartDao;

	public CartInsertController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"pseq", Integer.class, "cart", Integer.class, "quantity1", Integer.class, "quantity2", Integer.class,
				 "page", Integer.class, "kind", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		int page = (Integer)model.get("page");
		int kind = (Integer)model.get("kind");
		
		if (login == null) {

			return "redirect:login.do";
		} else {
			int cart = (Integer)model.get("cart");
			int pseq = (Integer)model.get("pseq");
			int quantity1 =(Integer)model.get("quantity1");
			int quantity2 =(Integer)model.get("quantity2");
			
         	cartDao.cartInsert(login.getId(), pseq, quantity1, quantity2 );
         	int cseq = cartDao.select(login.getId(), pseq);

         	
			if(cart == 1) {
			return "redirect:cartlist.do?page=" + page;
			
		}else if(cart == 0) {
			return "redirect:tourdetail.do?pseq=" + pseq + "&page=" + page + "&kind=" + kind ;
		}
		else {
         	
	
			return "redirect:orderinsert.do?cseq=" + cseq + "&pseq=" + pseq + "&quantity1=" + quantity1 + "&quantity2=" + quantity2;
		}
		
	}
}
}
