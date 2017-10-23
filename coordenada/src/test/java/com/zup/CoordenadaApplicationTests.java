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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoordenadaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoordenadaApplicationTests {
	
	@Autowired private WebApplicationContext wac;
	@Autowired private Gson gson;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
    
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/**
	 * 
	 * 
	 * 		O mostra toda as coordenadas cadastradas.
	 * 
	 * 		No log do Tomcat mostra toda requisição atráves do objeto MockHttpServletRequest,
	 * 		além de testar o status de retorno da requisição se está coerente com esperado.
	 * 
	 * @throws Exception
	 */
	@Test
	public void listarCoordenadas() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders
				.get("/coordenadas")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/**
	 * 
	 * 		O método mostra as coordenadas mais próximas de acordo com os parâmetros passados.
	 * 		
	 * 		No log do Tomcat mostra toda requisição atráves do objeto MockHttpServletRequest,
	 * 		além de testar o status de retorno da requisição se está coerente com esperado.
	 * 
	 * @throws Exception
	 */
	@Test
	public void listarPorProximidade() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders
				.get("/coordenadas/proximidades/5/3/10")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/**
	 * 
	 * 		O método salva um nova coordenada.
	 * 
	 * 		No log do Tomcat mostra toda requisição atráves do objeto MockHttpServletRequest,
	 * 		além de testar o status de retorno da requisição se está coerente com esperado.
	 * 
	 * 
	 * @throws Exception
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
