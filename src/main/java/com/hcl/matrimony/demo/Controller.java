package com.hcl.matrimony.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.demo.model.Profile;
import com.hcl.matrimony.demo.service.LoginService;
import com.hcl.matrimony.demo.service.RegisterService;

@RestController
@RequestMapping("/matrimony")
public class Controller {

	@Autowired
	RegisterService registerService;

	@Autowired
	LoginService loginService;

	@GetMapping(value = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity("test connection", HttpStatus.OK);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody Profile profile) {
		registerService.register(profile);
		return new ResponseEntity("User registered successfully", HttpStatus.CREATED);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<Profile> login(@RequestBody Profile login) {
		Profile profile = loginService.findByEmailId(login);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	@GetMapping(value = "/getprofile")
	public ResponseEntity<Profile> getProfile() {
		Profile p = new Profile();
		p.setCaste("Hindu");
		p.setCountry("India");
		p.setDob(new Date());
		p.setEmailId("kajal@test.com");
		p.setGender("F");
		p.setMobileNo("34234324");
		p.setMotherTongue("Hindi");
		p.setName("Kinjal");
		p.setProfileFor("Friend");
		p.setReligion("Hindu");
		return new ResponseEntity<Profile>(p, HttpStatus.OK);
	}

}