package com.inspire.startup.model;

import java.io.Serializable;
import javax.persistence.*;

import com.inspire.startup.util.StringConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the T_CLASS database table.
 * 
 */
@Entity
@Table(name=StringConstants.CLASS_TABLE)
@NamedQuery(name="TClass.findAll", query="SELECT t FROM TClass t")
@Getter
@Setter
@NoArgsConstructor
public class TClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLASS_ID")
	private int classId;

	@Column(name="CLASS_END_TIME")
	private Timestamp classEndTime;

	@Column(name="CLASS_MONITOR")
	private int classMonitor;

	@Column(name="CLASS_NAME")
	private String className;

	@Column(name="CLASS_START_TIME")
	private Timestamp classStartTime;

	@Column(name="CLASS_TEACHER")
	private int classTeacher;

	@Column(name="COURSE_ID")
	private int courseId;

	@Column(name="SCHOOL_ID")
	private int schoolId;

	@Column(name="TSCREATED")
	private Timestamp tscreated;

	@Column(name="TSUPDATED")
	private Timestamp tsupdated;

	@Column(name="TT_FORMAT")
	private String ttFormat;

	@Column(name="USER_CREATED")
	private String userCreated;

	@Column(name="USER_UPDATED")
	private String userUpdated;

	
}