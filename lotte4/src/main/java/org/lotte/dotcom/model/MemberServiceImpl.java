package org.lotte.dotcom.model;

import java.util.List;

import javax.annotation.Resource;

import org.lotte.dotcom.vo.LogVO;
import org.lotte.dotcom.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Resource
	MemberDAO dao;
	@Autowired // Resource와 대비하여 Spring Framework에 종속적이지만 정밀한 DI가 가능함
	BCryptPasswordEncoder passwordEncoder; // Bcrypt : 비밀번호 패스워드에 특화됨

	@Override
	public int checkId(String id) {
		return dao.checkId(id);
	}

	@Override
	public void registerMember(MemberVO memberVO) {
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));//회원가입에 앞서 사용자가 입려한 비밀번호를 암호화시킨다.
		dao.registerMember(memberVO);
	}

	@Override
	public MemberVO findMemberById(String id) {
		return dao.findMemberById(id);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) {
		MemberVO dbMemberVO=dao.memberLogin(memberVO);
		MemberVO resultMemberVO=null;
		if(dbMemberVO!=null){
			String dbMemberVOPassword=dbMemberVO.getPassword();
			String inputMemberVOPassword=memberVO.getPassword();
			System.out.println("dbMemberVOPassword "+dbMemberVOPassword);
			System.out.println("inputMemberVOPassword"+inputMemberVOPassword);
			if(passwordEncoder.matches(inputMemberVOPassword, dbMemberVOPassword)){
				resultMemberVO=dbMemberVO;
			}
		}
		return resultMemberVO;
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		dao.updateMember(memberVO);
	}

	@Override
	public void addLog(LogVO logVO) {
		System.out.println("MemberServiceImple : "+logVO.toString());
		dao.addLog(logVO);
	}

	@Override
	public List<LogVO> getLogList(String memberId) {
		return dao.getLogList(memberId);
	}

	
	
}
