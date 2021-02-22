package control;

import java.util.Map;

import dao2.AdminDao;
import dto2.Order;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminorderdetail.do")
public class AdminOrderDetailController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminOrderDetailController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "oseq", Integer.class, "order", dto2.Order.class, "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Order order = (Order) model.get("order");
		int page = (Integer)model.get("page");
		if (order.getResult() == null) {
			int oseq = (Integer) model.get("oseq");
			Order orderDetail = adminDao.orderDetail(oseq);
			model.put("order", orderDetail);
			model.put("page", page);
			
			return "/kidney/AdminOrderDetail.jsp";
		} else {

			adminDao.updateOrder(order);
			return "redirect:adminorderlist.do?page="+page;
		}

	}
}
