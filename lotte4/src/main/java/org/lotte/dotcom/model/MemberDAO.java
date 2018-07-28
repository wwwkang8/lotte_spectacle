package org.lotte.dotcom.model;

import java.util.List;

import org.lotte.dotcom.vo.LogVO;
import org.lotte.dotcom.vo.MemberVO;

public interface MemberDAO {

	int checkId(String id);

	void registerMember(MemberVO memberVO);

	MemberVO findMemberById(String id);

	MemberVO memberLogin(MemberVO memberVO);

	void updateMember(MemberVO memberVO);

	void addLog(LogVO logVO);

	List<LogVO> getLogList(String memberId);



}
