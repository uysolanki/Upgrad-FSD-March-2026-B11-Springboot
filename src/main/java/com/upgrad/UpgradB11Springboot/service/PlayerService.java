package com.upgrad.UpgradB11Springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.UpgradB11Springboot.entity.Player;
import com.upgrad.UpgradB11Springboot.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	public Player savePlayer(Player p1) {
		return playerRepository.save(p1);
		
	}

	public Player getPlayerByPlayerId(int playerId) {
		Player player=null;
		if(playerRepository.existsById(playerId))
		{
			player=playerRepository.findById(playerId).get();
		}
		return player;
	}

	public List<Player> savePlayers(List<Player> players) {
		return playerRepository.saveAll(players);
	}

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	public void deletePlayerByPlayerId(int playerId) {
		
		if(playerRepository.existsById(playerId))
		{
			playerRepository.deleteById(playerId);
		}
		throw new RuntimeException("Record not found");
		
	}
}
