package com.upgrad.UpgradB11Springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrad.UpgradB11Springboot.entity.Player;
import com.upgrad.UpgradB11Springboot.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
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
	
	@RequestMapping("/savePlayer")
	public String savePlayer()
	{
		Player p1=new Player(7,"Dhoni",300,15000);
		playerService.savePlayer(p1);
		return "Player record addedd successfully";
	}
	
	@RequestMapping("/savePlayer1")
	public Player savePlayer1()
	{
		Player p1=new Player(93,"Bumrah",30,150);
		return playerService.savePlayer(p1);
	}
	
	@RequestMapping("/savePlayerByRequestParam")
	public Player savePlayerByRequestParam(@RequestParam("a") int playerJno, 
			@RequestParam("b")String playerName,
			@RequestParam("c")int matchesPlayed,
			@RequestParam("d")int runsScored
			)
	{
		Player p1=new Player(playerJno,playerName,matchesPlayed,runsScored);
		return playerService.savePlayer(p1);
	}
}
