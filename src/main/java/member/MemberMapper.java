package member;

import java.util.List;

public interface MemberMapper {
	int getMemberTotalCount(List<MemberVO> list);
	List<MemberVO> getMemberList();
	MemberVO getMember(String id);
	int insertMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(String id);
	MemberVO currentPassword(MemberVO vo);
	int changePassword(MemberVO vo);
}
