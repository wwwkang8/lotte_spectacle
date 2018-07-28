package org.lotte.dotcom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lotte.dotcom.model.MemberService;
import org.lotte.dotcom.vo.LogVO;
import org.lotte.dotcom.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Resource
	MemberService service;
	
	
	@RequestMapping("/registerPage.do")
	public String registerPage(){
		return "register";
	}
	
	@RequestMapping(value="/registerMember.do", method= RequestMethod.POST)
	public String register(MemberVO memberVO){
		System.out.println("Member Controller"+memberVO.toString());
		service.registerMember(memberVO);
		return "redirect:registerResult.do?id="+memberVO.getMemberId();
	}
	
	@RequestMapping(value="/registerResult.do")
	public ModelAndView registerResult(String id){
		MemberVO memberVO=service.findMemberById(id);
		ModelAndView mv=new ModelAndView("registerResult","memberVO",memberVO);
		return mv;
	}
	
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	@ResponseBody
	public String checkId(String id){
		System.out.println("MemberController Id "+id);
		int count = service.checkId(id);
		return (count == 0) ? "0" : "1";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request,MemberVO memberVO){
		MemberVO mvo=service.memberLogin(memberVO);
		
		if(mvo==null){
			return "/loginFail";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("memberVO", mvo);
			/*Date date=new Date();
			SimpleDateFormat formatType=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");*/
			LogVO logVO=new LogVO(mvo.getMemberId(),mvo.getName(),mvo.getPhoneNumber());
			System.out.println("MemberController : "+logVO.toString());
			service.addLog(logVO);
			System.out.println("session");
			System.out.println(session.toString());
			return "redirect:index.do";
		}
	}
	
	
	@RequestMapping(value="/logout.do")
	public ModelAndView logout(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("mypage.do")
	public String mypage(HttpServletRequest request){
		return "mypage";
	}
	
	@RequestMapping(value="/updateMember.do", method=RequestMethod.POST)
	public String updateMember(HttpServletRequest request,MemberVO memberVO){
		service.updateMember(memberVO);
		HttpSession session=request.getSession();
		session.setAttribute("memberVO", memberVO);
		return "redirect:index.do";
	}
	
	@RequestMapping(value="/logHistory.do")
	public ModelAndView logHistory(HttpServletRequest request, String memberId){
		List<LogVO> logList=service.getLogList(memberId);
		ModelAndView mv=new ModelAndView("logHistory","logList",logList);
		return mv;
		
	}
	
	@RequestMapping("/sessionInvalidate.do")
	public String sessionInvalidate(){
		return "sessionInvalidate";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
