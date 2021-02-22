package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.AdminDao;
import dto2.Customer;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admincustomerlist.do")
public class AdminCustomerListController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminCustomerListController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "page", Integer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// 페이징
		int page = (Integer) model.get("page");
		Paging paging = new Paging();
		// 보여주는 글 수
		paging.setDisplayRow(10);
		int cnt = paging.getDisplayRow();
		// DB 총 갯수
		int count = adminDao.getAllCount6();
		// url 주소
		// paging.setUrl("");

		paging.setTotalCount(count);
		paging.setPage(page);

		ArrayList<Customer> CustomerList = adminDao.listCustomer(page, cnt);
		model.put("CustomerList", CustomerList);
		model.put("paging", paging);
		model.put("page", page);
		
		

		return "/kidney/AdminCustomerList.jsp";

	}

}
