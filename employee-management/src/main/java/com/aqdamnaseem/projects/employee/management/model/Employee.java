package com.aqdamnaseem.projects.employee.management.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = -2917548258719912422L;

	private Long id;
	private String employeeId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private String email;
	private Designation designation;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private Address address;

	/**
	 * @param employeeId
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param gender
	 * @param email
	 * @param designation
	 * @param dateOfBirth
	 * @param dateOfJoining
	 * @param address
	 */
	public Employee(String employeeId, String firstName, String middleName, String lastName, Gender gender,
			String email, Designation designation, Date dateOfBirth, Date dateOfJoining, Address address) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.address = address;
	}

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the employeeId
	 */
	@Column(name = "EMPLOYEE_ID", length = 10, nullable = false, unique = true)
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	@Column(name = "MIDDLE_NAME", length = 50)
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	@ManyToOne
	@JoinColumn(name = "GENDER_ID")
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the email
	 */
	@Column(name = "EMAIL", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the designation
	 */
	@ManyToOne
	@JoinColumn(name = "DESIGNATION_ID", nullable = false)
	public Designation getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	/**
	 * @return the dateOfBirth
	 */
	@Column(name = "BIRTH_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the dateOfJoining
	 */
	@Column(name = "JOINING_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the address
	 */
	@OneToOne
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
