package com.joy;

import com.joy.controller.ConstellationController;
import com.joy.utils.SOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConstellationApplicationTests {
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new ConstellationController()).build();
	}
	@Test
	public void getHello() throws Exception {
		String url = "/say";//访问url
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
		//访问返回状态
		int status = mvcResult.getResponse().getStatus();
		//接口返回结果
		String content = mvcResult.getResponse().getContentAsString();
		SOUtils.print("content="+content);

	}

}
