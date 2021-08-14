package com.hcl.matrimony.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.matrimony.demo.model.Profile;
import com.hcl.matrimony.demo.service.LoginService;
import com.hcl.matrimony.demo.service.RegisterService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private RegisterService registerService;

	@MockBean
	private LoginService loginService;

	@Test
	public void loginOK() throws Exception {

		Profile p = new Profile();
		p.setEmailId("test@test.com");
		p.setPassword("1234");
		Mockito.when(loginService.findByEmailId(p)).thenReturn(p);

		ObjectMapper objectMapper = new ObjectMapper();

		mvc.perform(post("/matrimony/login/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(p))).andExpect(status().isOk());
	}

}
