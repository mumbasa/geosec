package com.security.guard.securitygaurdadmin;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.security.guard.securitygaurdadmin.controller.AdminUserController;
import com.security.guard.securitygaurdadmin.service.AdminUserService;

@SpringBootTest
@WebMvcTest(AdminUserController.class)
class SecuritygaurdadminApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminUserService service;
	
	@Test
	void contextLoads() {
		
		when(service.userExists("bry_lar@yahoo.com")).thenReturn(true);
		try {
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello, Mock")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
