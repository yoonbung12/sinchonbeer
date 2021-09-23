package com.bitcamp.sc.tour.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MailService {
	
	private JavaMailSender mailSender;
	
	private SpringTemplateEngine templateEngine;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// 보내는 사람 이메일
	private static final String FROM_EMAIL ="watersun326@gmail.com";
	
	
//	
//	public void sendMail(String email,TourOrderInfo info)  {
//			logger.info("메일 서비스 진입");
//			MimeMessage message = mailSender.createMimeMessage();
//			// 파일 첨부 가능 
//			MimeMessageHelper helper;
//			try {
//				helper = new MimeMessageHelper(message, true);
//			 
//			// 메일 제목 
//			helper.setSubject("신촌맥주 양조장 투어 예약이 변경되었습니다.");
//			// 받는 사람
//			helper.setTo(email);
//			// 보내는 사람 
//			helper.setFrom(FROM_EMAIL);
//			// 내용 
//			Context context = new Context();
//			context.setVariable("name", info.getMname());
//			context.setVariable("phone",info.getMphone());
//			context.setVariable("people", info.getTpeople());
//			context.setVariable("newDate", info.getTdate());
//			// 예약 신청 일시 ?? -> orders table에서 odate 계속 변경??
//			// html 경로 가져오기
//			String html = templateEngine.process("tour/changeReservation/sendMailChangeDate", context);
//			
//			// 가져온 메시지 내용저장
//			helper.setText(html, true);
//			}catch (MessagingException e) {
//				
//				e.printStackTrace();
//			}
//		
//			// 메일 전송
//	        mailSender.send(message);
//	}
//	
	public String pickSubject(int num) {
		String result = "신촌맥주 양조장 투어 예약이";
		if(num == 1) {
			 result+="변경되었습니다.";
		}else if(num == 2) {
			result+="완료되었습니다.";
		}else if(num == 3) {
			 result+="취소되었습니다.";
		}
		return result;
	}

}
