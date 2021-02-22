package control;

import java.util.Map;

import dao2.CustomerDao;
import dto2.Customer;
import dto2.CustomerData;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/mypageadd.do")
public class MypageAddController implements Controller, DataBinding {
	private CustomerDao customerDao;
	public MypageAddController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {"customer", dto2.CustomerData.class, "check", dto2.Customer.class};
	}
	
	@Override
	public String execute(Map<String, Object>model) throws Exception{
		
		CustomerData customerData = (CustomerData)model.get("customer");
		
		if(customerData.getWeight() == 0) {
			
			Customer check = (Customer)model.get("check");
			CustomerData data = customerDao.selectData(check);
			model.put("data", data);
			return "/kidney/MypageAdd.jsp";
			
		}else {
				
				Double height = customerData.getHeight();
				Double weight = customerData.getWeight();
			
// 표준체중			
				customerData.setS_weight( Math.round((height-100)*0.9));
				Double S_weight = customerData.getS_weight();			
				//칼로리
				customerData.setKcal((int)(S_weight*30));
				//단백질
				customerData.setProtein((int)Math.round(S_weight*1.2));		
				//인
				if((Math.round(S_weight*17)) < 800) {
					
					customerData.setP(800);
				}else if((Math.round(S_weight*17)) > 1000) {
					customerData.setP(1000);
				}else {
					customerData.setP((int)Math.round(S_weight*17));
				}
				
				
				 
				 customerDao.updateData(customerData);
				
				return "redirect:index.do";
				
				
	//		}else {

				
			}
			
		
		
		
	}
}
