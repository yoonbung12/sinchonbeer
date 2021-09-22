package com.bitcamp.sc.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.sc.member.domain.LoginInfo;
import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.service.MemberManagerService;

@Controller
public class MemberManagerController {
	@Autowired
	MemberManagerService service;

	// 정보 수정 페이지 이동(회원 정보 조회)
	@GetMapping("/mypage/change-info")
	public String changeInfoGet(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginInfo login = (LoginInfo) session.getAttribute("loginInfo");

		List<Member> memberInfo = service.readMember(login.getIdx());

		model.addAttribute("memberInfoList", memberInfo);

		System.out.println("회원 정보 : " + memberInfo);
		System.out.println("회원 정보 : " + login);
		System.out.println("회원 정보 : " + login.getIdx());
		
		return "mypage/change-info";
	}

	// 정보 수정 실행
	@PostMapping("/mypage/change-info")
	public String changeInfoPost(Member member) {
		service.updateMember(member);

		return "mypage/change-info";
	}

	// 회원 탈퇴 페이지 이동
	@GetMapping("/mypage/delete-id")
	public String deleteId(HttpSession session) {
		if (session.getAttribute("loginInfo") == null) {
			return "main";
		}
		return "mypage/delete-id";
	}

	// 회원 탈퇴 실행
	@PostMapping("/mypage/delete-id")
	public String deleteId(Member member, HttpSession session) {
		service.deleteMember(member);

		// 세션 초기화
		session.invalidate();

		return "main";
	}
}
