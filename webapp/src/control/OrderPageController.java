package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.OrderDao;
import dto2.Customer;
import dto2.Order;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/orderpage.do")
public class OrderPageController implements Controller, DataBinding {

	private OrderDao orderDao;

	public OrderPageController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
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
			int count = orderDao.getAllCount(login.getId());
		
			paging.setTotalCount(count);
			paging.setPage(page);

			ArrayList<Order> orderList = orderDao.orderListById(login.getId(), "%", page, cnt);
			
			model.put("orderList", orderList);
			model.put("paging", paging);
			model.put("page", page);
			

			return "/kidney/Orderpage2.jsp";
		}

	}

}
