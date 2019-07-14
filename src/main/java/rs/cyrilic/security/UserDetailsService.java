package rs.cyrilic.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import rs.cyrilic.model.Role;
import rs.cyrilic.model.User;
import rs.cyrilic.repository.UserRepository;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {
		log.debug("Authenticating {}", login);
		String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
		User userFromDatabase = userRepository.findOneByUserName(lowercaseLogin);

		List<Role> roles = userRepository.findAuthorities(lowercaseLogin);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		System.out.println("********************************AUTHORITIES " + roles.size());

		for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			GrantedAuthority a = new SimpleGrantedAuthority("ROLE_" + role.getRolName());
			authorities.add(a);
		}

		if (userFromDatabase != null && userFromDatabase.getUserEnabled() != null && userFromDatabase.getUserEnabled() == true) {
			return new org.springframework.security.core.userdetails.User(lowercaseLogin,
					userFromDatabase.getUserPassword() == null ? RandomStringUtils.randomAlphanumeric(32) : userFromDatabase.getUserPassword(), authorities);

		} else {
			throw new UsernameNotFoundException("User " + login + " was not found in the " + "database");
		}
	}
}
