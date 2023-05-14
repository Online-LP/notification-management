package com.olp.notification_mgmt.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSSLMessageAttachment(String emailToAddress, String emailCCAddress, String subject, String htmlBody)
			throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(emailToAddress);
		helper.setSubject(subject);
		helper.setText(htmlBody, true);

		javaMailSender.send(message);
	}
}
