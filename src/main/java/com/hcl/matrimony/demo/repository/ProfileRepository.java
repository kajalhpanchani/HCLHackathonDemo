package com.hcl.matrimony.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.matrimony.demo.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

	Profile findByEmailId(String email);

}