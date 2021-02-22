package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CustomerDao;
import dto2.Customer;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/mypage.do")
public class MypageController implements Controller, DataBinding {

	private CustomerDao customerDao;

	public MypageController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}

	public Object[] getDataBinders() { // id값 있음
		return new Object[] { "customer", dto2.Customer.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Customer customer = (Customer) model.get("customer");
		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		System.out.println(customer.getName());
		if (login == null) {
			return "redirect:login.do";
		} else {

			if (customer.getName() == null) { // name 값 없음
				Customer mypage = customerDao.select(customer);
				model.put("mypage", mypage);
				System.out.println(customer.getName());

				return "/kidney/Mypage.jsp";
			} else {
				String tel1 = customer.getTel1();
				String tel2 = customer.getTel2();
				String tel3 = customer.getTel3();

				customer.setTel(tel1 + "-" + tel2 + "-" + tel3);
				// customer.setName(null);
				customerDao.update(customer);

				return "redirect:index.do"; // 수정하고 싶음. 페이지 그대로

			}
		}
	}

}
