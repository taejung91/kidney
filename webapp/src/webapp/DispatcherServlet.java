package webapp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */

@SuppressWarnings("serial") // 노란줄 안보이게
@WebServlet("*.do") // url 암호화

public class DispatcherServlet extends HttpServlet {

	// 프론트 컨트롤러

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();

		try {

//			ServletContext sc = this.getServletContext();
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();   // 사용 시점
			
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", request.getSession());

//			Controller controller = (Controller) sc.getAttribute(servletPath);
			Controller controller = (Controller) ctx.getBean(servletPath);
			
			

			/*
			if ("/auth/add.do".equals(servletPath)) {
				if (request.getParameter("email") != null) {
					model.put("member", new Member3().setEmail(request.getParameter("email"))
						                         	 .setPassword(request.getParameter("password"))
							                         .setName(request.getParameter("name")));
				}
			}else if("/member/updateform.do".equals(servletPath)) {
				if(request.getParameter("no") != null) {
					model.put("member", new Member3().setNo(Integer.parseInt(request.getParameter("no"))));
				}
				
			}
			else if ("/member/update.do".equals(servletPath)) {
				if (request.getParameter("email") != null) {
					model.put("member", new Member3().setPassword(request.getParameter("pw"))
							                         .setEmail(request.getParameter("email"))
							                         .setName(request.getParameter("name")));
				} else {
					model.put("no", new Integer(request.getParameter("no")));
				}
			} else if ("/member/delete.do".equals(servletPath)) {
				model.put("no", new Integer(request.getParameter("no")));
				
			} else if ("/auth/login.do".equals(servletPath)) {
				if (request.getParameter("email") != null) {
					model.put("loginInfo", new Member3().setEmail(request.getParameter("email"))
							                            .setPassword(request.getParameter("password")));
				}
			}
*/
			if(controller instanceof DataBinding) {
				prepareRequestData(request, model, (DataBinding)controller);
			}
			
			
			String viewUrl = controller.execute(model);
			for (String key : model.keySet()) {                 // keySet : 모든 키값 저장
				request.setAttribute(key, model.get(key));
			}
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding) throws Exception{
		
		Object[] dataBinders = dataBinding.getDataBinders();             // 2. 데이터 호출
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for(int i = 0; i < dataBinders.length; i += 2) {
			dataName = (String) dataBinders[i]; 
			dataType = (Class<?>) dataBinders[i + 1]; 
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);         // 3. 데이터 가공 및 생성
			model.put(dataName, dataObj);                                                 // 5. 데이터 저장
			
		}
	}

}
