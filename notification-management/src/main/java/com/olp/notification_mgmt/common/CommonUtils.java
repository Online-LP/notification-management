package com.olp.notification_mgmt.common;

import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class CommonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

//	public static User getWebUser() {
//		LOGGER.info(CommonConstants.BEGIN);
//		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		LOGGER.info(CommonConstants.END);
//		return userDetails;
//	}

	public static boolean isNull(Object object) {
		boolean nullFlag = false;
		if (object == null) {
			nullFlag = true;
		} else if (object instanceof String && object.equals("")) {
			nullFlag = true;
		}
		return nullFlag;
	}

	public static void logIncomingJsonData(Object incomingData) {
		try {
			if (null != incomingData) {
				ObjectWriter ow = new ObjectMapper().writer();
				String json = ow.writeValueAsString(incomingData);
				boolean contains = json.contains("data:image");
				if (!contains) {
					LOGGER.info("::HEADERS JSON::" + json);
				} else {
					LOGGER.info("::HEADERS JSON::" + "::json contains base64 image data::");
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public static boolean isVaildMobileNumber(String number) {
		LOGGER.info(CommonConstants.BEGIN);
		boolean result = false;
		try {
			String regex = "\\d{10}";
			result = Pattern.compile(regex).matcher(number).matches();
			LOGGER.info("::Mobile Number is::" + number + " ::Result::" + result);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.info(CommonConstants.END);
		return result;
	}

	public static String generateUniqueIdentifierNumber() {
		UUID uniqueId = UUID.randomUUID();
		return uniqueId.toString();
	}
}
