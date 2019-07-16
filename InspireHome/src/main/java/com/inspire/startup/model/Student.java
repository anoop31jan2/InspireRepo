package com.inspire.startup.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author Anoop
 *
 */

/**
 * The persistent class for the T_STUDENT database table.
 * 
 */

@Entity
@Table(name="T_STUDENT")
@NamedQuery(name="TStudent.findAll", query="SELECT t FROM Student t")
@Getter
@Setter
@NoArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STUDENT_ID")
	private int studentId;

	@Column(name="CLASS_ID")
	private int classId;

	@Column(name="CURRICULUM_ID")
	private int curriculumId;

	@Column(name="PARENT_ID")
	private int parentId;

	@Column(name="ROLL_NO")
	private String rollNo;

	@Column(name="TSCREATED")
	private Timestamp tscreated;

	@Column(name="TSUPDATED")
	private Timestamp tsupdated;

	@Column(name="USER_CREATED")
	private String userCreated;

	@Column(name="USER_UPDATED")
	private String userUpdated;

	
}