package com.upgrad.UpgradB11Springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrad.UpgradB11Springboot.entity.Player;
import com.upgrad.UpgradB11Springboot.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	public void savePlayer(Player p1) {
		playerRepository.save(p1);
		
	}
}
