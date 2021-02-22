package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CalculatorDao;
import dto2.Calculator;
import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cal.do")
public class CalculatorController  implements Controller, DataBinding{
	
	private CalculatorDao calculatorDao;
	
	public CalculatorController setCalculatorDao(CalculatorDao calculatorDao) {
		this.calculatorDao = calculatorDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"fseq", Integer.class, "loginInfo", dto2.Customer.class, "page", Integer.class, "page2", Integer.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		
		  int page = (Integer)model.get("page");
		  int page2 = (Integer)model.get("page2");
		
		//고객
		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
		//카트담기
		
		//CalculatorCart calCart = (CalculatorCart)model.get("calculatorCart");
	//	calculatorDao.insertCart(login.getId());
		
        //고객
		CustomerData customer_D = calculatorDao.selectData(login.getId());
		//푸드
		int fseq = (Integer)model.get("fseq");
		Food food_D = calculatorDao.selectFood(fseq);
		
		// c 데이터 / 음식 데이터 + 칼큘데이터 = >
		// 고객 데이터(전체)
		String id = customer_D.getId();
		double kcal1 = customer_D.getKcal();
		double na1 = customer_D.getNa();
		double protein1 = customer_D.getProtein();
		double k1 = customer_D.getK();
		double p1 = customer_D.getP();
		double ca1 = customer_D.getCa();

		
		// 음식 데이터(일부)
		double kcal2 = food_D.getKcal();
		double na2 = food_D.getNa();
		double protein2 = food_D.getProtein();
		double k2 = food_D.getK();
		double p2 = food_D.getP();
		double ca2 = food_D.getCa();
		
		// 계산 값
		//   +
		// 계산기 값
		Calculator calculator = calculatorDao.selectCal(login.getId());
		
		Calculator cal = new Calculator();
		
		cal.setId(id);
		cal.setKcal ((int)Math.round((kcal2 * 100) / kcal1) + calculator.getKcal());
		cal.setNa((int)Math.round((na2 * 100) / na1) + calculator.getNa());
		cal.setProtein((int)Math.round((protein2 * 100) / protein1) + calculator.getProtein());
		cal.setK((int)Math.round((k2 * 100) / k1) + calculator.getK());
		cal.setP((int)Math.round((p2 * 100) / p1) + calculator.getP());
		cal.setCa((int)Math.round((ca2 * 100) / ca1) + calculator.getCa());
		
		
		
		
		// 계산기 DB에 업데이트
		calculatorDao.updateCal(cal);
		
		// 계산기카트 담기
		
    	calculatorDao.insertCart(food_D, login);
   
    
		
		return "redirect:cal_form.do?page="+page+"&page2="+page2;
		
	}

}
