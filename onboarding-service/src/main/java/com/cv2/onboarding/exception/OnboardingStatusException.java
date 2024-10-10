package com.cv2.onboarding.exception;

import com.cv2.onboarding.util.EntityStatus;

public class OnboardingStatusException extends RuntimeException{
	public EntityStatus errorCode;
	public String errorMessage;
	public OnboardingStatusException(EntityStatus errorCode, String errorMessage) {

		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
