package com.upgrad.UpgradB11Springboot.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
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
		
		Player player=new Player();  //dummy Player object
		player.setMp(100);
		player.setPname("Johnson");
		player.setPno(333);
		player.setRs(5000);
		
		when(playerService.getPlayerByPlayerId(333)).thenReturn(player);
		
		mockMvc.perform(get("/player/getPlayerByPlayerId/333"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.mp").value(100))
        .andExpect(jsonPath("$.pname").value("Johnson"));

		
		
}


}
