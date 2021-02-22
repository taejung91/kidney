package control;

import java.util.Map;

import dao2.MemberDao;
import dto2.MemberVO;
import webapp.Component;
import webapp.Controller;
import webapp.DataBinding;

@Component("/test/createMember.do")
public class CreateController2 implements Controller, DataBinding {
	private MemberDao memberDao;
	
	public CreateController2 setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"member", dto2.MemberVO.class};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		MemberVO memberVO = (MemberVO) model.get("member");
	//	System.out.println(memberVO.getId());
	//	System.out.println(memberVO.getPw());
		if(memberVO.getId() == null) {
			return "/test/Create.jsp";
		}else {
			System.out.println(memberVO.getId());
			System.out.println(memberVO.getPw());
			memberDao.insertMember(memberVO);
			
			return "/test/Create.jsp";
	
		}
		}
		
	}
