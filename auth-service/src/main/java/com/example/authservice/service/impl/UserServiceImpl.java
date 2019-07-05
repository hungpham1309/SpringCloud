package com.example.authservice.service.impl;

import com.example.authservice.model.AppUser;
import com.example.authservice.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		AppUser user = userRepository.findByName(username);

		if (user != null)
		{
		// Roles in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + user.getRole().toUpperCase());

			// The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
			// And used by auth manager to verify and check user authentication.
			return new User(user.getName(), encoder.encode(user.getPassword()), grantedAuthorities);
		}
		// If user not found. Throw exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
}
