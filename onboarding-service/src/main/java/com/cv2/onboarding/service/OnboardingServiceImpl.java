package com.cv2.onboarding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv2.onboarding.entity.EntityDetails;
import com.cv2.onboarding.exception.OnboardingStatusException;
import com.cv2.onboarding.repository.OnboardingRepository;
import com.cv2.onboarding.util.EntityStatus;

@Service
public class OnboardingServiceImpl implements OnboardingService {

	private  OnboardingRepository onboardingRepository;

@Autowired
	public OnboardingServiceImpl(OnboardingRepository onboardingRepository) {
		this.onboardingRepository = onboardingRepository;
	}

	@Override
	public EntityDetails registerEntity(EntityDetails vendor) {

		Optional<EntityDetails>  optionVendor=onboardingRepository.findByTinNo(vendor.getTinNo());

		//Vendor NOT old User
		if(optionVendor.isEmpty())
			return onboardingRepository.save(vendor);

		//Vendor already present in DB
		else {
			EntityDetails vendorInDb = optionVendor.get();

			//IF ACTIVE
			if(vendorInDb.getStatus()== EntityStatus.ACTIVE ) {
				throw new OnboardingStatusException(vendorInDb.getStatus(),"ONB_501");}

			//IF INACTIVE
			else if(vendorInDb.getStatus()== EntityStatus.INACTIVE) {

				throw new OnboardingStatusException(vendorInDb.getStatus(),"ONB_502");
			}

			//IF INPROGRESS
			else if(vendorInDb.getStatus()== EntityStatus.INPROGRESS) {
				throw new OnboardingStatusException(vendorInDb.getStatus(),"ONB_503");}

			//IF BG_FAILED
			else if(vendorInDb.getStatus()== EntityStatus.BG_FAILED) {
				throw new OnboardingStatusException(vendorInDb.getStatus(),"ONB_504");}

			//USER_CANCELLED
			else if(vendorInDb.getStatus()== EntityStatus.USER_CANCELLED) {
				vendor.setId(vendorInDb.getId());
				return onboardingRepository.save(vendor);
			}
		}
		return null;

	}

	@Override
	public EntityDetails getEntityById(Integer id) {
		return onboardingRepository.findById(id).get();
	}

	@Override
	public List<EntityDetails> getAllEntitys() {
		return onboardingRepository.findAll();
	}

	@Override
	public EntityDetails updateEntity(EntityDetails entity) {
		return onboardingRepository.save(entity);
	}



	@Override
	public EntityDetails updateEntityStatus(Integer id, EntityStatus status) {
		EntityDetails updateStatusEntity=onboardingRepository.findById(id).get();
		updateStatusEntity.setStatus(status);
		return  onboardingRepository.save(updateStatusEntity);
	}



}
