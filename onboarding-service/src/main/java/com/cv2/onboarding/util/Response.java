package com.cv2.onboarding.util;

import java.util.List;

import com.cv2.onboarding.entity.EntityDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Response {
	private Integer statusCode;
	private String statusMsg;
	private EntityDetails data;
	private List<EntityDetails> datas;
	private String errorCode;
	private String errorMsg;
	
}
