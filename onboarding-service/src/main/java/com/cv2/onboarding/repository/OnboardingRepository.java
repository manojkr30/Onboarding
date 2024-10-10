package com.cv2.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv2.onboarding.entity.EntityDetails;

@Repository
public interface OnboardingRepository extends JpaRepository<EntityDetails, Integer> {	
	public Optional<EntityDetails> findByTinNo (Integer TinNo);
}
