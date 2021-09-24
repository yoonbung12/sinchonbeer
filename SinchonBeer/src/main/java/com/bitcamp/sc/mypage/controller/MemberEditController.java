package com.bitcamp.sc.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.sc.member.domain.Member;
import com.bitcamp.sc.mypage.service.MemberEditService;

@Controller
public class MemberEditController {
	@Autowired
	MemberEditService service;

	// 정보 수정 페이지 이동(회원 정보 조회)
	@GetMapping("/mypage/edit-info")
	public String editInfoGet(HttpSession session) {
		if (session.getAttribute("loginInfo") == null) {
			return "member/loginForm";
		}
		return "mypage/edit-info";
	}

	// 정보 수정 실행
	@PostMapping("/mypage/edit-info")
	public String editInfoPost(Member member) {
		service.updateMember(member);

		return "mypage/edit-info";
	}
}
