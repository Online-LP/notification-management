package com.olp.notification_mgmt.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Component
public class MailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${twilio.accountSid}")
	private String accountSid;

	@Value("${twilio.authToken}")
	private String authToken;

	@Value("${twilio.phoneNumber}")
	private String phoneNumber;

	public void sendSSLMessageAttachment(String emailToAddress, String emailCCAddress, String subject, String htmlBody)
			throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(emailToAddress);
		helper.setSubject(subject);
		helper.setText(htmlBody, true);

		javaMailSender.send(message);
	}

	public void sendSMS(String toPhoneNumber, String messageBody) {
		Twilio.init(accountSid, authToken);
		Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(phoneNumber), messageBody).create();
	}
	public void sendWhatsapp(String toPhoneNumber, String messageBody) {
		Twilio.init(accountSid, authToken);
		 Message message = Message.creator(
			      new PhoneNumber("whatsapp:+91"+toPhoneNumber),
			      new PhoneNumber("whatsapp:+14155238886"),messageBody).create();
	}
	
//	public void createPhoneNumber() {
//		Twilio.init(accountSid, authToken);
//		 com.twilio.rest.messaging.v1.service.PhoneNumber phoneNumber = com.twilio.rest.messaging.v1.service.PhoneNumber.creator(
//	                "MG36b82f4293c98a5720d31a4243b3189e",
//	                "PNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
//	            .create();
//		 
//	}
}
