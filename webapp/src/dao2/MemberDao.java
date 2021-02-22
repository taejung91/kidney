package dao2;

import dto2.MemberVO;

public interface MemberDao {

  int insertMember(MemberVO memberVO) throws Exception;
  MemberVO checkId(String id) throws Exception;
}
