package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import webapp.Component;
import webapp.Controller;

@Component("/kidney/logout.do")
public class LogOutController implements Controller{
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();
		return "redirect:index.do";
	}

}
