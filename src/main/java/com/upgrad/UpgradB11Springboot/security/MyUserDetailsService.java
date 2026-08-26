package com.upgrad.UpgradB11Springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upgrad.UpgradB11Springboot.entity.DBUser;
import com.upgrad.UpgradB11Springboot.repository.DBUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DBUser user= dbUserRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User does not exist");
		
		return new MyUserUpgradB11Decorator(user);
	}

}
