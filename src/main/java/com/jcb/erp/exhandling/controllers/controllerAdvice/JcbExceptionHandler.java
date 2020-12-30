package com.jcb.erp.exhandling.controllers.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.jcb.erp.controller.AuthController;
import com.jcb.erp.controller.EmployeeInventoryController;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.exhandling.exceptions.BadRequestException;
import com.jcb.erp.exhandling.exceptions.ForbiddenParamsException;
import com.jcb.erp.exhandling.exceptions.InternalErrorResponse;
import com.jcb.erp.exhandling.exceptions.JcbException;
import com.jcb.erp.exhandling.exceptions.MissingParamException;
import com.jcb.erp.exhandling.exceptions.ServerErrorException;
import com.jcb.erp.model.Data;
import com.jcb.erp.utils.DateUtility;
import com.jcb.erp.utils.JcbErrors;
import com.jcb.erp.logger.JcbLogger;
import com.jcb.erp.logger.LoggerEventType;

@RestController
@ControllerAdvice(assignableTypes = { AuthController.class, EmployeeInventoryController.class })
public class JcbExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(JcbExceptionHandler.class);

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ResponseEntity<InternalErrorResponse> handleGenericException(Exception e) throws Exception {
		log.error("Exception: [{}]", e.getMessage(), e);
		InternalErrorResponse internalErrorResponse = new InternalErrorResponse();
		internalErrorResponse.setTime(DateUtility.getCurrentDateInYYYYMMDDHHMMSSZ());

		if (e instanceof JcbException) {
			JcbException ex = (JcbException) e;
			internalErrorResponse.setData(new Data());
			internalErrorResponse.setVerdict(ex.getError().getCode());
			internalErrorResponse.setMessage(ex.getError().getMessage());
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (e instanceof DataAccessResourceFailureException) {
			JcbException ex = new JcbException(JcbErrors.DB_CONNECTION_ISSUE);
			internalErrorResponse.setData(new Data());
			internalErrorResponse.setVerdict(ex.getError().getCode());
			internalErrorResponse.setMessage(ex.getError().getMessage());
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (e instanceof HttpMessageNotReadableException) {
			JcbException ex = new JcbException(JcbErrors.MALFORMED_JSON);
			internalErrorResponse.setData(new Data());
			internalErrorResponse.setVerdict(ex.getError().getCode());
			internalErrorResponse.setMessage(ex.getError().getMessage());
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.BAD_REQUEST);
		}

		if (e instanceof ForbiddenParamsException) {
			internalErrorResponse.setMessage(((ForbiddenParamsException) e).getErrors().getMessage());
			internalErrorResponse.setVerdict(((ForbiddenParamsException) e).getErrors().getCode());
			Data data = new Data();
			data.setForbidden_parameters(((ForbiddenParamsException) e).getExtraFields());
			internalErrorResponse.setData(data);
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.BAD_REQUEST);
		}

		if (e instanceof MissingParamException) {
			internalErrorResponse.setMessage(((MissingParamException) e).getJcbErrors().getMessage());
			internalErrorResponse.setVerdict(((MissingParamException) e).getJcbErrors().getCode());
			Data data = new Data();
			data.setMissing_parameters(((MissingParamException) e).getMissingParams());
			internalErrorResponse.setData(data);
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.BAD_REQUEST);
		}

		if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
			BindingResult result = ex.getBindingResult();
			internalErrorResponse.setMessage(JcbErrors.INVALID_PARAMS.getMessage());
			internalErrorResponse.setVerdict(JcbErrors.INVALID_PARAMS.getCode());
			List<String> fieldErrors = new ArrayList<String>();
			for (FieldError fieldError : result.getFieldErrors()) {
				fieldErrors.add(fieldError.getDefaultMessage());
			}
			Data data = Data.builder().field_errors(fieldErrors).build();
			internalErrorResponse.setData(data);
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.BAD_REQUEST);
		}

		if (e instanceof BadCredentialsException) {
			internalErrorResponse.setData(Data.builder().build());
			internalErrorResponse.setVerdict(JcbErrors.INVALID_CREDENTIALS.getCode());
			internalErrorResponse.setMessage(JcbErrors.INVALID_CREDENTIALS.getMessage());
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (e instanceof BadRequestException) {
			internalErrorResponse.setData(Data.builder().build());
			internalErrorResponse.setVerdict(((BadRequestException) e).getCode());
			internalErrorResponse.setMessage(e.getMessage());
			return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.BAD_REQUEST);
		}
		

		internalErrorResponse.setVerdict("failure");
		internalErrorResponse.setMessage(e.getMessage());
		internalErrorResponse.setData(new Data());

		return new ResponseEntity<InternalErrorResponse>(internalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ServerErrorException.class)
	public ResponseEntity<VechileManagementResponse> handleServerException(ServerErrorException ex,
			HttpServletRequest request) throws Exception {
		JcbLogger.log(false, true, LoggerEventType.THIRD_PARTY_API_CALLING_ERROR,
				new ResponseEntity<VechileManagementResponse>(ex.getVechileManagementResponse(), ex.getStatus()));
		return new ResponseEntity<VechileManagementResponse>(ex.getVechileManagementResponse(), ex.getStatus());
	}

}
