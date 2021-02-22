package control;

import java.util.Map;

import dao2.MemberDao;
import dto2.MemberVO;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/test/checkid_test.do")
public class CheckIdController2 implements Controller, DataBinding {
	
	private MemberDao memberDao;
	public CheckIdController2 setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"member", dto2.MemberVO.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		MemberVO memberVO = (MemberVO)model.get("member");
		System.out.println(memberVO.getId());
		
		MemberVO memberCheck = memberDao.checkId(memberVO.getId());
		
		model.put("check", memberCheck);
		return "/test/CheckId.jsp";
	}
	

}
