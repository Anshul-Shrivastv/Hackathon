package com.example.hackathon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.hackathon.controller.WelcomeController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WelcomeController.class)
public class WelcomeControllerTest {

	 @Autowired
	 private MockMvc mockMvc;
	 
	    @Test
	    public void main() throws Exception {
	        ResultActions resultActions = mockMvc.perform(get("/"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("welcome"))
	                .andExpect(model().attribute("message", equalTo("World")))
	                .andExpect(content().string(containsString("Hello, World")));

	        MvcResult mvcResult = resultActions.andReturn();
	        ModelAndView mv = mvcResult.getModelAndView();
	        //
	    }

	    // Get request with Param
	    @Test
	    public void hello() throws Exception {
	        mockMvc.perform(get("/hello").param("name", "I Love Java!"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("welcome"))
	                .andExpect(model().attribute("message", equalTo("I Love Java!")))
	                .andExpect(content().string(containsString("Hello, I Love Java!")));
	    }
}
