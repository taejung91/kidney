package control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao2.CalculatorDao;
import dto2.Calculator;
import dto2.CalculatorCart;
import dto2.Customer;
import dto2.CustomerData;
import dto2.Food;
import dto2.Paging;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/cal_form2.do")
public class CalculatorForm2Controller implements Controller, DataBinding {

	private CalculatorDao calculatorDao;

	public CalculatorForm2Controller setCalculatorDao(CalculatorDao calculatorDao) {
		this.calculatorDao = calculatorDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"search", String.class, "page", Integer.class,  "page2", Integer.class};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

	//	 Customer login = (Customer)model.get("loginInfo");
		HttpSession session = (HttpSession) model.get("session");
		Customer login = (Customer) session.getAttribute("loginInfo");
	//	Customer login = (Customer)model.get("loginInfo");
		

		// System.out.println();

		if (login == null) {
			return "redirect:login.do";
		} else {

			String search = (String) model.get("search");

			
			/*	Integer kind = (Integer) model.get("kind");
				
				//페이징
		   	    int page = (Integer)model.get("page");
				Paging paging = new Paging();
				//보여주는 글 수 
				paging.setDisplayRow(4);
				int cnt = paging.getDisplayRow();
				//DB 총 갯수
				int count = calculatorDao.getAllCount(kind);
		
				paging.setTotalCount(count);
				paging.setPage(page);
			
				
				
				// 음식 
				ArrayList<Food> foodList = calculatorDao.list(kind, page, cnt);
				model.put("size", foodList.size());
				model.put("foodList", foodList);
				model.put("paging", paging);
				model.put("kind", kind);
				// 내정보
				CustomerData customerData = calculatorDao.selectData(login.getId());
				model.put("c_data", customerData);
				// 선택 음식
				ArrayList<CalculatorCart> calCarts = calculatorDao.selectCart(login.getId());
				model.put("foodSelect", calCarts);
				// 계산기 섭취량
				Calculator calculator = calculatorDao.selectCal(login.getId());
				model.put("cal_data", calculator);
				
				return "/kidney/Calculator.jsp";
*/
		
//				Integer kind = (Integer) model.get("kind");
				//페이징
		   	    int page = (Integer)model.get("page");
				Paging paging = new Paging();
				//보여주는 글 수 
				paging.setDisplayRow(4);
				int cnt = paging.getDisplayRow();
				//DB 총 갯수
				int count = calculatorDao.getAllCount(search);
		
				paging.setTotalCount(count);
				paging.setPage(page);
				

				ArrayList<Food> foodList = calculatorDao.list(search, page, cnt);
				model.put("size", count);
				model.put("foodList", foodList);
				model.put("paging", paging);
				model.put("search", search);
				model.put("page", page);
				
				CustomerData customerData = calculatorDao.selectData(login.getId());
				model.put("c_data", customerData);
				
				//계산기 카트
				  int page2 = (Integer)model.get("page2");
				Paging paging2 = new Paging();
				paging2.setDisplayRow(4);
				int cnt2 = paging.getDisplayRow();
				//DB 총 갯수
				int count2 = calculatorDao.getAllCount2(login.getId());
				//url 주소
			//	paging.setUrl("");
				
				paging2.setTotalCount(count2);
				paging2.setPage(page2);
				
				ArrayList<CalculatorCart> calCarts = calculatorDao.selectCart(login.getId(), page2, cnt2);
				model.put("foodSelect", calCarts);
				model.put("paging2", paging2);
				model.put("page2", page2);
				
				
				
				
				Calculator calculator = calculatorDao.selectCal(login.getId());
				model.put("cal_data", calculator);
				
				return "/kidney/Calculator.jsp";
			}

		}
	}

