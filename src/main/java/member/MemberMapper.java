package member;

import java.util.List;

import common.SearchVO;

public interface MemberMapper {
	int getMemberTotalCount(SearchVO vo);
	List<MemberVO> getMemberList(SearchVO vo);
	MemberVO getMember(String id);
	int insertMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(String id);
	MemberVO currentPassword(MemberVO vo);
	int changePassword(MemberVO vo);
}
