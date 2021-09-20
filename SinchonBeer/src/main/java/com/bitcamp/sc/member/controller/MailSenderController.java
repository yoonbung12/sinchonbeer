package com.bitcamp.sc.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.memberService.MailSenderService;

@Controller
public class MailSenderController {

	@Autowired
	private MailSenderService service;
	
	@RequestMapping(value="/inquiry/pw/auth", method = RequestMethod.POST)
	@ResponseBody
	
	//메일 보내는 controller
	public String mailSend(@RequestBody Map<String, Object> param) {
		
		System.out.println("test 메일 보내기");
		System.out.println(param);
		System.out.println(param.get("userEmail"));
		
		String result = "N";
		Boolean resultSaveCode = service.emailSender((String)param.get("userEmail"));
		if(resultSaveCode) {
			result="Y";
		}
		
		return result;
	}
}
