package control;

import java.util.Map;

import dao2.CartDao;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cartdelete.do")
public class CartDeleteController implements Controller, DataBinding {

	private CartDao cartDao;

	public CartDeleteController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"cseq", Integer.class, "page", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int cseq = (Integer)model.get("cseq");
		int page = (Integer)model.get("page");
		
		cartDao.delete(cseq);
		
		return "redirect:cartlist.do?page=" + page;
	}

}
