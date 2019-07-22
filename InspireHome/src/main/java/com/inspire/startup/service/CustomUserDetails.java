package com.inspire.startup.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inspire.startup.model.User;


/**
 * @author Anoop
 *
 */
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;
	
	private String mobileNumber;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;
	
	@JsonIgnore
	private boolean isFirstTimeLogin;

	private boolean isActive;


	public boolean isFirstTimeLogin() {
		return isFirstTimeLogin;
	}

	public void setFirstTimeLogin(boolean isFirstTimeLogin) {
		this.isFirstTimeLogin = isFirstTimeLogin;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	private Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(Integer id,String username, String email,String mobileNumber, String password, Collection<? extends GrantedAuthority> authorities,
			boolean isFirstTimeLogin,boolean isActive) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.isFirstTimeLogin = isFirstTimeLogin;
		this.mobileNumber = mobileNumber;
		this.isActive=isActive;
	}

	public static CustomUserDetails create(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
		new SimpleGrantedAuthority("ROLE_"+role.getRole())
				).collect(Collectors.toList());

		return new CustomUserDetails(
				user.getInspireId(),
				user.getUserName(),
				user.getEmail(),
				user.getMobileNumber(),
				user.getUserPassword(),
				authorities,
				user.getIsMaidenLogin(),
				user.getIsActive()
				);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		return isActive;
	}


	public Integer getId() {
		return id;
	}



	public String getEmail() {
		return email;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomUserDetails that = (CustomUserDetails) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

}
