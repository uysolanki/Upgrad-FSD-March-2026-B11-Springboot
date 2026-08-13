package com.upgrad.UpgradB11Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upgrad.UpgradB11Springboot.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	
}
