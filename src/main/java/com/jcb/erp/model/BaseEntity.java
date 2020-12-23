package com.jcb.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

	@JsonIgnore
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TS")
	private Date createdTs;

	@JsonIgnore
	@UpdateTimestamp
	@Column(name = "MODIFIED_TS")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date modifiedTs;
}