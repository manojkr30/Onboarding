package com.cv2.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv2.onboarding.entity.AddressDetails;
@Repository
public interface AddressRepository extends JpaRepository<AddressDetails, Integer> {

}
