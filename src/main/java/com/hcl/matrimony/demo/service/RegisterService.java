package com.hcl.matrimony.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.demo.exception.RecordAlreadyExistException;
import com.hcl.matrimony.demo.model.Profile;
import com.hcl.matrimony.demo.repository.ProfileRepository;

@Service
public class RegisterService {

	@Autowired
	private ProfileRepository profileRepository;

	public void register(Profile profile) {
		Profile existing = profileRepository.findByEmailId(profile.getEmailId());
		profileRepository.save(profile);
		if (existing == null) {
			profileRepository.save(profile);
		} else {
			throw new RecordAlreadyExistException("Already registered with given EmailId");
		}
	}

}