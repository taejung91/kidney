package control;

import java.util.Map;

import dao2.OrderDao;
import dao2.ProductDao;
import dto2.Order;
import dto2.Product;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/orderdelete.do")
public class OrderDeleteController implements Controller, DataBinding {

	private OrderDao orderDao;
	private ProductDao productDao;

	public OrderDeleteController setAdminDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	public OrderDeleteController setProductDao(ProductDao productDao) {
		this.productDao = productDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "oseq", Integer.class,  "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		int oseq = (Integer) model.get("oseq");
		int page = (Integer)model.get("page");
		// 오더 예약 수 가져오기
		Order order = orderDao.orderDetail(oseq);
		int quan1 = order.getQuantity1() + order.getQuantity2();
		// 상품 예약 수
		Product product = productDao.detail(order.getPseq());
		int quan2 = product.getQuantity();
		// 수 합
		int quantity = quan2 + quan1;
		productDao.updateQuantity(product.getPseq(), quantity);

		orderDao.orderDelete(oseq);

		return "redirect:orderpage.do?page=" + page;
	}
}
