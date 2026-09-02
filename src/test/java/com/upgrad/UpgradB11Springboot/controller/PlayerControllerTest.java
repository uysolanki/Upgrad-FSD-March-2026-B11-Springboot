package com.upgrad.UpgradB11Springboot.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.upgrad.UpgradB11Springboot.entity.Player;
import com.upgrad.UpgradB11Springboot.service.PlayerService;

@WebMvcTest(PlayerController.class)
@AutoConfigureMockMvc(addFilters = false)
class PlayerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private PlayerService playerService;

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void getPlayerById_endpointShouldReturnJson() throws Exception {

		Player player = new Player(); // dummy Player object
		player.setMp(100);
		player.setPname("Johnson");
		player.setPno(333);
		player.setRs(5000);

		when(playerService.getPlayerByPlayerId(333)).thenReturn(player);

		mockMvc.perform(get("/player/getPlayerByPlayerId/333")).andExpect(status().isOk())
				.andExpect(jsonPath("$.mp").value(100)).andExpect(jsonPath("$.pname").value("Johnson"));

	}

	
	@Test
	void getAllPlayers_endpointShouldReturnJson() throws Exception {
		
		Player player1 = new Player(); // dummy Player object
		player1.setPno(1);
		player1.setPname("Virat");
		player1.setMp(100);
		player1.setRs(5000);
		
		
		Player player2 = new Player(); // dummy Player object
		player2.setPno(2);
		player2.setPname("Rohit");
		player2.setMp(200);
		player2.setRs(8000);
		
		List<Player> players=new ArrayList();
		players.add(player1);
		players.add(player2);
		
		when(playerService.getAllPlayers()).thenReturn(players);
		
		mockMvc.perform(get("/player/getAllPlayers")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].mp").value(100)).andExpect(jsonPath("$[0].pname").value("Virat"))
		.andExpect(jsonPath("$[1].mp").value(200)).andExpect(jsonPath("$[1].pname").value("Rohit"));
		
	}
	
	@Test
	void savePlayerByRequestBody_endpointShouldReturnJson() throws Exception {
		String requestJson= """
				{
				    "pno": 17,
				    "pname": "Abd",
				    "mp": 120,
				    "rs": 6000
				}				
				""";
		
		Player player = new Player(); // dummy Player object
		player.setPno(17);
		player.setPname("Abd");
		player.setMp(120);
		player.setRs(6000);
		
		when(playerService.savePlayer(any(Player.class))).thenReturn(player);
		
		mockMvc.perform(post("/player/savePlayerByRequestBody")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)
				).andExpect(status().isOk())
		
		.andExpect(jsonPath("$.mp").value(120)).andExpect(jsonPath("$.pname").value("Abd"));
		
	}	


}
