package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CalculatorDao;
import dto2.Calculator;
import dto2.CalculatorCart;
import dto2.Customer;
import dto2.CustomerData;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cal_delete.do")
public class CalculatorDeleteController implements Controller, DataBinding {

	private CalculatorDao calculatorDao;

	public CalculatorDeleteController setCalculatorDao(CalculatorDao calculatorDao) {
		this.calculatorDao = calculatorDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "cseq", Integer.class, "loginInfo", dto2.Customer.class, "page", Integer.class, "page2", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");

		CustomerData customer_D = calculatorDao.selectData(login.getId());

		int cseq = (Integer) model.get("cseq");
		int page = (Integer) model.get("page");
		int page2 = (Integer) model.get("page2");
		
		
		
		CalculatorCart calCart = calculatorDao.selectCart(cseq);

		// 고객데이터
		String id = customer_D.getId();
		double kcal1 = customer_D.getKcal();
		double na1 = customer_D.getNa();
		double protein1 = customer_D.getProtein();
		double k1 = customer_D.getK();
		double p1 = customer_D.getP();
		double ca1 = customer_D.getCa();

		// 음식데이터
		double kcal2 = calCart.getKcal();
		double na2 = calCart.getNa();
		double protein2 = calCart.getProtein();
		double k2 = calCart.getK();
		double p2 = calCart.getP();
		double ca2 = calCart.getCa();

		// 계산 값
		// +
		// 계산기 값
		Calculator calculator = calculatorDao.selectCal(login.getId());

		Calculator cal = new Calculator();

		cal.setId(id);
		cal.setKcal(calculator.getKcal() - (int) Math.round((kcal2 * 100) / kcal1));
		cal.setNa(calculator.getNa() - (int) Math.round((na2 * 100) / na1));
		cal.setProtein(calculator.getProtein() - (int) Math.round((protein2 * 100) / protein1));
		cal.setK(calculator.getK() - (int) Math.round((k2 * 100) / k1));
		cal.setP(calculator.getP() - (int) Math.round((p2 * 100) / p1));
		cal.setCa(calculator.getCa() - (int) Math.round((ca2 * 100) / ca1));

		// 계산기 DB에 업데이트
		calculatorDao.updateCal(cal);

        // 계산기카트 삭제

		calculatorDao.deleteCart(cseq);
		
		return "redirect:cal_form.do?page=" + page + "&page2=" + page2;

	}

}
