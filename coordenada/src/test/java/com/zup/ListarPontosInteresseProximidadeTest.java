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

/**
 * @author Éderson Gervásio
 *		   edersongervasiosilva@gmail.com
 *  	   linkedin.com/in/edersongs
 *  	   github.com/edersongs	
 *  	   + 55 (34) 9 9272-2350
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoordenadaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListarPontosInteresseProximidadeTest {
	
	@Autowired private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
    
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/*
	 * O ponto de referência para pesquisa está fixo como  x=20, y=10 e distância máxima 10.
	 * 
	 * Caso desejar usar outros valores é necessário substituir os valores
	 * 
	 * 
	 */
	@Test
	public void listarPorProximidade() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders
				.get("/coordenadas/proximidades/20/10/10")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
