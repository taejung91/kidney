package control;

import java.util.ArrayList;
import java.util.Map;

import dao2.CustomerDao;
import dto2.Address;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/adminaddress.do")
public class AdminAddressController implements Controller, DataBinding{
	
	private CustomerDao customerDao;
	public AdminAddressController setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"address", dto2.Address.class};
	}
	
	@Override
	public String execute(Map<String, Object> model)throws Exception{
		
		Address address = (Address)model.get("address");
		
		
		if(address.getDong() == null) {
			
			return "/kidney/AdminAddress.jsp";
		}else {
			ArrayList<Address> addressList = new ArrayList<Address>();
			
			addressList = customerDao.address(address.getDong());
			model.put("addressList", addressList);
			return "/kidney/AdminAddress.jsp";
		}
		
	}

}
