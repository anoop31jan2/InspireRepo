package com.inspire.startup.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.inspire.startup.util.StringConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = StringConstants.USER_TABLE)
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "INSPIRE_ID")
	    private Long inspireId;

	    @Column(name="MOBILE_NUMBER",unique=true)
	    private String mobileNumber;

	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(name = StringConstants.USER_ROLES,joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	    private Set<Role> roles;

	    @Column(name = "USER_NAME",unique=true)
	    private String userName;

	    @Column(name = "USER_PASSWORD")
	    private String userPassword;

	    @Column(name = "USER_EMAIL",unique=true)
	    private String email;

	    @Column(name = "IS_FIRST_TIME_USER")
	    private Boolean isMaidenLogin;

	    @Column(name = "CREATED_BY")
	    private String createdBy;

	    @Column(name = "UPDATED_BY")
	    private String updatedBy;

	    @Column(name = "CREATED_DATE")  
	    private LocalDateTime createdDate;

	    @Column(name = "UPDATED_DATE")
	    private LocalDateTime updatedDate;

}
