package com.hcl.matrimony.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.demo.exception.NoDataFoundException;
import com.hcl.matrimony.demo.model.Profile;
import com.hcl.matrimony.demo.repository.ProfileRepository;

@Service
public class LoginService {

	@Autowired
	private ProfileRepository profileRepository;

	public Profile findByEmailId(Profile profile) {
		Profile exisitngProfile = profileRepository.findByEmailId(profile.getEmailId());
		if (exisitngProfile == null || !exisitngProfile.getPassword().equals(profile.getPassword())) {
			throw new NoDataFoundException("Invalid credentials");
		}
		profile.setId(null);
		profile.setPassword(null);
		return profile;
	}

}
