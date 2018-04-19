package com.zup;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.zup.model.dto.CoordenadaDTO;

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoordenadaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalvarPontosInteresseTest {
	
	@Autowired private WebApplicationContext wac;
	@Autowired private Gson gson;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
    
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/*
	 * As coordenadas para cadastro estão fixas como Show, 40, 2,
	 * referente a Nome, posição x e posição y.
	 * 
	 * Caso desejar usar outros valores é necessário substituir os valores
	 * 
	 * 
	 */
	@Test
	public void salvarNovaCoordenada() throws Exception {
		
		String jsonParaSalvar = gson.toJson(new CoordenadaDTO("Show", 40, 2));
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/coordenadas")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(jsonParaSalvar)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isCreated())
				.andDo(print());
	}
	
}
