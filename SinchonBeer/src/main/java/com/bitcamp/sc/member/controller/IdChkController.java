package com.bitcamp.sc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.memberService.IdChkService;

@Controller
public class IdChkController {

	@Autowired
	private IdChkService chkService;
	
	@RequestMapping(value="/emailCheck", method=RequestMethod.POST)
	@ResponseBody
	public String idcheck(
			@RequestBody String email
			) {
		email = email.replace("%40", "@");
		System.out.println(email);
		String result = chkService.emailCheck(email);
		System.out.println(result);
		return result; 
	}
}
