package com.bitcamp.sc.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.sc.member.memberService.PwResetService;



@Controller
public class PwResetController {

	@Autowired
	private PwResetService service;
	
	@RequestMapping(value="/inquiry/pw/reset")
	@ResponseBody
	public String resetPw(
			@RequestBody Map<String, Object> params
			) {
		System.out.println(params);
		System.out.println(params.get("userEmail"));
		System.out.println(params.get("userPw"));
		
		String resultStr = "N";
		Boolean result= service.updateNewPw((String)params.get("userEmail"), (String)params.get("userPw"));
		
		if(result) {
			resultStr="Y";
		}
		
		return resultStr;
	}
	
}
