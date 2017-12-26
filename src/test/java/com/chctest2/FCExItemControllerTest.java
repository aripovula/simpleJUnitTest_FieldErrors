package com.chctest2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

	@RunWith(SpringRunner.class)
	@WebMvcTest(FCExItemController	.class)
	public class FCExItemControllerTest {

		@Autowired
	    WebApplicationContext context;
		
	    @Autowired
	    private MockMvc mockMvc;

	    private FCExItem item;

	    @Test
	    public void testProcessCreationFormHasErrors2() throws Exception {
	        mockMvc.perform(post("/addfc")
	            .param("first", "abc")
	        )
	        		//.andExpect(model().attribute("first", is("")))
	        		.andDo(print())
	        		.andExpect(model().attributeHasFieldErrors("fcexitem", "first"))
	            .andExpect(status().isOk())
	            .andExpect(view().name("itemform"));
	    }
	    
	}
