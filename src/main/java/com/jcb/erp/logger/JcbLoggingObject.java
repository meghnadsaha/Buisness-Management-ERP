package com.jcb.erp.logger;

import org.springframework.boot.jackson.JsonComponent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonComponent
public class JcbLoggingObject {
	private String eventName;
	private String timeStamp;
	private Long latency;
	private Object data;
}
