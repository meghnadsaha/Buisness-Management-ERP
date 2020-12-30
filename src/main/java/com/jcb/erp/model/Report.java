package com.jcb.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


import com.jcb.erp.model.Users.UsersBuilder;
import com.jcb.erp.utils.RequiredDocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;



//@Entity
//@DynamicUpdate
//@Table(name = "Report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

	@Id
	private String reportId;
	
	private RequiredDocumentType reportType;
	private List<String> to;
	private List<String> bcc;
	private List<String> cc;
	private String reportTitle;
	private String emailSubject;
	private String emailBody;

	/* Newly Added Field */
	private String emailSender;
	private String emailBodyContentType;
	private String emailAttachmentMimeType;

	private String reportFilePath;
	private String reportFileName;
	private List<String> headers;
	private String sheetName;

}
