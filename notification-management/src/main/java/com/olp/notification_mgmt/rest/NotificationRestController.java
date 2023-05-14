package com.olp.notification_mgmt.rest;

import java.util.Date;
import javax.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olp.notification_mgmt.common.CommonConstants;
import com.olp.notification_mgmt.common.MailUtil;
import com.olp.notification_mgmt.common.ResponseStatus;
import com.olp.notification_mgmt.dao.NotificationRepository;
import com.olp.notification_mgmt.entity.Notification;
import com.olp.notification_mgmt.entity.NotificationDetails;
import com.olp.notification_mgmt.entity.NotificationTemplateDetails;
import com.olp.notification_mgmt.service.NotificationServiceImpl;
import com.olp.notification_mgmt.to.NotificationRequest;

@RestController
@RequestMapping("/notification")
public class NotificationRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationRestController.class);

	@Autowired
	MailUtil mailUtil;

	@Autowired
	private NotificationServiceImpl notificationServiceImpl;

	@Autowired
	private NotificationRepository notificationRepository;
	
	@PostMapping("/signUpSuccsess")
	public ResponseStatus sendSignUpSuccsessNotification(@RequestBody NotificationRequest notificationRequest)
			throws MessagingException {
		LOGGER.info(CommonConstants.BEGIN);
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			
			String email = notificationRequest.getAppuser().getEmailId();
			String emailCCAddress = notificationRequest.getEmailCCAddress();
			String display_name = notificationRequest.getAppuser().getDisplayName();
			
			String subject = "Signup Success";
			String companyName = "Online Learning Platform";
			String supportEmail = "support@onlinelearningplatform.com";
			String websiteUrl="https://www.onlinelearningplatform.com";

			String message = "<html>" +
				    "<body>" +
				    "<h2>Signup Success - Welcome to Online Learning Platform!</h2>" +
				    "<p>Dear " + display_name + ",</p>" +
				    "<p>Congratulations on successfully signing up for "+ companyName+"! We're excited to have you as part of our learning community.</p>" +
				    "<p>To get started, here are a few instructions to help you make the most of your account:</p>" +
				    "<ol>" +
				    "<li>Log in to your account at <a href='" + websiteUrl + "'>" + websiteUrl + "</a> using your email and password.</li>" +
				    "<li>Browse our course catalog to find courses that interest you.</li>" +
				    "<li>Enroll in courses and start learning! Our courses feature videos, interactive quizzes, and hands-on exercises to help you master new skills.</li>" +
				    "<li>If you have any questions or need assistance, please don't hesitate to contact our support team at <a href='mailto:" + supportEmail + "'>" + supportEmail + "</a>.</li>" +
				    "</ol>" +
				    "<p>Thank you for choosing Online Learning Platform! We're committed to helping you achieve your learning goals and providing you with a top-notch educational experience.</p>" +
				    "<p>Best regards,<br>" +
				    "[Your Name]</p>" +
				    "</body>" +
				    "</html>";

			mailUtil.sendSSLMessageAttachment(email, emailCCAddress, subject, message);

		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		LOGGER.info(CommonConstants.END);
		return responseStatus;
	}

	@PostMapping("/loginSuccess")
	public ResponseStatus sendLoginSuccessNotification(@RequestBody NotificationRequest notificationRequest)
			throws MessagingException {
		LOGGER.info(CommonConstants.BEGIN);
		ResponseStatus responseStatus = new ResponseStatus();
		try {

			String email = notificationRequest.getAppuser().getEmailId();
			String emailCCAddress = notificationRequest.getEmailCCAddress();
			String display_name = notificationRequest.getAppuser().getDisplayName();
			
			String subject = "Sign-In Success";
			String companyName = "Online Learning Platform";
			String supportEmail = "support@onlinelearningplatform.com";

			String message = "<html>" + "<body>" + "<h2>Sign-In Success - Welcome back to " + companyName + "!</h2>"
					+ "<p>Dear " + display_name + ",</p>"
					+ "<p>We're happy to inform you that you've successfully signed in to your " + companyName
					+ " account. We're glad to have you back!</p>"
					+ "<p>If you need any assistance with your account, please feel free to contact our support team at <a href='mailto:"
					+ supportEmail + "'>" + supportEmail + "</a>.</p>" + "<p>Thank you for choosing " + companyName
					+ "! We look forward to providing you with the best possible experience.</p>"
					+ "<p>Best regards,<br>" 
					+ "Support Team</p>" 
					+ "</body>" 
					+ "</html>";

			mailUtil.sendSSLMessageAttachment(email, emailCCAddress, subject, message);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		LOGGER.info(CommonConstants.END);
		return responseStatus;
	}

	@PostMapping("/forgotPasswordLink")
	public ResponseStatus sendForgotPasswordLink(@RequestBody NotificationRequest notificationRequest) throws MessagingException {
		LOGGER.info(CommonConstants.BEGIN);
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			
			String email = notificationRequest.getAppuser().getEmailId();
			String emailCCAddress = notificationRequest.getEmailCCAddress();
			String display_name = notificationRequest.getAppuser().getDisplayName();
			String user_name =notificationRequest.getAppuser().getUserName();
			String reset_token =notificationRequest.getResetToken();
			String context_path =notificationRequest.getContextPath();
			Integer user_id = notificationRequest.getAppuser().getUserId();

			String subject="Password Reset Request";
			String companyName = "Online Learning Platform";
			String resetLink = context_path + "createnewPassword?username=" + user_name + "&token=" + reset_token;
			String supportEmail = "support@onlinelearningplatform.com";

			String message = "<html>" +
			    "<body>" +
			    "<h2>Password Reset Request - Reset Your " + companyName + " Password</h2>" +
			    "<p>Dear " + display_name + ",</p>" +
			    "<p>We received a request to reset your " + companyName + " account password. Please click on the link below to reset your password:</p>" +
			    "<p><a href='" + resetLink + "'>" + resetLink + "</a></p>" +
			    "<p>If you did not request a password reset, please ignore this email.</p>" +
			    "<p>If you need any assistance with your account, please feel free to contact our support team at <a href='mailto:" + supportEmail + "'>" + supportEmail + "</a>.</p>" +
			    "<p>Thank you for choosing " + companyName + "! We look forward to providing you with the best possible experience.</p>" +
			    "<p>Best regards,<br>" +
			    "Support Team</p>" +
			    "</body>" +
			    "</html>";

			String refKey = "APP_USER_ID";
			Integer userId = null;
			String refValue = "";
			if (null != user_id) {
				refValue = user_id.toString();
				userId = user_id;
			} else {
				refValue = user_name.toString();
				userId = 1;
			}
			
			NotificationTemplateDetails notificationTemplateDetails = notificationServiceImpl
					.getNotitifcationTemplateDetailsByTemplateCodeAndLanguageCode("APP_USER_PASSWORD", "ENGLISH");
			

			Notification notification = new Notification();
			notification.setRefKey(refKey);
			notification.setRefValue(refValue);
			notification.setSubject(subject);
			notification.setMessage("Password Reset Request For "+display_name +" "+resetLink);
			notification.setSmsMessage("Password Reset Request For "+display_name +" "+resetLink);
			if (notificationTemplateDetails != null) {
				notification.setPriority(notificationTemplateDetails.getPriority());
				notification.setMessageType(notificationTemplateDetails.getMessageType());
				notification.setNotificationCategory(notificationTemplateDetails.getNotificationCategory());
			}
			
			notification.setCreatedBy(userId);
			notification.setCreatedDate(new Date());

			notificationRepository.saveNotification(notification);
			NotificationDetails notificationDetails = new NotificationDetails();
			notificationDetails.setNotification(notification);
			notificationDetails.setMacAddress(email);
			if (notificationTemplateDetails != null) {
				notificationDetails.setSmsStatus((byte) notificationTemplateDetails.getIsSmsEnabled());
				notificationDetails.setEmailStatus((byte) notificationTemplateDetails.getIsEmailEnabled());
			}
		
			notificationDetails.setCreatedBy(userId);
			notificationDetails.setCreatedDate(new Date());
			notificationRepository.saveNotificationDetails(notificationDetails);

			mailUtil.sendSSLMessageAttachment(email, emailCCAddress, subject, message);

			responseStatus.setStatusCode(200);
			responseStatus.setStatusMessage("Forgot Password Link Succsess to "+email);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			responseStatus.setStatusCode(500);
			responseStatus.setStatusMessage("Forgot Password Link Fail...");
		}
		LOGGER.info(CommonConstants.END);
		return responseStatus;
	}
	
	@PostMapping("/resetPasswordSuccess")
	public ResponseStatus sendResetPasswordSuccessNotification(@RequestBody NotificationRequest notificationRequest)
			throws MessagingException {
		LOGGER.info(CommonConstants.BEGIN);
		ResponseStatus responseStatus = new ResponseStatus();
		try {

			String email = notificationRequest.getAppuser().getEmailId();
			String emailCCAddress = notificationRequest.getEmailCCAddress();
			String display_name = notificationRequest.getAppuser().getDisplayName();
			
			String subject = "Password Reset Success";
			String companyName = "Online Learning Platform";
			String supportEmail = "support@onlinelearningplatform.com";

			String message = "<html>" 
					+ "<body>" 
					+ "<h2>Password Reset Success - Your "+ companyName + " Password Has Been Reset</h2>" 
					+ "<p>Dear " + display_name + ",</p>"
					+ "<p>We're writing to confirm that your password for your " + companyName
					+ " account has been reset successfully.</p>"
					+ "<p>If you did not reset your password, please contact our support team at <a href='mailto:"
					+ supportEmail + "'>" + supportEmail + "</a> immediately.</p>"
					+ "<p>Thank you for choosing " + companyName
					+ "! We look forward to providing you with the best possible experience.</p>"
					+ "<p>Best regards,<br>" 
					+ "Suport Team</p>" + 
					"</body>" 
					+ "</html>";

			mailUtil.sendSSLMessageAttachment(email, emailCCAddress, subject, message);

			responseStatus.setStatusCode(200);
			responseStatus.setStatusMessage("Sign-In Success");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			responseStatus.setStatusCode(500);
			responseStatus.setStatusMessage("Sign-In fail...");
		}
		LOGGER.info(CommonConstants.END);
		return responseStatus;
	}

}
