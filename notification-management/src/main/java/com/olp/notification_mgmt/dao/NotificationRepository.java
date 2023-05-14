package com.olp.notification_mgmt.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olp.notification_mgmt.common.CommonConstants;
import com.olp.notification_mgmt.entity.Notification;
import com.olp.notification_mgmt.entity.NotificationDetails;
import com.olp.notification_mgmt.entity.NotificationTemplateDetails;
import com.olp.notification_mgmt.exception.DAOException;

@SuppressWarnings("deprecation")
@Repository
@Transactional
public class NotificationRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationRepository.class);

	@Autowired
	private EntityManager entityManager;

	public NotificationTemplateDetails getNotitifcationTemplateDetailsByTemplateCodeAndLanguageCode(String templateCode,
			String languageCode) throws DAOException {
		LOGGER.info(CommonConstants.BEGIN);
		NotificationTemplateDetails notificationTemplateDetails = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			String strQuery = "from NotificationTemplateDetails where notificationTemplateMaster.code=:templateCode AND language.code=:langCode AND ( isEmailEnabled=1 or isSmsEnabled=1)";
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(strQuery);
			query.setParameter("templateCode", templateCode);
			query.setParameter("langCode", languageCode);
			notificationTemplateDetails = (NotificationTemplateDetails) query.uniqueResult();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(CommonConstants.END);
		return notificationTemplateDetails;
	}

	public void saveNotification(Notification notification) throws DAOException, HibernateException {
		LOGGER.info(CommonConstants.BEGIN);
		try {
			Session session = entityManager.unwrap(Session.class);
			session.save(notification);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(CommonConstants.END);
	}

	public void saveNotificationDetails(NotificationDetails notificationDetails)
			throws DAOException, HibernateException {
		LOGGER.info(CommonConstants.BEGIN);
		try {
			Session session = entityManager.unwrap(Session.class);
			session.save(notificationDetails);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(CommonConstants.END);
	}
}
