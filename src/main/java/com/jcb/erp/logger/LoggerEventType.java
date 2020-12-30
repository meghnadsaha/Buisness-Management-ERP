package com.jcb.erp.logger;


import com.jcb.erp.dto.requests.EmployeeInventoryDetailsRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoggerEventType {
	FETCH_CONSENT_OTP_REQUEST, 
	FETCH_CONSENT_OTP_RESPONSE,
	FETCH_SCORE_WITH_OTP_REQUEST,
	FETCH_SCORE_WITH_OTP_RESPONSE,
	FETCH_CONSENT_SMS_REQUEST,
	FETCH_CONSENT_SMS_RESPONSE,
	VERIFY_OTP_REQUEST,
	VERIFY_OTP_RESPONSE,
	FETCH_SCORE_REQUEST,
	FETCH_SCORE_RESPONSE,
	RETRY_OTP_REQUEST,
	RETRY_OTP_RESPONSE,
	RETRY_CONSENT_SMS_REQUEST,
	RETRY_CONSENT_SMS_RESPONSE,
	CHECK_CUSTOMER_CONSENT_REQUEST,
	CHECK_CUSTOMER_CONSENT_RESPONSE,
	CHECK_MSISDN_EXISTANCE_REQUEST,
	CHECK_MSISDN_EXISTANCE_RESPONSE,
	FETCH_SCORE_WITH_EXTERNAL_CONSENT_REQUEST,
	FETCH_SCORE_WITH_EXTERNAL_CONSENT_RESPONSE,
	SEND_MESSAGE_REQUEST,
	SEND_MESSAGE_RESPONSE,
	DELIVERY_RECEIPT_REQUEST,
	DELIVERY_RECEIPT_RESPONSE,
	MO_REQUEST,
	MO_RESPONSE,
	MALFORMED_JSON,
	FORBIDDEN_PARAMS,
	MISSING_PARAMS,
	EXTERNAL_SERVICE_ERROR,
	INVAILD_MSISDN,
	THIRD_PARTY_API_CALLING_ERROR,
	EXCEPTION,
	CREATE_CLIENT,
	LOG_DB_REQUEST,
	LOG_DB_RESPONSE,
	LOG_AUTH_REQUEST,
	FETCH_ELIGIBILITY_WITH_EXTERNAL_CONSENT,
	SEND_SCORE_SMS_TO_USER, 
	SEND_RECHARGE_SMS_TO_USER,
	FETCH_SCORE_WITH_EXTERNAL_CONSENT,
	FETCH_RECHARGE_HISTORY,
	LOAN_STATUS_REQUEST,
	EMPLOYEE_INVENTORY_DETAILS_REQUEST;
}

