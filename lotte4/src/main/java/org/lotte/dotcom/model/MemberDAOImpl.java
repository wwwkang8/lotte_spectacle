package org.lotte.dotcom.model;

import java.util.List;

import javax.annotation.Resource;

import org.lotte.dotcom.vo.LogVO;
import org.lotte.dotcom.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Resource
	SqlSessionTemplate template;

	@Override
	public int checkId(String id) {
		System.out.println("memebrDAO checkid"+id);
		return template.selectOne("member.checkId",id);
	}

	@Override
	public void registerMember(MemberVO memberVO) {
		System.out.println("MemberDAO"+memberVO.toString());
		template.insert("member.registerMember", memberVO);
		
	}

	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) {
		return template.selectOne("member.memberLogin", memberVO);
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		template.update("member.updateMember", memberVO);
		
	}

	@Override
	public void addLog(LogVO logVO) {
		System.out.println("MemberDAOImple : "+logVO.toString());
		template.insert("member.addLog",logVO);
	}

	@Override
	public List<LogVO> getLogList(String memberId) {
		return template.selectList("member.getLogList",memberId);
	}

	
	
	
}
