package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao2.AdminDao;
import dto2.Information;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/kidney/admininfo.do")
public class AdminInfoAddController implements Controller, DataBinding {

	private AdminDao adminDao;

	public AdminInfoAddController setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "info", dto2.Information.class, "page", Integer.class };
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String savePath = "product";                              // 여기를 바꿔주면 다운받는 경로가 바뀜 (폴더명)
		int uploadFileSizeLimit = 30 * 1024 * 1024;               // 최대 업로드 파일 크기 5MB로 제한
		String encType = "UTF-8";
		ServletContext context = request.getSession().getServletContext();
		String uploadFilePath = context.getRealPath(savePath);   // 서버상의 실제 디렉토리
		
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			// MultipartRequest를 사용해서 정보 가져와야함.           // 객체는 고정이기 때문에 핸들링 못함.
			Enumeration files = multi.getFileNames();
			while(files.hasMoreElements()) {
				String file = (String) files.nextElement();
				String file_name = multi.getFilesystemName(file);
				String ori_file_name = multi.getOriginalFileName(file);
				out.print("<br> 업로드된 파일명 : " + file_name);
				out.print("<br> 원본 파일명 : " + ori_file_name);
				out.print("<hr>" + uploadFilePath);
			}
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Information info = (Information) model.get("info");

		int page = (Integer) model.get("page");
		if (info.getTitle() == null) {
			model.put("page", page);
			return "/kidney/AdminInfo.jsp";
		} else {
			adminDao.addinfo(info);
			return "redirect:admininfolist.do?page=" + page;
		}

	}

}
