package webapp;

import java.util.Map;

public interface DataBinding {
	
	Object[] getDataBinders();       // 

	String execute(Map<String, Object> model) throws Exception;

}
