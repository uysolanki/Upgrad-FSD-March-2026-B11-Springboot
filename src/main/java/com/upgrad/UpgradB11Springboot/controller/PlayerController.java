package com.upgrad.UpgradB11Springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.UpgradB11Springboot.entity.Player;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@RequestMapping("/getPlayer")
	public Player getPlayer()
	{
		Player p1=new Player(18,"Virat",100,5000);
		return p1;
	}
	
	@RequestMapping("/getPlayers")
	public List<Player> getPlayers()
	{
		Player p1=new Player(18,"Virat",100,5000);
		Player p2=new Player(45,"Rohit",200,8000);
		Player p3=new Player(7,"Dhoni",300,15000);
		Player p4=new Player(1,"Rahul",50,3000);
		
		List<Player> players=new ArrayList();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		
		return players;
	}
}
