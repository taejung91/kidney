package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CartDao;
import dao2.CustomerDao;
import dao2.OrderDao;
import dao2.ProductDao;
import dto2.Cart;
import dto2.Customer;
import dto2.Order;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/orderinsert.do")
public class OrderController implements Controller, DataBinding {

	private OrderDao orderDao;
	private CustomerDao customerDao;
	private ProductDao productDao;
	private CartDao cartDao;

	public OrderController setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
		return this;
	}

	public OrderController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	public OrderController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}

	public OrderController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "pseq", Integer.class, "customer", dto2.Customer.class, "quantity1", Integer.class,
				"quantity2", Integer.class, "cseq", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		Customer customer = (Customer) model.get("customer");
		int pseq = (Integer) model.get("pseq");
		int cseq = (Integer) model.get("cseq");

		int quantity1 = (Integer) model.get("quantity1");
		int quantity2 = (Integer) model.get("quantity2");

		if (login == null) {
			return "redirect:login.do";
		} else if (customer.getId() == null) {

			customer = new Customer();
			customer.setId(login.getId());
			model.put("customer", customerDao.select(customer));

			model.put("product", productDao.detail(pseq));

			Cart cart = new Cart();
			cart = cartDao.cartList(cseq);
			model.put("cart", cart);

			int totalPrice = 0;
			totalPrice += (cart.getPrice1() * cart.getQuantity1()) + (cart.getPrice2() * cart.getQuantity2());

			model.put("totalPrice", totalPrice);

			return "/kidney/Orderpage.jsp";

		} else {

			Order order = orderDao.orderInsert(login.getId(), pseq, quantity1, quantity2, cseq);
			//예약수 가져오기
			Order o_quan = orderDao.list(order.getOdseq());
			//오더 예약수
			//제품 예약수
			Product quan = productDao.detail(pseq);
			int quantity = quan.getQuantity() - (o_quan.getQuantity1() + o_quan.getQuantity2());
			productDao.updateQuantity(pseq, quantity);

			return "redirect:orderpage.do?page=1";

		}

	}

}
