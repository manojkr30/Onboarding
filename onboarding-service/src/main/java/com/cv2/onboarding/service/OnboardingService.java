package com.cv2.onboarding.service;

import java.util.List;

import com.cv2.onboarding.entity.EntityDetails;
import com.cv2.onboarding.util.EntityStatus;

public interface OnboardingService {

	EntityDetails registerEntity(EntityDetails entity);

	EntityDetails getEntityById(Integer id);

	List<EntityDetails> getAllEntitys();

	EntityDetails updateEntity(EntityDetails entity);

	EntityDetails updateEntityStatus(Integer id, EntityStatus status);

}
