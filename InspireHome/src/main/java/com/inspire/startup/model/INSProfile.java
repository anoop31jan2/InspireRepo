package com.inspire.startup.model;

import java.io.Serializable;
import javax.persistence.*;

import com.inspire.startup.util.StringConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the T_PROFILE database table.
 * 
 */
@Entity
@Table(name=StringConstants.PROFILE_TABLE)
@NamedQuery(name="TProfile.findAll", query="SELECT t FROM INSProfile t")
@Getter
@Setter
@NoArgsConstructor
public class INSProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSP_ID")
	private int inspId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="GENDER")
	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="OCCUPATION")
	private String occupation;

	@Lob
	@Column(name="PICTURE")
	private byte[] picture;

	@Column(name="[QUALIFICATION]")
	private String qualification;

	@Column(name="TSCREATED")
	private Timestamp tscreated;

	@Column(name="TSUPDATED")
	private Timestamp tsupdated;

	@Column(name="USER_CREATED")
	private String userCreated;

	@Column(name="USER_UPDATED")
	private String userUpdated;

	

}