package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CartDao;
import dto2.Cart;
import dto2.Customer;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cartlist.do")
public class CartListController implements Controller, DataBinding {

	private CartDao cartDao;

	public CartListController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"page", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		
		if (login == null) {

			return "redirect:login.do";
		} else {
			
			//페이징
	   	    int page = (Integer)model.get("page");
			Paging paging = new Paging();
			//보여주는 글 수 
			paging.setDisplayRow(5);
			int cnt = paging.getDisplayRow();
			//DB 총 갯수
			int count = cartDao.getAllCount(login.getId());
		
			paging.setTotalCount(count);
			paging.setPage(page);
			
			ArrayList<Cart> cartList = cartDao.cartList(login.getId(), page, cnt);
	/*		
			int totalPrice = 0;
			for (Cart cart : cartList) {
				totalPrice = (cart.getPrice1() * cart.getQuantity1()) + (cart.getPrice2() * cart.getQuantity2()) ;
			}
		*/	
			
			model.put("cartList", cartList);
	//		model.put("totalPrice", totalPrice);
			model.put("paging", paging);
			model.put("page", page);
			
			
			return "/kidney/Cart.jsp";
			

			
		}

}

}