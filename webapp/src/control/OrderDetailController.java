package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CartDao;
import dao2.CustomerDao;
import dao2.OrderDao;
import dao2.ProductDao;
import dto2.Customer;
import dto2.Order;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/orderdetail.do")
public class OrderDetailController implements Controller, DataBinding {

	private OrderDao orderDao;
	private CustomerDao customerDao;
	private ProductDao productDao;
	private CartDao cartDao;

	public OrderDetailController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	public OrderDetailController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	public OrderDetailController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}

	public OrderDetailController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "pseq", Integer.class, "customer", dto2.Customer.class, "quantity1", Integer.class,
				"quantity2", Integer.class, "odseq", Integer.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		Customer customer = (Customer) model.get("customer");
		int pseq = (Integer) model.get("pseq");
		int odseq = (Integer) model.get("odseq");
		int quantity1 = (Integer) model.get("quantity1");
		int quantity2 = (Integer) model.get("quantity2");
		int page = (Integer) model.get("page");
		
		if (login == null) {
			return "redirect:login.do";
		} else {

			customer = new Customer();
			customer.setId(login.getId());
			model.put("customer", customerDao.select(customer));
			model.put("product", productDao.detail(pseq));
			
			

			Order order = new Order();
			order = orderDao.list(odseq);
			model.put("order", order);

			int totalPrice = 0;
			totalPrice += (order.getPrice1() * order.getQuantity1()) + (order.getPrice2() * order.getQuantity2());

			model.put("totalPrice", totalPrice);
			model.put("page", page);
			

			return "/kidney/OrderDetail.jsp";

		}

	}

}
