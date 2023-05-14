package com.olp.notification_mgmt.service;

import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.olp.notification_mgmt.entity.NotificationTemplateDetails;


@Component
public class MessageHandler {

	public NotificationTemplateDetails modifyEmailSubjectAndContentForSMSAndEmail(
			NotificationTemplateDetails notificationTemplateDetails, Map<String, String> tokenValues) {
		NotificationTemplateDetails tempNotificationTemplateDetails = new NotificationTemplateDetails();

		tempNotificationTemplateDetails.setEmailSubject(
				replacePlaceHoldersInMessages(notificationTemplateDetails.getEmailSubject(), tokenValues));
		tempNotificationTemplateDetails.setEmailContent(
				replacePlaceHoldersInMessages(notificationTemplateDetails.getEmailContent(), tokenValues));
		tempNotificationTemplateDetails
				.setSmsContent(replacePlaceHoldersInMessages(notificationTemplateDetails.getSmsContent(), tokenValues));
		tempNotificationTemplateDetails.setPriority(notificationTemplateDetails.getPriority());
		tempNotificationTemplateDetails.setMessageType(notificationTemplateDetails.getMessageType());
		tempNotificationTemplateDetails.setNotificationCategory(notificationTemplateDetails.getNotificationCategory());

		tempNotificationTemplateDetails.setIsEmailEnabled(notificationTemplateDetails.getIsEmailEnabled());
		tempNotificationTemplateDetails.setIsSmsEnabled(notificationTemplateDetails.getIsSmsEnabled());

		return tempNotificationTemplateDetails;
	}

	public String replacePlaceHoldersInMessages(String msgValue, Map<String, String> tokenValues) {
		if (tokenValues != null) {
			Iterator<String> itr = tokenValues.keySet().iterator();

			while (itr.hasNext()) {
				String key = itr.next();
				String value = tokenValues.get(key);
				msgValue = msgValue.replace(key, value);
			}
		}
		return msgValue;
	}

}
