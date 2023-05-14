package com.olp.notification_mgmt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olp.notification_mgmt.common.CommonConstants;
import com.olp.notification_mgmt.common.MailUtil;
import com.olp.notification_mgmt.dao.NotificationRepository;
import com.olp.notification_mgmt.entity.NotificationTemplateDetails;
import com.olp.notification_mgmt.exception.DAOException;
import com.olp.notification_mgmt.exception.ServiceException;

@Component
public class NotificationServiceImpl {

	private static final Logger lOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	MailUtil mailUtil;

	public NotificationTemplateDetails getNotitifcationTemplateDetailsByTemplateCodeAndLanguageCode(String templateCode,
			String languageCode) throws ServiceException {
		lOGGER.info(CommonConstants.BEGIN);
		NotificationTemplateDetails notificationTemplateDetails = null;
		try {
			notificationTemplateDetails = notificationRepository
					.getNotitifcationTemplateDetailsByTemplateCodeAndLanguageCode(templateCode, languageCode);
		} catch (DAOException ex) {
			lOGGER.error(ex.getMessage(), ex);
			throw new ServiceException(ex.getMessage(), ex);
		}
		lOGGER.info(CommonConstants.END);
		return notificationTemplateDetails;
	}
}
