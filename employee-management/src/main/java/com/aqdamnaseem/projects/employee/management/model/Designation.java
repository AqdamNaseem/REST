package com.aqdamnaseem.projects.employee.management.model;

public class Designation {

	private Long id;
	private String code;
	private String name;

	public enum DesignationEnum {

		SOFTWARE_ENGINEER("SOFTWARE_ENGINEER"), 
		SENIOR_SOFTWARE_ENGINEER("SENIOR_SOFTWARE_ENGINEER"), 
		MODULE_LEAD("MODULE_LEAD"), 
		TECHNICAL_LEAD("TECHNICAL_LEAD"), 
		PROJECT_MANAGER("PROJECT_MANAGER"), 
		SENIOR_PROJECT_MANAGER("SENIOR_PROJECT_MANAGER"), 
		ACCOUNT_MANAGER("ACCOUNT_MANAGER"), 
		VERTICAL_HEAD("VERTICAL_HEAD"), 
		CHIEF_FINANCE_OFFICER("CHIEF_FINANCE_OFFICER"), 
		CHIEF_EXECUTIVE_OFFICER("CHIEF_EXECUTIVE_OFFICER");

		private String code;

		private DesignationEnum(String code) {
			this.code = code;
		}
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
